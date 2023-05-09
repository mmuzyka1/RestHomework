public class Post {

    public String userId;
    public String id;
    public String title;
    public String body;

    public Post(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Post() {
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
