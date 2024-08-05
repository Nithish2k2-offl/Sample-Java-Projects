package SocialMediaApp;

import java.util.*;

public class User {
    private String username;
    private List<Post> posts;
    private List<Comment> comments;
    private List<Like> likes;

    public User(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
    }

    public void createPost(String content) {
        Post newpost = new Post(content, this);
        this.posts.add(newpost);
    }

    private void commentPost(String post, String content) {

    }

    private void likePost(String post) {

    }

    private void unlikePost(String post) {

    }

}
