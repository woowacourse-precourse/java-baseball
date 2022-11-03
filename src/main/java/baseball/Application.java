package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static class Input {
        public List<Integer> UserNumber() {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");

            String inputNumber = Console.readLine();
            List<Integer> userNumber = new ArrayList<>();

            for (String number : inputNumber.split("")) {
                userNumber.add(Integer.parseInt(number));
            }
            return userNumber;
        }
    }

    public static boolean ValidationCheck(List<Integer> userNumber) {
        // 길이 체크
        // 3자 미만이거나 초과면 오류발생으로 넘어가는데 메세지 출력이 안된다
        if (userNumber.size() != 3) throw new IllegalArgumentException("오류가 발생했습니다.");
        // 중복값 체크
        if (userNumber.size() != userNumber.stream().distinct().count())
            throw new IllegalArgumentException("오류가 발생했습니다.");

        return false;
    }
}
