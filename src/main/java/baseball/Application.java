package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    // 2번 랜덤으로 computer에서 제공하는 정답을 얻어내는 메소드
    public static String baseball_random() {

        String baseball = "";

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int i : computer){
            baseball += Integer.toString(i);}

        return baseball;
    }

    // 3번 사용자의 input를 받는 메소드
    public static String baseball_input() {
        System.out.print("숫자를 입력해주세요 : ");

        String user_input = Console.readLine();
        List<String> overlap_check = Arrays.asList(user_input.split(""));
        try{
            int error_check = Integer.parseInt(user_input);
            if (!(error_check > 111 && error_check < 999)){
                throw new IllegalArgumentException();
            }

            int not_overlap_first = Collections.frequency(overlap_check, overlap_check.get(0));
            int not_overlap_second = Collections.frequency(overlap_check, overlap_check.get(1));
            int not_overlap_third = Collections.frequency(overlap_check, overlap_check.get(2));

            if (not_overlap_first > 1 || not_overlap_second > 1 || not_overlap_third > 1){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            String error = "error";
            return error;
        }

        return user_input;
    }


    // 4번 문자를 넣은 이후 비교하는 메소드 (if문 2개를 활용)
    public static int[] compare_and_change(int strike, int ball, int i, int order_baseball_answer, char answer_char, char compare_char){
        if (compare_char == answer_char){
            if (i == order_baseball_answer){
                strike += 1;
            } else {
                ball += 1;
            }
        }
        return new int[]{strike, ball};
    }

    // 4번 문자를 각각 넣어주는 메소드 (for문을 2개 활용)
    public static int[] strike_ball(String baseball_input, String baseball_answer){
        int ball = 0;
        int strike = 0;
        int[] get_strike_ball;
        for (int answer_index=0; answer_index<3; answer_index++){
            char answer_char = baseball_answer.charAt(answer_index);

            for (int compare_index = 0; compare_index<3; compare_index++){
                char compare_char = baseball_input.charAt(compare_index);
                get_strike_ball = compare_and_change(strike, ball, answer_index, compare_index, answer_char, compare_char);
                strike = get_strike_ball[0];
                ball = get_strike_ball[1];
            }

        }
        return new int[] {strike, ball};
    }

    public static int game_loof(String baseball_answer){
        int strike = 0;
        while (strike != 3) {
            strike = 0;
            String user_input = baseball_input();
            if (user_input.equals("error")){
                return 1;
            }
            int[] get_strike_ball = strike_ball(user_input, baseball_answer);
            strike = get_strike_ball[0];
        }
        return 0;
    }










    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int exit_check = 1;
        while (exit_check == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String baseball_answer = baseball_random();
            /*
            int game_error = game_loof(baseball_answer);
            if (game_error == 1){
                break;
            }
            */


            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


            exit_check = Integer.parseInt(Console.readLine());

        }
    }


    }
