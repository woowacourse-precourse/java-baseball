package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Baseball {
    List<Integer> answer = new ArrayList<>();
    int strike, ball;

    public Baseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public Boolean run() {
        strike = 0;
        ball = 0;
        System.out.print("숫자를 입력해주세요 : ");

        int userNumber = Integer.parseInt(Console.readLine());
        if (userNumber < 123 || userNumber > 987)
            throw new IllegalArgumentException();
        int firstNumber = userNumber / 100;
        int secondNumber = userNumber % 100 / 10;
        int thirdNumber = userNumber % 10;

        if (answer.contains(firstNumber)) {
            if (answer.get(0) == firstNumber) strike++;
            else ball++;
        }
        if (answer.contains(secondNumber)) {
            if (answer.get(1) == secondNumber) strike++;
            else ball++;
        }
        if (answer.contains(thirdNumber)) {
            if (answer.get(2) == thirdNumber) strike++;
            else ball++;
        }

        return strike == 3;
    }
}
