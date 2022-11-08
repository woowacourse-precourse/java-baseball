package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Node {

    String num;
    int strike;
    int ball;

    public Node(String num, int strike, int ball) {
        this.num = num;
        this.strike = strike;
        this.ball = ball;
    }
}

public class Application {


    static boolean restartGameYn = false;
    static boolean exitGameYn = false;

    public static String makeTargetNum() {

        List<Integer> target = new ArrayList<>();

        while (target.size() < 3) {
            int n = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(n)) {
                target.add(n);
            }
        }

        System.out.println("target " + target);
        String stringOfTargetNum = "";
        for (int n : target) {
            stringOfTargetNum += n;
        }

        return stringOfTargetNum;

    }

    public static void isValidate(String input) {

        char[] inputToArr = input.toCharArray();

        for (char c : inputToArr) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("오직 숫자만 입력 가능합니다.");
            }
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리수만 입력 가능합니다.");
        }

        if (Integer.parseInt(input) < 123 || 987 < Integer.parseInt(input)) {
            throw new IllegalArgumentException("중복 없는 세 자리수만 입력 가능합니다.");
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException("0을 제외한 세 자리 수를 입력하세요.");
        }

        if (inputToArr[0] == inputToArr[1] || inputToArr[1] == inputToArr[2]
            || inputToArr[0] == inputToArr[2]) {
            throw new IllegalArgumentException("중복이 없는 세 자리 수를 입력하세요.");
        }

    }

    public static Node baseball(String target, String num) {

        Node node = new Node(num, 0, 0);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i == j && target.charAt(i) == num.charAt(j)) {
                    ++node.strike;
                } else if (target.charAt(i) == num.charAt(j)) {
                    ++node.ball;
                }
            }
        }

        return node;
    }

    public static void restartOrExit(String str) {

        if (str.equals("2")) {
            exitGameYn = true;

        }

        if (str.equals("1")) {
            restartGameYn = true;

        }

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1
        String target = makeTargetNum();

        // 2
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 3
        while (true) {

            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            isValidate(input);
            Node node = baseball(target, input);

            if (exitGameYn) {
                break;
            }
            if (restartGameYn) {
                restartGameYn = false;  //  초기화
                target = makeTargetNum();
            }


        }


    }


}
