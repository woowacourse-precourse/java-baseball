package baseball;

import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);
    static final void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static final String getUserInput(){
        return scanner.nextLine();
    }
}
