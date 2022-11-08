package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    //git commit test
    public static void game_start_message(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String make_computer_number() {
        String computer_number = "";
        while (computer_number.length() < 3) {
            int random_computer_digit = Randoms.pickNumberInRange(1,9);
            if (!computer_number.contains(Integer.toString(random_computer_digit))) {
                computer_number += Integer.toString(random_computer_digit);
            }
        }
        return computer_number;
    }

    public static String input_number_message(){
        System.out.printf("숫자를 입력해주세요 : ");
        String input_number = Console.readLine();
        return input_number;
    }

    public static void input_number_error(String input_number, String[] input_number_list) {

        for (int input_number_digit_value = 0; input_number_digit_value < 3; input_number_digit_value++) {
            String available_number = "123456789";
            if (!available_number.contains(Character.toString(input_number.charAt(input_number_digit_value)))) {
                throw new IllegalArgumentException();
            }
        }

        if (input_number_list.length != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input_number_list.length; i++) {
            if (Collections.frequency(Arrays.asList(input_number_list), input_number_list[i]) > 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int three_strike_judgement(List<Integer> strike_ball_nothing_list) {
        int strike_count = Collections.frequency(strike_ball_nothing_list, 2);
        if (strike_count == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void three_strike_message(int three_strike_judge){
        if (three_strike_judge == 1){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public static void add_ball_index(
            String[] input_number_list, String[] computer_number_list, List<Integer> strike_ball_nothing_list
    ){
        for (int i = 0; i < input_number_list.length; i++) {
            if (Arrays.asList(computer_number_list).contains(input_number_list[i])) {
                strike_ball_nothing_list.set(i, 1);
            }
        }
    }

    public static void add_strike_index(
            String[] input_number_list, String[] computer_number_list, List<Integer> strike_ball_nothing_list
    ){
        for (int i = 0; i < input_number_list.length; i++) {
            if (input_number_list[i].equals(computer_number_list[i])) {
                strike_ball_nothing_list.set(i, 2);
            }
        }
    }

    public static void result_message(List<Integer> strike_ball_nothing_list) {
        int strike_count = Collections.frequency(strike_ball_nothing_list, 2);
        int ball_count = Collections.frequency(strike_ball_nothing_list, 1);
        int nothing_count = Collections.frequency(strike_ball_nothing_list, 0);
        String strike_count_message = "";
        String ball_count_message = "";
        if (strike_count != 0) {
            strike_count_message = "%d스트라이크";
        }

        if (ball_count != 0) {
            ball_count_message = "%d볼 ";
        }

        if (nothing_count == 3) {
            System.out.println("낫싱");
        } else if (ball_count == 0){
            System.out.printf(strike_count_message + "\n", strike_count);
        } else {
            System.out.printf(ball_count_message + strike_count_message + "\n", ball_count, strike_count);
        }
    }

    public static String decide_newgame_endgame() {
        String playmore_stop_number = Console.readLine();
        return playmore_stop_number;
    }

    public static void decide_newgame_endgame_number_error(String playmore_stop_number) {
        String available_number = "12";
        if (!available_number.contains(playmore_stop_number)) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //First commit
        game_start_message();
        String playmore_stop_number = "1";
        do {
            //컴퓨터 숫자 생성 함수
            String computer_number = make_computer_number();
            String[] computer_number_list = computer_number.split("");
            List<Integer> strike_ball_nothing_list = Arrays.asList(0, 0, 0);
            int three_strike_judge = 0;

            do {
                String input_number = input_number_message();
                String[] input_number_list = input_number.split("");
                input_number_error(input_number, input_number_list);
                strike_ball_nothing_list = Arrays.asList(0, 0, 0);
                add_ball_index(input_number_list, computer_number_list, strike_ball_nothing_list);
                add_strike_index(input_number_list, computer_number_list, strike_ball_nothing_list);
                result_message(strike_ball_nothing_list);
                three_strike_judge = three_strike_judgement(strike_ball_nothing_list);
                three_strike_message(three_strike_judge);
            } while (three_strike_judge == 0);

            playmore_stop_number = decide_newgame_endgame();
            decide_newgame_endgame_number_error(playmore_stop_number);
        } while (playmore_stop_number.equals("1"));
    }
}
