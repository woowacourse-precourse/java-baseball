package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            String computerNum = createRandomNum().toString();
            String userNum = guessNum();
            checkNum(computerNum, userNum);
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

    public static String checkNum(String computerNum, String userNum) {
        char[] computerNumCharArr = computerNum.toCharArray();
        char[] userNumCharArr = userNum.toCharArray();
        int ballCnt = 0;
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNum.contains(userNumCharArr[i] + "")) {
                ballCnt++;
            }
            if (computerNumCharArr[i] == userNumCharArr[i]) {
                strikeCnt++;
            }
        }

        if (ballCnt == 0 && strikeCnt == 0) {
            return "낫싱";
        } else if (ballCnt == 0){
            return strikeCnt + "스트라이크";
        } else if (strikeCnt == 0) {
            return  ballCnt + "볼";
        }
        return ballCnt - strikeCnt + "볼 " + strikeCnt + "스트라이크";
    }

    public static String guessNum() {
        return readLine();
    }


}
