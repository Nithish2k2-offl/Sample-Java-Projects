package SocialMediaApp;

import java.util.*;

public class Post {
    String content;
    String author;
    List<String> comments = new ArrayList<>();
    List<String> likes = new ArrayList<>();
    boolean commentsAllowed;
    boolean likesAllowed;
    public Post(String content, User author) {
        this.content = content;
        //this.author = author;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.commentsAllowed = true;
        this.likesAllowed = true;
    }


    public void editContent(String newContent) {

    }

    public void addComment(String comment) {

    }

    public void addLike(String user) {

    }

    public void removeLike(String user) {

    }

    public void toggleCommentsAllowed() {
    }

    public void toggleLikesAllowed() {

    }

}
