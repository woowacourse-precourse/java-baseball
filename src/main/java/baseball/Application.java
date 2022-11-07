package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String getJudgeString(String computer, String userInput) {
        int strike = 0, ball = 0;
        String judgeString = "";
        List<Character> computerNumbers =
                computer.chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toList());

        for (int i = 0; i < userInput.length(); i++) {
            char input = userInput.charAt(i);
            if (computerNumbers.contains(input) && computerNumbers.indexOf(input) == i) strike++;
            if (computerNumbers.contains(input) && computerNumbers.indexOf(input) != i) ball++;
        }

        if (strike == 3) judgeString = "3스트라이크";
        else {
            if (ball != 0) judgeString += (char) (ball + '0') + "볼 ";
            if (strike != 0) judgeString += (char) (strike + '0') + "스트라이크";
            if (ball == 0 && strike == 0) judgeString = "낫싱";
        }
        return judgeString;
    }

    public static String generateComputer() {
        String computer = "";
        while (computer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            char randomNumberToChar = (char) (randomNumber + '0');
            if (!computer.contains(Character.toString(randomNumberToChar)))
                computer += randomNumberToChar;
        }
        return computer;
    }

    public static void userInputValidator(String userInput) {
        // 길이 검증
        int inputLength = userInput.length();
        if (inputLength != 3 && inputLength != 1) throw new IllegalArgumentException();
        // 주어진 문자열이 모두 정수형태로 이루어져 있는지 검증
        for (int i = 0; i < inputLength; i++) {
            char tmp = userInput.charAt(i);
            if (!('1' <= tmp && tmp <= '9')) throw new IllegalArgumentException();
        }
        return;
    }

    public static String getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        userInputValidator(userInput);

        return userInput;
    }

    enum GameState {
        RESTART,
        PROGRESS,
        EXIT
    }

    public static GameState checkGameState(String userInput) {
        if (userInput.equals("1")) return GameState.RESTART;
        if (userInput.equals("2")) return GameState.EXIT;
        return GameState.PROGRESS;
    }

    public static void main(String[] args) {
        String computer = generateComputer();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            String userInput = getUserInput();

            GameState gameState = checkGameState(userInput);
            boolean exitFlag = false;

            switch (gameState) {
                case RESTART:
                    computer = generateComputer();
                    continue;
                case EXIT:
                    exitFlag = true;
                    break;
                case PROGRESS:
                    String judgeString = getJudgeString(computer, userInput);
                    if (judgeString.equals("3스트라이크")) {
                        System.out.println(judgeString);
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    } else System.out.println(judgeString);
                default:
            }
            if (exitFlag) break;
        }
    }

}
