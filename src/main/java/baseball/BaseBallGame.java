package baseball;

import java.util.List;
import java.util.Objects;

public class BaseBallGame {

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void userInput() {
        System.out.print("숫자를 입력해주세요  :  ");
    }

    public int countBall(List<Integer> userInputArr, List<Integer> computerNumbers) {

        int ball = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (!userInputArr.get(i).equals(computerNumbers.get(i)) && computerNumbers.contains(userInputArr.get(i))) {
                ball++;
            }
        }

        return ball;
    }

    public int countStrike(List<Integer> userInputArr, List<Integer> computerNumbers) {
        int strike = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (Objects.equals(userInputArr.get(i), computerNumbers.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    public void makeHint(int ballCount, int strikeCount) {

        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }

}
