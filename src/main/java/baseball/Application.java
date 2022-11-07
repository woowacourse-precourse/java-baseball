package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        Randoms.pickNumberInRange(1, 9);

        startGamePrint();
        //while
        while(true){
            //컴퓨터 수 생성

            getNumberPrint();
            gameOverPrint();
            gameContinuePrint();



        }

    }

    private static void getNumberPrint() {
        System.out.print("숫자를 입력해주세요. : ");
    }

    private static void gameOverPrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private static void gameContinuePrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void startGamePrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
