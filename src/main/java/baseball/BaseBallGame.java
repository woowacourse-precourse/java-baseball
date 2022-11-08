package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private static List<Integer> computerNumber;
    private static List<Integer> userNumber;
    private static boolean isPlay = true;

    private static Hint hint;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isPlay) {
            play();
        }
    }

    private void play() {
        computerNumber = makeNumber();
        while (true) {
            userNumber = getUserNumber();

            getHint();
        }
    }

    public static List<Integer> makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> user = new ArrayList<>();
        String input = Console.readLine();
        System.out.println(input);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int n = charToNumber(c);
            if (input.length() != 3 || c < '1' || c > '9' || user.contains(n)) {
                throw new IllegalArgumentException("숫자 입력 오류");
            }
            user.add(n);
        }
        return user;
    }

    private static int charToNumber(char c) {
        return c - '0';
    }

    private static void getHint() {
        hint = new Hint();

        for (int i = 0; i < computerNumber.size(); i++) {
            for (int j = 0; j < userNumber.size(); j++) {
                int computer = computerNumber.get(i);
                int user = userNumber.get(j);
                if (computer != user) {
                    continue;
                }
                if (isStrike(computer, user)) {
                    hint.addStrikeCount();
                }
                if (isBall(computer, user)) {
                    hint.addBallCount();
                }
            }
        }
        if (hint.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        String hintStr = hint.toStringBallCount() + " " + hint.toStringStrikeCount();
        System.out.println(hintStr.trim());
    }

    private static boolean isBall(int computer, int user) {
        return computerNumber.indexOf(computer) != userNumber.indexOf(user);
    }

    private static boolean isStrike(int computer, int user) {
        return computerNumber.indexOf(computer) == userNumber.indexOf(user);
    }
}
