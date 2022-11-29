package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public enum Number {
    LENGTH(3);

    private final int number;
    private static List<Integer> computer;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static List<Integer> generateNumber() {
        computer = new ArrayList<>();

        while (computer.size() < LENGTH.getNumber()){
            computer.add(Randoms.pickNumberInRange(1,9));
        }
        return computer;
    }
}
