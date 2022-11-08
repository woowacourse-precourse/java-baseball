package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int numberOfDigits = 3;
    static final int minNumber = 1;
    static final int maxNumber = 9;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 랜덤한 숫자 받아온 후 컴퓨터 리스트에 값 추가
        List<Integer> computer = addToRandomNumberList();
    }

    // 랜덤한 숫자 받아온 후 컴퓨터 리스트에 값 추가
    public static List<Integer> addToRandomNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < numberOfDigits) {
            int randomNumber = Randoms.pickNumberInRange(minNumber, maxNumber);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}