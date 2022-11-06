package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        baseball();

    }

    public static void baseball() {
        boolean flag = true;
        String answer = selectRandomNumber();
        while (flag) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (!input.matches("^[1-9]{3}$")) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static String selectRandomNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            while (sb.toString().contains(Integer.toString(randomNumber))) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            }
            sb.append(randomNumber);
        }

        return sb.toString();
    }

}
