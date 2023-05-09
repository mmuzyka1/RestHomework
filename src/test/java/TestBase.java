import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String POSTS = BASE_URL + "/posts";

    @BeforeMethod
    public void setup() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}