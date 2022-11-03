package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> target;

    public void startGame() {
        target = new ArrayList<>();
        while (target.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(randomNumber)) {
                target.add(randomNumber);
            }
        }
        System.out.println(target); //난수 확인용
    }

    public boolean getResult(int number) {
        List<Integer> numbers = getListFromInt(number);

        return false;
    }

    private List<Integer> getListFromInt(int number) {
        List<Integer> list = new ArrayList<>();
        int divide = 100;
        while (divide > 0) {
            list.add(number/divide);
            number = number%divide;
            divide = divide/10;
        }
        return list;
    }


}
