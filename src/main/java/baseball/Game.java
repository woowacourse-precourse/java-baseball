package baseball;

import java.util.Arrays;
import java.util.List;

public class Game {

    List<Integer> computerNumber;
    List<Integer> userNumberList;
    final int NUMBER_SIZE = 3;

    public Game(List<Integer> computerNumber, List<Integer> userNumberList) {
        this.computerNumber = computerNumber;
        this.userNumberList = userNumberList;
    }


    public int play() {
        int strike = 0;
        int ball = 0;
        List<Integer> strikeBall = findStrikeBall(computerNumber, userNumberList);
        strike = strikeBall.get(0);
        ball = strikeBall.get(1);
        printGameResult(strike, ball);
        return strike;
    }


    public List<Integer> findStrikeBall(List<Integer> computerNumber,
        List<Integer> userNumberList) {
        int strike = 0;
        int ball = 0;
        for (int index = 0; index < NUMBER_SIZE; index++) {
            int nowIndexComputerNumber = computerNumber.get(index);
            int nowIndexUserNumber = userNumberList.get(index);
            if (isSame(nowIndexComputerNumber, nowIndexUserNumber)) {
                strike++;
            } else {
                ball = getBall(computerNumber, nowIndexUserNumber, ball, index);
            }
        }
        return Arrays.asList(strike, ball);
    }


    public int getBall(List<Integer> computerNumber, int nowIndexUserNumber, int ball, int index) {
        for (int compare_index = 0; compare_index < NUMBER_SIZE; compare_index++) {
            int otherIndexComputerNumber = computerNumber.get(compare_index);
            if (index == compare_index) {
                continue;
            }
            if (isSame(nowIndexUserNumber, otherIndexComputerNumber)) {
                ball++;
            }
        }
        return ball;
    }

    public boolean isSame(int user, int computer
    ) {
        return user == computer;
    }

    public void printGameResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }
    }

}
