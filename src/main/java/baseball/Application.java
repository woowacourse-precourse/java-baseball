package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int randomNumber = GetRandomNumber();
        System.out.println(randomNumber);
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요 : ");
        int inputNumber = Number.rangeCheck();
        System.out.println("입력값 : "+ inputNumber);


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
