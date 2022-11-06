package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static List<Integer> computer_create_number() {
        List<Integer> computer_number_list = new ArrayList<Integer>();

        while (computer_number_list.size() != 3) {
            int number = pickNumberInRange(1, 9);
            if (!computer_number_list.contains(number)) {
                computer_number_list.add(number);
            }
        }

        return computer_number_list;
    }

    static List<Character> user_enter_number() {
        String user_number_string;
        user_number_string = readLine();

        char[] user_number_char_array;
        user_number_char_array = user_number_string.toCharArray();

        List<Character> user_number_char_list = new ArrayList<Character>();
        for (char user_number_char : user_number_char_array) {
            user_number_char_list.add(user_number_char);
        }

        return user_number_char_list;
    }

    static int check_1_between_9_number(List<Character> user_number_char_list) {
        List<Character> temp_user_number_char_list = user_number_char_list;

        for (char user_number_char : temp_user_number_char_list) {
            int user_number_int = Character.getNumericValue(user_number_char);

            if (user_number_int < 1 || 9 < user_number_int) {
                return 1;
            }
        }

        return 0;
    }

    static int check_correct_number(List<Character> user_number_char_list) {
        List<Character> temp_user_number_char_list = user_number_char_list;
        List<Character> check_duplicate = new ArrayList<>();

        for (char user_number_char : temp_user_number_char_list) {
            if (check_duplicate.contains(user_number_char)) {
                return 1;
            }

            if (!Character.isDigit(user_number_char)) {
                return 1;
            }

            if (check_1_between_9_number(user_number_char_list) == 1) {
                return 1;
            }

            check_duplicate.add(user_number_char);
        }

        return 0;
    }

    public static void main(String[] args) {
        Boolean next_game = true;

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (next_game) {
            List<Integer> computer_number_list = new ArrayList<Integer>();
            computer_number_list = computer_create_number();
        }
    }
}
