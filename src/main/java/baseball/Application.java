package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            runBaseBallGame();
        } while (restartBaseBallGame() == 1);
    }

    public static void runBaseBallGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> com = computerNumber();
        List<Integer> user = userNumber();

        while (true) {

            if (Referee(com, user) == 3)
                return;

            user = userNumber();
        }
    }

    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randNumber)) {
                computer.add(randNumber);
            }
        }
        return computer;
    }

    public static List<Integer> userNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNum = new ArrayList<>();

        String str = readLine();

        if (!userNumberCheck(str))
            throw new IllegalArgumentException("서로 다른 3자리 숫자로 입력해야합니다.");

        Integer number = Integer.parseInt(str);
        userNum.add(number / 100);
        userNum.add((number / 10) % 10);
        userNum.add(number % 10);

        return userNum;
    }

    public static int Referee(List<Integer> com, List<Integer> user) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < com.size(); i++) {
            if (com.get(i).equals(user.get(i)))
                strikeCount++;
            else if (com.contains(user.get(i)))
                ballCount++;
        }
        BallStrike(ballCount, strikeCount);

        return strikeCount;
    }

    public static void BallStrike(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0)
            System.out.println("낫싱");
        else if (ballCount != 0 && strikeCount != 0)
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        else if (ballCount != 0 && strikeCount == 0)
            System.out.println(ballCount + "볼 ");
        else if (ballCount == 0 && strikeCount != 0)
            System.out.println(strikeCount + "스트라이크");
        if (strikeCount == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static Integer restartBaseBallGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String str = readLine();
        Integer flag = Integer.parseInt(str);

        if (!restartBaseBallGameCheck(flag))
            throw new IllegalArgumentException("1 혹은 2를 입력해야합니다.");

        return flag;
    }

    public static boolean userNumberCheck(String str) {
        if (str.length() != 3) return false;

        else if (!Character.isDigit(str.charAt(0))) return false;
        else if (!Character.isDigit(str.charAt(1))) return false;
        else if (!Character.isDigit(str.charAt(2))) return false;

        else if (str.charAt(0) == str.charAt(1)) return false;
        else if (str.charAt(0) == str.charAt(2)) return false;
        else if (str.charAt(1) == str.charAt(2)) return false;

        return true;
    }

    public static boolean restartBaseBallGameCheck(Integer flag) {
        if (!flag.equals(1) && !flag.equals(2)) return false;

        return true;
    }
}
