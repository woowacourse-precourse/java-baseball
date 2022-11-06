package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class Application {
    static int three_strike = 0;
    static int first_game = 1;

    static void random_number_generate(ArrayList<Integer> answer) {
        while (answer.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    static ArrayList<Integer> parse_string_into_integer(String guess) {
        int guess_int_format = Integer.parseInt(guess);
        ArrayList<Integer> parsed = new ArrayList<>();

        for (int divisor = 100; divisor != 0; guess_int_format %= divisor, divisor /= 10) {
            parsed.add(guess_int_format / divisor);
        }
        return parsed;
    }

    static boolean guess_validity_check(String guess) throws IllegalArgumentException {
        Integer guess_int_format = Integer.parseInt(guess);
        if (guess_int_format < 123 || guess_int_format > 987) {
            throw new IllegalArgumentException("범위를 준수하지 않았습니다.");
        }

        ArrayList<Integer> guess_parsed = parse_string_into_integer(guess);
        for (Integer toCheck : guess_parsed) {
            if (toCheck == 0) {
                throw new IllegalArgumentException("1부터 9까지의 수로만 이루어져야 합니다.");
            }
        }

        Set<Integer> unique_element_only = new HashSet<>(guess_parsed);
        if (unique_element_only.size() != guess_parsed.size()) {
            throw new IllegalArgumentException("숫자의 중복이 있습니다.");
        }
        return true;
    }

    static ArrayList<Integer> count_ball_and_strike(ArrayList<Integer> guessList, ArrayList<Integer> answers) {
        ArrayList<Integer> ball_strike_cnt = new ArrayList<>() {{
            add(0);
            add(0);
        }};
        for (int idx = 0; idx < guessList.size(); idx++) {
            int guess = guessList.get(idx);
            if (guess == answers.get(idx)) {
                Integer strike_cnt = ball_strike_cnt.get(1);
                ball_strike_cnt.set(1, ++strike_cnt);
            } else if (answers.contains(guess)) {
                Integer ball_cnt = ball_strike_cnt.get(0);
                ball_strike_cnt.set(0, ++ball_cnt);
            }
        }

        return ball_strike_cnt;
    }

    static void show_result(ArrayList<Integer> ball_strike_cnt) {
        Integer ball = ball_strike_cnt.get(0);
        Integer strike = ball_strike_cnt.get(1);

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            three_strike = 1;
            System.out.println("3스트라이크");
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
    }

    static void judge_guess(String guess, ArrayList<Integer> answer) {
        ArrayList<Integer> guess_parsed = parse_string_into_integer(guess);
        ArrayList<Integer> ball_strike_cnt = count_ball_and_strike(guess_parsed, answer);
        show_result(ball_strike_cnt);
    }

    static void main_loop() {
        ArrayList<Integer> answer = new ArrayList<>();
        random_number_generate(answer);
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String guess = Console.readLine();
            if (guess_validity_check(guess)) {
                judge_guess(guess, answer);
            }
        } while (three_strike != 1);
    }

    static void check_to_restart() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        do {
            String decision_string = Console.readLine();
            int decision = Integer.parseInt(decision_string);
            if (decision == 1) {
                init_and_start_game();
                return;
            } else if (decision == 2) {
                return;
            } else {
                throw new IllegalArgumentException();
            }
        } while (true);
    }

    static void init_and_start_game() {
        three_strike = 0;

        if (first_game == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            first_game = 0;
        }
        main_loop();
        check_to_restart();
    }

    public static void main(String[] args) {
        init_and_start_game();
    }
}
