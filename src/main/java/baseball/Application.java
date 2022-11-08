package baseball;

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

}
