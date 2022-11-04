package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> randomNumber = getRandomNumber();
        printStartMessage();


    }

    public static List<Integer> getRandomNumber() {
        List<Integer> baseballNumber = new ArrayList<>();
        while (baseballNumber.size() <= 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumber.contains(randomNumber)) {
                baseballNumber.add(randomNumber);
            }
        }
        return baseballNumber;
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
