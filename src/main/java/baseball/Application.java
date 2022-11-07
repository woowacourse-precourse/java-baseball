package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        boolean run = true;
        List<Integer> computerNum;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (run) {
            computerNum = createRandomNum();
            String checkMessage = "";
            while (!(checkMessage.equals("3스트라이크"))) {
                System.out.println(computerNum);
                System.out.print("숫자를 입력해주세요 : ");
                String userNum = guessNum(inputValue());
                checkMessage = checkNum(computerNum, userNum);
                System.out.println(checkMessage);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            run = closeOrRestart(inputValue());
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
        } else if (ballCnt - strikeCnt == 0) {
            return strikeCnt + "스트라이크";
        } else if (strikeCnt == 0) {
            return ballCnt + "볼";
        }
        return ballCnt - strikeCnt + "볼 " + strikeCnt + "스트라이크";
    }

    public static String guessNum(String userNum) {
        if (userNum.length() != 3) {
            throw new IllegalArgumentException();
        }
        char[] userNumCharArr = userNum.toCharArray();
        Set<Character> set = new HashSet<>();
        for (Character x : userNumCharArr) {
            if (!Character.isDigit(x)) {
                throw new IllegalArgumentException();
            }
            if (x == '0') {
                throw new IllegalArgumentException();
            }
            set.add(x);
        }
        if (userNumCharArr.length != set.size()) {
            throw new IllegalArgumentException();
        }
        return userNum;
    }

    public static boolean closeOrRestart(String oneOrTwo) {
        if (oneOrTwo.equals("1")) {
            return true;
        } else if (oneOrTwo.equals("2")) {
            System.out.println("게임 종료");
            return false;
        }
        throw new IllegalArgumentException();
    }

    public static String inputValue() {
        return readLine();
    }
}
