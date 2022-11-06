package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static List<Integer> make_rand_num(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static int input_your_num(){
        String input_str;
        int input_num = 000;

        System.out.print("숫자를 입력해주세요 : ");
        input_str = Console.readLine();
        input_num = Integer.parseInt(input_str);

        return input_num;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

}
