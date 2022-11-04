package baseball;

import java.lang.System;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static ArrayList<Integer> target = null;
    private static ArrayList<Integer> user = null;
    private static String result = null;
    private static Integer strike = 0;
    private static Integer ball = 0;
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
            read();
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
            if (!Character.isDigit(input.charAt(i)) || input.charAt(i) == '0')
                invalid();
            user.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    private static void check() {
        result = new String("");
        check_strike();
        check_ball();
        if (strike > 0)
            result += Character.toString(strike) + "스트라이크";
        if (strike == 3)
            result += '\n' + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        if (ball > 0) {
            if (strike > 0)
                result = ' ' + result;
            result = Character.toString(ball) + '볼';
        }
        if (result.length() == 0)
            result = "낫싱";
    }

    private static void check_strike() {
        strike = 0;
        // check strike
        for (int i = 0; i < 3; ++i) {
            if (target.get(i) == user.get(i)) {
                strike++;
                // mark as strike
                target.set(i, 0);
                user.set(i, 0);
            }
        }
    }

    private static void check_ball() {
        ball = 0;
        for (int i = 0; i < 3; ++i) {
            int current_digit = user.get(i);
            if (current_digit == 0)
                continue;
            if (i != 0 && target.get(0) == current_digit) {
                user.set(i, 0);
                target.set(0, 0);
            }
            else if (i != 1 && target.get(1) == current_digit) {
                user.set(i, 0);
                target.set(1, 0);
            }
            else if (i != 2 && target.get(2) == current_digit) {
                user.set(i, 0);
                target.set(2, 0);
            }
        }
    }

    private static void invalid() {
        throw new IllegalArgumentException();
    }
}
