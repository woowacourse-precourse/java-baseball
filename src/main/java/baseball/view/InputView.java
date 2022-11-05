package baseball.view;

import java.util.Scanner;

public class InputView {

    public static void startProgramView(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public static String inputNumbersView(Scanner scanner){
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }


    public static String inputRestartView(Scanner scanner){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }
}
