package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private static List<Integer> rand_num_gen() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> rand_num_input() {
        List<Integer> input_tolist = new ArrayList<>();
        String input = Console.readLine();

        for (int i = 0; i < input.length(); i++) {
            input_tolist.add(Character.getNumericValue(input.charAt(i)));
        }

        return input_tolist;
    }

    private static boolean is_execption(List<Integer> input) {
        if (input.size() != 3) {
            return true;
        }

        Set<Integer> input_toset = new HashSet<>(input);
        if (input.size() != input_toset.size()) {
            return true;
        }

        return false;
    }

    private static boolean process_exception(List<Integer> input_num) {
        try {
            if (is_execption(input_num)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private static boolean compare_input(List<Integer> ans, List<Integer> input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (ans.get(i) == input.get(i)) {
                strike += 1;
            } else if (ans.contains(input.get(i))) {
                ball += 1;
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(String.format("%d볼", ball));
        } else if (ball == 0) {
            System.out.println(String.format("%d스트라이크", strike));
        } else {
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
        }

        if (strike == 3) {
            return true;
        }
        return false;
    }

    private static String exit_and_restart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        return input;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        //1. 상대방이 랜덤한 세 자리수를 생성한다.
        List<Integer> rand_num = rand_num_gen();

        while (true) {
            //2. 사용자로부터 세 자리수를 입력받는다.
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> input_num = rand_num_input();

            //3. 사용자로부터 입력 받은 수가 잘못된 값인 경우 프로그램을 종료한다.
            if (process_exception(input_num)) {
                break;
            }

            //4. 사용자로부터 입력 받은 수를 상대방의 수와 비교해 결과를 출력하고, 두 수가 같은 지 판별한다.
            boolean match = compare_input(rand_num, input_num);

            //5. 두 수가 같지 않다면, 게임을 계속해서 진행한다.
            if (!match) {
                continue;
            }

            //6. 두 수가 같다면, 게임을 종료 후 재시작 여부를 사용자에게 입력받는다.
            String input = exit_and_restart();

            //8. 재시작 여부에 대한 입력에 따라 처리한다.
            if (input.equals("1")){
                rand_num = rand_num_gen();
            } else{
                break;
            }
        }
    }
}
