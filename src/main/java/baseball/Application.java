package baseball;

import baseball.model.JudgeLogic;
import baseball.model.NumberGenerator;
import baseball.model.ResultMaker;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        String gameStartOrStop = "1";
        while (gameStartOrStop.equals("1")) {
            NumberGenerator comNumberGenerator = new NumberGenerator();
            List<Integer> computerNumbers = comNumberGenerator.generateRandomNumbers();

            ResultMaker resultMaker = new ResultMaker();

            String gameResult = "";
            while (!gameResult.equals("3스트라이크")) {
                List<Integer> playerNumbers = getPlayerNumbers();
                gameResult = resultMaker.compare(computerNumbers, playerNumbers);
                System.out.println(gameResult);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStartOrStop = Console.readLine();
        }
        return;
    }

    public static List<Integer> getPlayerNumbers() {
        List<Integer> playerNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumberString = Console.readLine();

        validateEmpty(inputNumberString);
        validateNumber(inputNumberString);
        validateSize(inputNumberString);
        validateOverlap(inputNumberString);

        for(int i=0; i<inputNumberString.length() ; i++) {
            playerNumbers.add(Integer.parseInt(inputNumberString.substring(i,i+1)));
        for (int i = 0; i < inputNumberString.length(); i++) {
            playerNumbers.add(Integer.parseInt(inputNumberString.substring(i, i + 1)));
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
