package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                        .mapToObj(e -> (char)e)
                        .collect(Collectors.toList());

        for(int i=0; i<userInput.length(); i++) {
            char input = userInput.charAt(i);
            if(computerNumbers.contains(input) && computerNumbers.indexOf(input) == i) strike++;
            if(computerNumbers.contains(input) && computerNumbers.indexOf(input) != i) ball++;
        }

        if(strike == 3) judgeString = "3스트라이크";
        else if(ball != 0) judgeString += (char)(ball + '0') + "볼 ";
        else if(strike != 0) judgeString += (char)(strike + '0') + "스트라이크";
        else if(ball == 0 && strike == 0) judgeString = "낫싱";

        return judgeString;
    }

    public static void main(String[] args) {
        // 상대방(컴퓨터)의 입력 숫자
        String computer = "";
        while (computer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            char randomNumberToChar = (char) (randomNumber + '0');
            if (computer.contains(Character.toString(randomNumberToChar)))
                computer += randomNumberToChar;
        }

        // 유저의 입력들
        for (String userInput : args) {
            // TODO: 재시작 / 종료 예외처리
            String judgeString = getJudgeString(computer, userInput);
        }
    }
}
