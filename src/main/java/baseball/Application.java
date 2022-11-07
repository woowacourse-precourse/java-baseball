package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    enum BaseballStatus {
        STRIKE,
        BALL
    }

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

    public static void main(String[] args) {
        // 상대방(컴퓨터)의 입력 숫자
        String computer = generateComputer();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            // TODO: 종료 예외처리
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            if(userInput.equals("1")) {
                computer = generateComputer();
                continue;
            }
            if(userInput.equals("2")) break;

            String judgeString = getJudgeString(computer, userInput);
            if (judgeString.equals("3스트라이크")) {
                System.out.println(judgeString);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            } else {
                System.out.println(judgeString);
            }
        }
    }

}
