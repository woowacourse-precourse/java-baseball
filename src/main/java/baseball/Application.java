package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static int goGame = 1;
    final static int MAX_NUMBER_SIZE = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String number = readLine();
            String randomNumber = String.valueOf(pickNumberInRange(100, 999));
            System.out.println(randomNumber);

            for (int i = 0; i < number.length(); i++) {
                char dividedNumber = number.charAt(i);
                int dividedNumberIndex = number.indexOf(dividedNumber);
                System.out.println(dividedNumberIndex);
                System.out.println(dividedNumber);
                if (randomNumber.indexOf(dividedNumber) != -1) {

                }
            }

            goGame = 2;
        } while (goGame != 2);
    }
}
