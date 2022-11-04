package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        while (cont) {
            new BaseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
             cont = sc.nextInt() == 1 ? true : false;
        }
    }
}
