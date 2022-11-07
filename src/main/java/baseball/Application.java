package baseball;

import java.util.Scanner;


public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner scanner = new Scanner(System.in);
        Controller.run(scanner);
    }
}
