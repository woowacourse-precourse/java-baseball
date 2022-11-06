package baseball;

import java.util.*;
import static baseball.Function.*;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    protected static List<Integer> Answer;

    public Player() {}

    public static void isValidAnswer(String input){
        if(input.length() != 3 || !isInteger(input) || !isPositiveNumber(input) || !isDifferentNumbers(changeStringtoList(input))){
            throw new IllegalArgumentException("게임종료");
        }
    }
    public static void guessAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        try {
            isValidAnswer(input);
            Answer = changeStringtoList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
