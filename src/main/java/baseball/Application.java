package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {

    private static final int finalRound = 3;
    private static final int numberLength = 3;
    private static int currentRound = 0;
    private static ArrayList<ArrayList<Integer>> number = new ArrayList<ArrayList<Integer>>(3);


    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static void getRandomDifferentNumber() {
        ArrayList<Integer> currentRoundNum = new ArrayList<>();
        for (int i = 0; i < numberLength; i++) {
            int newNum = getRandomNumber();
            if (numberDuplication(newNum, i, currentRoundNum)) {
                i--;
                continue;
            }
            currentRoundNum.add(newNum);
        }
        number.add(currentRoundNum);
    }

    public static void gameInit() {
        for (int i = 0; i < finalRound; i++) {
            getRandomDifferentNumber();
            currentRound = currentRound + 1;
        }
    }

    public static boolean numberDuplication(int newNum, int numberIndex,
        ArrayList<Integer> number) {
        for (int i = 0; i < numberIndex; i++) {
            if (number.get(i) == newNum) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // gameInit();
       //System.out.println(number.get(0));
       // System.out.println(number.get(1));
       // System.out.println(number.get(2));

    }
}
