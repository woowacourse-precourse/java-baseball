package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        int quitGame = 0;
        do{

            while(quitGame != 1 || quitGame !=2 ) {
                System.out.println("1 또는 2 만 입력해주십시오");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                quitGame = sc.nextInt();
            }
        } while(quitGame != 2); //1입력시 게임 재시작, 2 입력시 게임 종료

        System.out.println("게임을 종료합니다.");
    }
}
