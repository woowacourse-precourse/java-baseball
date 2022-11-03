package baseball;

import java.lang.System;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static ArrayList<Integer> target = null;
    private static ArrayList<Integer> user = null;
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
        generate();
        while (true) {

        }
    }

    private static void generate() {
        target.clear();
        for (int i = 0; i < 3; ++i)
            target.add(Randoms.pickNumberInRange(1, 9));
    }

    private static void read() {
        user.clear();
        String input = Console.readLine();
        if (input.length() != 3)
            invalid();
        for (int i = 0; i < 3; ++i) {
            if (Character.isDigit(input.charAt(i)) == false)
                invalid();
            user.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    private static void invalid() {
        throw new IllegalArgumentException();
    }
}
