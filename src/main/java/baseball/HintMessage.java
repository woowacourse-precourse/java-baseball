package baseball;

public class HintMessage {

    public static String getMessage(String hint){
        String message = "";
        char strike = hint.charAt(0);
        char ball = hint.charAt(1);
        if(strike == '0' && ball == '0'){
           return "낫싱";
        }
        if(ball > '0'){
            message += ball+"볼 ";
        }
        if(strike > '0'){
            message += strike+"스트라이크";
        }
        return message;
    }

    public static void print(String hint){
        System.out.println(getMessage(hint));
    }
}
