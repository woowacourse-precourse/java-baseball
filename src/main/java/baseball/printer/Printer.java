package baseball.printer;

import baseball.result.Result;

public class Printer {

    public void startGame() {
        System.out.println("숫자 야구 게임입니다.");
    }

    public void requestNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void restartGame(){
        System.out.println("게임을 새로시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public void printResult(Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return ;
        }

        if (result.getBall() != 0) {
            System.out.print(result.getBall() + "볼 ");
        }

        if (result.getStrike() != 0) {
            System.out.print(result.getStrike() + "스트라이크");
        }
        System.out.println();
    }

    public void noticeWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
