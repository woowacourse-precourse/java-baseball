package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> createRandomNumber() {
        List<Integer> computer_num = new ArrayList<>();

        while (computer_num.size() < 3) {
            int random_number = Randoms.pickNumberInRange(1, 9);
            if (!computer_num.contains(random_number)) {
                computer_num.add(random_number);
            }
        }
        return computer_num;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            List<Integer> computer_num = createRandomNumber();
            System.out.println(computer_num);
            System.out.print("숫자를 입력해주세요 : ");
            break; // 기능 완전 구현 전까지 반복문을 탈출하기 위함.
        }
    }
}
