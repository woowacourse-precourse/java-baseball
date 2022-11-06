package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printChoiceEndOrNewGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printPleaseInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printStrike(int num){
        System.out.println(num + "스트라이크");
    }

    public static void printBall(int num){
        System.out.println(num + "볼");
    }

    public static void printBallAndStrike(int ball, int strike){
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void printNothing(){
        System.out.println("낫싱");
    }

    public static void printCollect(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static String getUserInput() {
        return Console.readLine();
    }
}
