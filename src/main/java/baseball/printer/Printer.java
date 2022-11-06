package baseball.printer;

import baseball.result.Result;

public class Printer {

    public void greet() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void requestUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printBallCount(Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        if (result.getBallCount() != 0) {
            System.out.println(result.getBallCount() + "볼 ");
        }
        if (result.getStrikeCount() != 0) {
            System.out.println(result.getStrikeCount() + "스트라이크");
        }
        System.out.println();
    }

    void printWin(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
