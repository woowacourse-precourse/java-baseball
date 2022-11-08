package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> computer = new ArrayList<>();
    static int strikeCount = 0;
    static int ballCount = 0;

    public static void main(String[] args) {
        do {
            while (strikeCount != 3) {//strickCount!=3
                System.out.println("숫자를 입력해주세요 : ");
                reset();
                List<Integer> input = valueToList(Integer.parseInt(Console.readLine()));
                strikeCount = strike(computer, input);
                ballCount = ball(computer, input);
                System.out.println(printCount());
            }
            //end game
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (replay(Console.readLine()));
        System.out.println("게임 종료");
    }

    private static boolean replay(String readLine) {
        if (readLine.equals("1")) return true;
        return false;
    }

    private static String printCount() {
        if (strikeCount == 0 && ballCount == 0) return "낫싱";

        if (ballCount == 0 && strikeCount != 0) return strikeCount + "스트라이크";

        if (strikeCount == 0 && ballCount != 0) return ballCount + "볼";

        return ballCount + "볼 " + strikeCount + "스트라이크";

    }

    public static List<Integer> valueToList(int value) {
        List<Integer> list = new ArrayList<>();

        while (value / 10 != 0) {
            list.add(0, value % 10);
            value /= 10;
        }
        list.add(0, value % 10);
        return list;
    }

    private static int ball(List<Integer> computer, List<Integer> input) {
        int ball = 0;
        for (int i = 0; i < computer.size(); i++)
            if (!computer.get(i).equals(input.get(i)) && computer.contains(input.get(i))) ball++;
        return ball;
    }

    private static int strike(List<Integer> computer, List<Integer> input) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i++)
            if (computer.get(i).equals(input.get(i))) strike++;
        return strike;
    }

    private static void reset() {
        strikeCount = 0;
        ballCount = 0;
        computer.clear();
        generateNum();
    }

    public static void generateNum() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) computer.add(randomNumber);
        }
    }
}