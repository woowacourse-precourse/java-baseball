package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static int goGame = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String number = readLine();
            int randomNumber = pickNumberInRange(100, 999);

            for (int i = 0; i < number.length(); i++) {
                int dividedNumber = Integer.parseInt(String.valueOf(number.charAt(2 - i)));
                System.out.println(dividedNumber);
            }

            goGame = 2;
        } while (goGame != 2);
    }
}
