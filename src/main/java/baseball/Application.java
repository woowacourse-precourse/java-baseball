package baseball;

import java.util.Arrays;
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
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //First commit

        //컴퓨터 숫자 생성 함수
        String computer_number = "451";
        String[] computer_number_list = computer_number.split("");
        String input_number = input_number_message();
        String[] input_number_list = input_number.split("");
        List<Integer> strike_ball_nothing_list = Arrays.asList(0, 0, 0);
    }
}
