package baseball;

import java.util.List;

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
}
