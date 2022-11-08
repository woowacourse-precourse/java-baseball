package baseball.view;

import java.util.List;

public class CLI implements View{
    @Override
    public void initialStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void requestGuess() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void result(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    @Override
    public void end() {

    }

    @Override
    public void askRetry() {

    }
}
