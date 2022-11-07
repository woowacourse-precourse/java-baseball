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

            int user_number_int = Character.getNumericValue(user_number_char);
            if (user_number_int < 1 || 9 < user_number_int) {
                return 1;
            }

            check_duplicate.add(user_number_char);
        }

        return 0;
    }

    static int check_user_number(List<Character> user_number_char_list) {
        List<Character> temp_user_number_char_list = user_number_char_list;

        if (temp_user_number_char_list.isEmpty() || temp_user_number_char_list.size() != 3) {
            return 1;
        }

        if (check_correct_number(user_number_char_list) == 1) {
            return 1;
        }

        return 0;
    }

    static List<Integer> check_score(List<Integer> computer_number_list, List<Character> user_number_char_list) {
        List<Integer> temp_computer_number_list = computer_number_list;
        int computer_number_1 = temp_computer_number_list.get(0);
        int computer_number_2 = temp_computer_number_list.get(1);
        int computer_number_3 = temp_computer_number_list.get(2);

        List<Character> temp_user_number_char_list = user_number_char_list;
        int user_number_1 = Character.getNumericValue(temp_user_number_char_list.get(0));
        int user_number_2 = Character.getNumericValue(temp_user_number_char_list.get(1));
        int user_number_3 = Character.getNumericValue(temp_user_number_char_list.get(2));

        int ball = 0;
        if ((computer_number_1 == user_number_2) || (computer_number_1 == user_number_3)) {
            ball = ball + 1;
        }
        if ((computer_number_2 == user_number_1) || (computer_number_2 == user_number_3)) {
            ball = ball + 1;
        }
        if ((computer_number_3 == user_number_1) || (computer_number_3 == user_number_2)) {
            ball = ball + 1;
        }

        int strike = 0;
        if (computer_number_1 == user_number_1) {
            strike = strike + 1;
        }
        if (computer_number_2 == user_number_2) {
            strike = strike + 1;
        }
        if (computer_number_3 == user_number_3) {
            strike = strike + 1;
        }

        List<Integer> score = new ArrayList<Integer>(Arrays.asList(ball, strike));

        return score;
    }

    static void print_score(List<Integer> computer_number_list) {
        if (computer_number_list.get(0) > 0) {
            System.out.print(computer_number_list.get(0));
            System.out.print("볼 ");
        }
        if (computer_number_list.get(1) > 0) {
            System.out.print(computer_number_list.get(1));
            System.out.print("스트라이크");
        }
        if (computer_number_list.get(0) == 0 && computer_number_list.get(1) == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    static boolean check_strike_3(int strike) {
        if (strike == 3) {
            // 게임 종료 문구 출력
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    static int compare_computer_user(List<Integer> computer_number_list) {
        Boolean strike_3 = false;

        while (!strike_3) {
            // 사용자 입력 문구 출력
            System.out.print("숫자를 입력해주세요 : ");

            List<Character> user_number_char_list;
            user_number_char_list = user_enter_number();

            int error;
            error = check_user_number(user_number_char_list);

            if (error == 1) {
                return 1;
            }

            List<Integer> score;
            score = check_score(computer_number_list, user_number_char_list);

            print_score(score);

            strike_3 = check_strike_3(score.get(1));
        }

        return 0;
    }

    static int check_user_want_new_game() {
        // 게임 재시작 여부를 묻는 문구 출력
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String user_number_string;
        user_number_string = readLine();

        if (user_number_string.equals("1")) {
            return 1;
        } else if (user_number_string.equals("2")) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int next_game = 1;

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (next_game == 1) {
            List<Integer> computer_number_list = new ArrayList<Integer>();
            computer_number_list = computer_create_number();

            int error;
            error = compare_computer_user(computer_number_list);

            if (error == 1) {
                throw new IllegalArgumentException();
            }

            next_game = check_user_want_new_game();

            if (next_game == 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
