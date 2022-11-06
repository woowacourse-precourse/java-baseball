package baseball.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class Number {

    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private static final int MAX_LEN = 3;
    public static final char CHARZERO = '0';

    public List<Integer> createUserNumber(String number) {
        List<Integer> num = new ArrayList<>();
        for (char ch : number.toCharArray()) {
            num.add(ch - CHARZERO);
        }
        return num;
    }

    public List<Integer> createComputerNumber() {
        List<Integer> num = new ArrayList<>();
        while (num.size() < MAX_LEN) {
            int randomNum = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (!num.contains(randomNum)) {
                num.add(randomNum);
            }
        }
        return num;
    }
}
