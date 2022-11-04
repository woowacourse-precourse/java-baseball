package baseball.service;

import baseball.domain.InputValue;
import baseball.exception.InputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class ResultService {
    public int ReOrClose(List<Integer> RandomNumber) {
        RuleService rules = new RuleService();
        InputException validation = new InputException();
        InputValue inputValue = new InputValue();

        int strike = 0;
        int ball;
        int want;

        while (strike != 3) {
            List<Integer> inputNumber = inputValue.inputNum();

            validation.InputValid(RandomNumber, inputNumber);

            strike = rules.Strike(RandomNumber, inputNumber);
            ball = rules.Ball(RandomNumber, inputNumber);

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("다시 하시려면 1번 종료하시려면 2번을 눌러주세요");
        want = Integer.parseInt(readLine());

        return want;
    }
}
