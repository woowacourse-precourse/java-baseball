package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Number.inputNumber;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int randomNumber = GetRandomNumber();
        System.out.println(randomNumber);
        System.out.println("숫자를 입력해주세요 : ");
        Number.rangeCheck();
        System.out.println(inputNumber);





    }

    private static int GetRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int randomNumber = computer.get(0)*100 + computer.get(1)*10 + computer.get(2);

        return randomNumber;
    }

}
