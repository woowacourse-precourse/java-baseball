package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static boolean checkPickNumbInMakingNum(List<Integer> nowMakingNumber, int pickRandomNum) {
        for (int i : nowMakingNumber) {
            if (i == pickRandomNum) {
                return false;
            }
        }
        return true;
    }

    public static String makeRandomNumber() {
        List<Integer> nowMakingNum = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int randNum = pickNumberInRange(1, 9);

            if (checkPickNumbInMakingNum(nowMakingNum, randNum)) {
                nowMakingNum.add(randNum);
            } else {
                i--;
            }
        }

        String makeNumber = nowMakingNum.toString().replaceAll("[^0-9]", "");

        return makeNumber;
    }

    static boolean checkInputAllNumber(String Input) {
        int asciiOne = (int) '1';
        int asciiNine = (int) '9';

        for (int k = 0; k < 3; k++) {
            int separatedNum = (int) Input.charAt(k);

            if (separatedNum < asciiOne || separatedNum > asciiNine) {
                return false;
            }
        }
        return true;
    }
}
