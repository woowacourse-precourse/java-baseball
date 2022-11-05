package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Number {
    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 9;

    private int[] numbers;

    public int[] getNumbers() {
        return this.numbers;
    }
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void ComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = getRandomNumber();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.numbers = ConvertArrayListToArray(computer);
    }

    public int[] ConvertArrayListToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}