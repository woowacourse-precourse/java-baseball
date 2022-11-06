package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            List<Integer> randomNum = createRandomNum();
            System.out.println(randomNum);
            guessNum();
            checkNum();
            closeOrRestart();
        }
    }

    public static List<Integer> createRandomNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    private static void closeOrRestart() {

    }

    private static void checkNum() {

    }

    private static void guessNum() {

    }


}
