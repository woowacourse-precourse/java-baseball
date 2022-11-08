package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final int PLAYING = 3;
    private static final int READY = 1;
    private static final int ONEMORETIME = 1;
    private static final int NUMBEROFDIGITS = 3;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int regame_input = ONEMORETIME;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            regame_input = userInput(READY);
        } while (regame_input == ONEMORETIME);
    }

    private static void startGame() {
        boolean answer = false;
        int playing_input = READY;
        List<Integer> computer_num;
        List<Integer> player_num;

        computer_num = initComputerNum();
        while (!answer) {
            System.out.print("숫자를 입력해주세요 : ");
            playing_input = userInput(PLAYING);
            player_num = int_to_list(playing_input);
            answer = hint(computer_num, player_num);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean hint(List<Integer> computer_num, List<Integer> player_num) {
        List<Integer>[] computer_num_map = init_map_Index_Value(computer_num);
        List<Integer>[] player_num_map = init_map_Index_Value(player_num);
        List<Integer> ball_strike_count = Arrays.asList(0, 0);

        for (int i = 0; i < NUMBEROFDIGITS; i++) {
            for (int j = 0; j < NUMBEROFDIGITS; j++) {
                ball_strike_count = compareList(ball_strike_count, computer_num_map[i], player_num_map[j]);
            }
        }
        print_hint(ball_strike_count);
        if (ball_strike_count.get(1) == NUMBEROFDIGITS) {
            return true;
        }
        return false;
    }

    private static List<Integer> compareList(List<Integer> ball_strike_count, List<Integer> computer_num, List<Integer> player_num) {
        if (computer_num.get(0) != player_num.get(0) && computer_num.get(1) == player_num.get(1)) {
            ball_strike_count.set(0, ball_strike_count.get(0) + 1);
        } else if (computer_num.get(0) == player_num.get(0) && computer_num.get(1) == player_num.get(1)) {
            ball_strike_count.set(1, ball_strike_count.get(1) + 1);
        }
        return ball_strike_count;
    }

    private static void print_hint(List<Integer> ball_strike_count) {
        if (ball_strike_count.get(0) == 0 && ball_strike_count.get(1) != 0) {
            System.out.println(+ball_strike_count.get(1) + "스트라이크");
        } else if (ball_strike_count.get(0) != 0 && ball_strike_count.get(1) == 0) {
            System.out.println(ball_strike_count.get(0) + "볼 ");
        } else if (ball_strike_count.get(0) != 0 && ball_strike_count.get(1) != 0) {
            System.out.println(ball_strike_count.get(0) + "볼 " + ball_strike_count.get(1) + "스트라이크");
        } else if (ball_strike_count.get(0) == 0 && ball_strike_count.get(1) == 0) {
            System.out.println("낫싱");
        }

    }

    private static List<Integer>[] init_map_Index_Value(List<Integer> score_list) {
        List<Integer>[] map = new ArrayList[NUMBEROFDIGITS];

        for (int i = 0; i < NUMBEROFDIGITS; i++) {
            map[i] = new ArrayList<>();
            map[i].add(i);
            map[i].add(score_list.get(i));
        }
        return map;
    }

    private static List<Integer> int_to_list(int playing_input) {
        List<Integer> list_num = new ArrayList<>();
        for (int i = 0; i < NUMBEROFDIGITS; i++) {
            list_num.add(playing_input % 10);
            playing_input = playing_input / 10;
        }
        Collections.reverse(list_num);
        return list_num;
    }

    private static List<Integer> initComputerNum() {
        List<Integer> computer_num = new ArrayList<>();
        while (computer_num.size() < NUMBEROFDIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_num.contains(randomNumber)) {
                computer_num.add(randomNumber);
            }
        }
        return computer_num;
    }

    private static int userInput(int play_mode) {
        String input_String;
        int input_int;

        input_String = Console.readLine();
        System.out.println(input_String);

        input_int = input_String_to_int(input_String, play_mode);
        return input_int;
    }

    private static int input_String_to_int(String input_String, int play_mode) {
        char[] input_charArray = input_String.toCharArray();
        int input_int;

        if (play_mode == READY && (!input_String.equals("1") && !input_String.equals("2"))) {
            throw new IllegalArgumentException();
        }

        if (isNumberOfDigits(input_String, play_mode) || isNumberSet(input_charArray) || isNumberOverlap(input_charArray, play_mode)) {
            throw new IllegalArgumentException();
        }
        input_int = Integer.parseInt(input_String);
        return input_int;
    }

    //게임 중 3자리가 아닌 경우 혹은 게임이 끝나고 1자리가 아닌 경우
    private static boolean isNumberOfDigits(String input_String, int play_mode) {
        if (input_String.length() != play_mode) {
            return true;
        }
        return false;
    }

    //0~9사이의 숫자가 아닌 경우
    private static boolean isNumberSet(char[] input_charArray) {
        for (int i = 0; i < input_charArray.length; i++) {
            if (input_charArray[i] < '0' || input_charArray[i] > '9') {
                return true;
            }
        }
        return false;
    }

    //중복된 숫자가 있는 경우
    private static boolean isNumberOverlap(char[] input_charArray, int play_mode) {
        HashSet<Character> numSet = new HashSet<>();
        for (int i = 0; i < input_charArray.length; i++) {
            numSet.add(input_charArray[i]);
        }
        if (numSet.size() != play_mode) {
            return true;
        }
        return false;
    }
}
