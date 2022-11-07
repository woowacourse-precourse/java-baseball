package baseball;

import baseball.model.JudgeLogic;
import baseball.model.ResultMaker;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    public static List<Integer> getPlayerNumbers() {
        List<Integer> playerNumbers = new ArrayList<>();
        String inputNumberString = Console.readLine();

        validateEmpty(inputNumberString);
        validateNumber(inputNumberString);
        validateSize(inputNumberString);
        validateOverlap(inputNumberString);

        for(int i=0; i<inputNumberString.length() ; i++) {
            playerNumbers.add(Integer.parseInt(inputNumberString.substring(i,i+1)));
        }
        return playerNumbers;
    }

    private static void validateEmpty(String numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
    }

    private static void validateSize(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력하십시오");
        }
    }

    private static void validateNumber(String numbers) {
        if (!numbers.matches("^[1-9]+$")) {
            throw new IllegalArgumentException("1~9의 숫자만 입력하실수 있습니다.");
        }
    }

    private static void validateOverlap(String numbers) {
        Set<Character> overlapInspector = new HashSet<>();
        for (char numChar : numbers.toCharArray()) {
            overlapInspector.add(numChar);
        }
        if (overlapInspector.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
