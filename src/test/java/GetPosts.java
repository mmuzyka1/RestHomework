import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class GetPosts extends TestBase{

    @Test
    public void shouldGetAllPosts() {
        Response response =
        when().
                get(POSTS).
        then().
                statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertThat(jsonPath.get("[0].id").toString()).isEqualTo("1");
        Assertions.assertThat(jsonPath.get("[1].title").toString()).isEqualTo("qui est esse");
    }

    @Test
    public void shouldGetPostWithId1() {
        Response response =
        given().
                pathParams("id", "1").
                when().
                get(POSTS + "/{id}").
                then().
                statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/postSchema.json")))
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertThat(jsonPath.get("id").toString()).isEqualTo("1");
        Assertions.assertThat(jsonPath.get("title").toString()).isEqualTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    @Test
    public void shouldGetPostForUser3() {
        Response response =
                given().
                        queryParam("userId", "3").
                        when().
                        get(POSTS).
                        then().
                        statusCode(200)
                        .extract()
                        .response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertThat(jsonPath.get("[0].id").toString()).isEqualTo("21");
        Assertions.assertThat(jsonPath.get("[0].title").toString()).isEqualTo("asperiores ea ipsam voluptatibus modi minima quia sint");
    }
}
