import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostCrud extends TestBase {

    public String body = """
             {
                    "userId": 1,
                    "title": "test title",
                    "body": "test body"
             }
            """;

    @Test
    public void shouldDeletePost() {
        given().
                pathParams("id", "1").
                when().
                delete(POSTS + "/{id}").
                then().
                statusCode(200);
    }

    @Test
    public void shouldPatchPost() {
        given()
                .pathParams("id", "1")
                .body(body)
                .contentType(ContentType.JSON).
                when()
                .patch(POSTS + "/{id}")
                .then().statusCode(200);
    }

    @Test
    public void shouldPutPost() {
        given()
                .pathParams("id", "1")
                .body(body)
                .contentType(ContentType.JSON).
                when()
                .put(POSTS + "/{id}")
                .then().statusCode(200);
    }
}
