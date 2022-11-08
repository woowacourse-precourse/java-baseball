package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public static void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printRequestNumber(){
        String input = Console.readLine();
    }

    public static void printGameResult(int strikeCounter, int ballCounter){
        if (strikeCounter > 0 && ballCounter > 0){
            System.out.println(ballCounter+"볼"+" "+strikeCounter+"스트라이크");
        }
        if (strikeCounter > 0 & ballCounter == 0){
            System.out.println(strikeCounter+"스트라이크");
        }
        if (strikeCounter == 0 & ballCounter > 0){
            System.out.println(ballCounter+"볼");
        }
        if (strikeCounter == 0 & ballCounter == 0){
            System.out.println("낫싱");
        }
    }

    public static void printGameClear(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static String printAskingRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input;
    }
}
