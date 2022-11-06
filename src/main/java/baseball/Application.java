package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
//        기능1. 컴퓨터 숫자선정

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            final int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.print(randomNumber);
            }
        }

//      기능2. 참가자 입력
        int userNumber = 0;
        System.out.println("\n숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요: ");

        userNumber = Integer.parseInt(Console.readLine());

        if (userNumber > 999 ||userNumber < 100) {
            throw new IllegalArgumentException("숫자 세개를 입력해주세요.");
        }
        if (userNumber/100 == (userNumber/10)%10 || (userNumber/10)%10 == (userNumber%10) || (userNumber/100) == (userNumber%10)) {
            throw new IllegalArgumentException("중복되는 숫자를 입력할 수 없습니다.");
        }

        if (userNumber/100==0 || (userNumber/10)%10==0 || userNumber%10==0) {
            throw new IllegalArgumentException("0을 입력할 수 없습니다.");
        }


    }
}
