package stepic.primitive;


import java.util.List;

class Tweet {
    private String id;
    private int likeCount;
    private String lang;
    private List<String> comments;

    public Tweet(String id, int likeCount, String lang, List<String> comments) {
        this.id = id;
        this.likeCount = likeCount;
        this.lang = lang;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    // constructors and getters
}