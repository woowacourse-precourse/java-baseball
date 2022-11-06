package baseball.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class Number {

    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private static final String INPUT_ERROR = "숫자를 잘못 입력하셨습니다. 게임 종료";
    private static final int MAX_LEN = 3;
    public static final char CHARZERO = '0';


    public List<Integer> createUserNumber(String number) {
        checkLength(number);

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

    private void checkLength(String number) {
        if (number.length() == MAX_LEN) {
            return;
        }
        throw new IllegalArgumentException(INPUT_ERROR);
    }
}
