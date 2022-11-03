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
}
