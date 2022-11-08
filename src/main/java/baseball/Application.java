package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        startNumberBaseballGame();
    }

    static List<Integer> answerRandomNumber = new ArrayList<>();
    static void startNumberBaseballGame(){

    }

    static Integer stringToInteger(String input){
        try{
            Integer answer = Integer.parseInt(input);
            return answer;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
