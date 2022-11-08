package baseball;

import java.util.*;
import static baseball.Function.*;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    protected static List<Integer> Answer;
    protected static String ResponseOfRestart;

    public Player() {}

    public static void resetAll(){
        Answer = new ArrayList<>();
        ResponseOfRestart = "";
    }
    public static void isValidAnswer(String input){
        if(input.length() != 3 || !isInteger(input) || !isPositiveNumber(input) || !isDifferentNumbers(changeStringtoList(input))){
            throw new IllegalArgumentException("게임 종료");
        }
    }
    public static void guessAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        isValidAnswer(input);
        Answer = changeStringtoList(input);
    }

    public static void responseRestart(){
        ResponseOfRestart = Console.readLine();
        if(!ResponseOfRestart.equals("1") && !ResponseOfRestart.equals("2")){
            throw new IllegalArgumentException("게임 종료");
        }
    }

}
