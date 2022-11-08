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

    public void printFinishComment(){
        System.out.println("3스트라이크");
        System.out.println(comments.get("FINISH"));
    }

    public void printNothingComment(){
        System.out.println("낫싱");
    }

    public void printResultComment(int ball, int strike){

        System.out.println(printBallComment(ball)+printStrikeComment(strike));
    }

    private String printBallComment(int ball){
        if(ball == 0)
            return "";
        return ball+"볼 ";
    }

    private String printStrikeComment(int strike){
        if(strike ==0)
            return "";
        return strike+"스트라이크";
    }
}
