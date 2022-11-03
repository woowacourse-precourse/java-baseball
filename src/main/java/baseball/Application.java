package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

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

    private static List<Integer> numtoList(String number) {
        List<Integer> number_list = new ArrayList<>();

        String[] number_split = number.split("");

        for (String num : number_split) {
            Integer to_int = Integer.parseInt(num);
            number_list.add(to_int);
        }

        return number_list;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            List<Integer> computer_num = createRandomNumber();
            System.out.print("숫자를 입력해주세요 : ");
            String guess_number = Console.readLine();
            List<Integer> user_num = numtoList(guess_number);
            break; // 기능 완전 구현 전까지 반복문을 탈출하기 위함.
        }
    }
}
