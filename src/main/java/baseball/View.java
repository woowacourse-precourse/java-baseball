package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    static final void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static final void printChoiceEndOrNewGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static final void printPleaseInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    static final void printStrike(int num){
        System.out.println(num + "스트라이크");
    }

    static final void printBall(int num){
        System.out.println(num + "볼");
    }

    static final void printBallAndStrike(int ball, int strike){
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    static final void printNothing(){
        System.out.println("낫싱");
    }

    static final void printCollect(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static final String getUserInput() {
        return Console.readLine();
    }
}
