package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        boolean run = true;
        List<Integer> computerNum;


        while (run) {
            computerNum = createRandomNum();
            String checkMessage = "";
            while (!(checkMessage.equals("3스트라이크"))) {
                String userNum = guessNum();
                checkMessage = checkNum(computerNum, userNum);
                System.out.println(checkMessage);
            }
            run = closeOrRestart();
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

    public static String checkNum(List<Integer> computerNum, String userNum) {
        String computerNumStr = "";
        for (Integer x : computerNum) {
            computerNumStr += x.toString();
        }
        char[] computerNumCharArr = computerNumStr.toCharArray();
        char[] userNumCharArr = userNum.toCharArray();
        int ballCnt = 0;
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumStr.contains(userNumCharArr[i] + "")) {
                ballCnt++;
            }
            if (computerNumCharArr[i] == userNumCharArr[i]) {
                strikeCnt++;
            }
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            return "낫싱";
        } else if (ballCnt-strikeCnt == 0) {
            return strikeCnt + "스트라이크";
        } else if (strikeCnt == 0) {
            return ballCnt + "볼";
        }
        return ballCnt - strikeCnt + "볼 " + strikeCnt + "스트라이크";
    }

    public static String guessNum() {
        return readLine();
    }

    public static boolean closeOrRestart() {
        String oneOrTwo = readLine();
        if (oneOrTwo.equals("1")){
            return true;
        } else {
            System.out.println("게임 종료");
            return false;
        }
    }


}
