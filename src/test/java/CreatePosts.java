import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePosts extends TestBase {

    @Test
    public void shouldCreatePost() {
        Post post = new Post("1", "test", "test123456");

        given().
                body(post).
                contentType(ContentType.JSON).
        when().
                post(POSTS).
        then().
                statusCode(201);
    }
}
