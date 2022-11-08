package baseball;

import java.util.HashSet;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    /**
     * 서로 다른 수로 이루어진 세 자리의 무작위 수를 만든다.
     *
     * @return
     */
    private static String generateGoalNumber() {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> numsLib = new HashSet<>();
        while (numsLib.size() < 3) {
            Integer tempNumber = pickNumberInRange(0, 9);
            if (!numsLib.contains(tempNumber)) {
                numsLib.add(tempNumber);
                sb.append(tempNumber.toString());
            }
        }

        String result = sb.toString();
        return result;
    }

    /**
     * 사용자로부터 입력을 받음
     * @return
     */
    private static String getUserNumber() {
        String result = readLine();
        return result;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
