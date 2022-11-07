package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void game_start_message(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String input_number_message(){
        System.out.println("숫자를 입력해주세요 : ");
        String input_number = camp.nextstep.edu.missionutils.Console.readLine();
        return input_number;
    }

    public static void three_strike_message(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //First commit

        //컴퓨터 숫자 생성 함수
        String computer_number = "451";
        String[] computer_number_list = computer_number.split("");
        String input_number = input_number_message();
        String[] input_number_list = input_number.split("");
        List<Integer> strike_ball_nothing_list = Arrays.asList(0, 0, 0);
        add_ball_index(input_number_list, computer_number_list, strike_ball_nothing_list);
        add_strike_index(input_number_list, computer_number_list, strike_ball_nothing_list);
        result_message(strike_ball_nothing_list);
    }
}
