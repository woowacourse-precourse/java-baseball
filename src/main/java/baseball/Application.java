package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;

public class Application {
    // TODO: [2] 입력값 유효성 검사 기능
    public static boolean isValid(String sth) {
        if (!sth.matches("[1-9]{3}")) {
            return false;
        }
        String[] charArr = sth.split("");
        HashSet<String> charSet = new HashSet<String>(Arrays.asList(charArr));
        if (charSet.size() != sth.length()) {
            return false;
        }
        return true;
    }

    // TODO: [1] 사용자 입력 및 게임 재시작/종료 기능 구현
    public static boolean game() {
        String answer = "123";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();
            if (!isValid(inputString)) {
                throw new IllegalArgumentException("1-9 사이의 서로 다른 숫자 3개를 공백없이 입력해주셔야 합니다.");
            }

            if (answer.equals(inputString)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String flag = Console.readLine();
            if (flag.equals("2")) {
                break;
            } else if (flag.equals("1")) {
                continue;
            } else {
                throw new IllegalArgumentException("유효하지 않은 값입니다. 게임 재시작: 1 / 종료: 2");
            }
        }
    }
}
