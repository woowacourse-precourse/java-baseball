package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        //1. 상대방이 랜덤한 세 자리수를 생성한다.
        List<Integer> rand_num = rand_num_gen();

        //2. 사용자로부터 세 자리수를 입력받는다.
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> input_num = rand_num_input();
    }
}
