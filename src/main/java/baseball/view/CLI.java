package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class CLI implements View{
    @Override
    public void initialStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public String requestGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
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
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public boolean askRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
