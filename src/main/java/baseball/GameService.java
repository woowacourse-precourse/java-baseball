package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    int strike = 0; int ball = 0;

    public Integer countStrike(List<Integer> randomNumber, List<Integer> userNumber){
        for (int index = 0; index < 3; index++) {
            if (randomNumber.get(index).equals(userNumber.get(index))) {
                strike += 1;
            }
        }
        return strike;
    }

    public Integer countBall(List<Integer> randomNumber, List<Integer> userNumber) {
        for (int index = 0; index < 3; index++) {
            if (randomNumber.contains(userNumber.get(index))) {
                ball += 1;
            }
        }
        ball = ball - strike;
        return ball;
    }

    public void printResult() {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            strike = 0;
            ball = 0;
            return;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
            if (strike == 0) {
                System.out.println();
            }
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        strike = 0;
        ball = 0;
    }

    public boolean checkRestart(){
        List<String> expectedInput = new ArrayList<>(Arrays.asList("1", "2"));
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputRestart = Console.readLine();
        if (!(expectedInput.contains("1") || expectedInput.contains("2"))) {
            throw new IllegalArgumentException();
        }
        if (inputRestart.equals("2")) {
            return true;
        }
        return false;
    }
}
