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

        System.out.println("낫싱");
    }
}
