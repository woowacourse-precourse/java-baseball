package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static List<Integer> computer_create_number() {
        List<Integer> computer_number = new ArrayList<Integer>();

        while (computer_number.size() != 3) {
            int number = pickNumberInRange(1, 9);
            if (!computer_number.contains(number)) {
                computer_number.add(number);
            }
        }

        return computer_number;
    }

    public static void main(String[] args) {
        Boolean next_game = true;

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (next_game) {
            List<Integer> computer_number = new ArrayList<Integer>();
            computer_number = computer_create_number();
        }
    }
}
