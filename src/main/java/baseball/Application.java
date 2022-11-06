package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

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
        System.out.println("정답입니다.");
        System.out.println("다시 시작하시려면 1번을 종료하시려면 2번을 눌러주세요.");
        String oneOrTwo = readLine();
        if (oneOrTwo.equals("1")){
            return true;
        } else {
            System.out.println("게임이 종료되었습니다");
            return false;
        }
    }


}
