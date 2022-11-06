package baseball;

import java.util.Map;

public class Comments {
    private Map<String, String> comments;

    public Comments(Map<String, String> comments){
        this.comments = comments;
    }

    public void printStartComment(){
        System.out.println(comments.get("START"));
    }

    public void printInputComment(){
        System.out.println(comments.get("INPUT"));
    }
}
