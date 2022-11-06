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
