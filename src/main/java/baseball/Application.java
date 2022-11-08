package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = makeRandomInteger();
    }
    // 숫자 입력
    public static List<Integer> inputNumber() {

        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> user = inputExeption();
        System.out.println(user);
        return user;
    }
    // 난수 발생기
    public static List<Integer> makeRandomInteger() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
