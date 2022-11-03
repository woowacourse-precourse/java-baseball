package baseball;

import java.lang.*;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            // Start game
            start_game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if (input.equals("1"))
                continue;
            else if (input.equals("2"))
                break;
            else
                invalid();
        } while (true);
    }

    private static void start_game() {
    }

    private static void invalid() {
        throw new IllegalArgumentException();
    }
}
