package baseball;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class AskRepeatGame {
    //게임을 다시 시작할건지 물어보는 함수
    public static int askReGame(Scanner scan){
        int repeat;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        repeat = parseInt(scan.nextLine());

        return repeat;
    }
}
