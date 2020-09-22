public class Fact {
    String _id;
    String text;
    String type;
    User user;
    Integer upvotes;
    Integer userUpvoted;

    public Fact() {

    }

    public String get_id() {
        return _id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public Integer getUserUpvoted() {
        return userUpvoted;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public void setUserUpvoted(Integer userUpvoted) {
        this.userUpvoted = userUpvoted;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "Fact {" +
                "_id='" + _id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", upvotes=" + upvotes +
                ", userUpvotes=" + userUpvoted +
                '}';
    }
}
