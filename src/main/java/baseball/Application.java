package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
//        기능1. 컴퓨터 숫자선정
        int randomNumber = 0;

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.print(randomNumber);
            }
        }

//      기능2. 참가자 입력
        System.out.println("\n숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요: ");

        int userNumber = 0;
        userNumber = Integer.parseInt(Console.readLine());

        int[] digits = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();

        List<Integer> user = new ArrayList<>();

        for (int order = 0; order <digits.length; order++) {
            user.add(digits[order]);
        }
        System.out.println("computer: "+computer);  //컴퓨터 출력물 분석용
        System.out.println("user: "+user);  // 유저 입력값 분석용
        System.out.println(userNumber); // 유저 입력값 확인용

        if (userNumber > 999 ||userNumber < 100) {
            throw new IllegalArgumentException("숫자 세개를 입력해주세요.");
        }
        if (userNumber/100 == (userNumber/10)%10 || (userNumber/10)%10 == (userNumber%10) || (userNumber/100) == (userNumber%10)) {
            throw new IllegalArgumentException("중복되는 숫자를 입력할 수 없습니다.");
        }

        if (userNumber/100==0 || (userNumber/10)%10==0 || userNumber%10==0) {
            throw new IllegalArgumentException("0을 입력할 수 없습니다.");
        }

//      기능3. 결과값 비교

        boolean compare = computer.get(0) == user.get(0);
        System.out.println(compare);

//        System.out.println(userNumber.getClass().getSimpleName());

        if (computer == user) {
            System.out.println("True");
        }


    }
}
