package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;

public class Application {
    // TODO: [4] 숫자 일치, 포함 여부 판독 기능
    public static boolean is3Strike(String answer, String user_answer) {
        int strike = 0;
        int ball = 0;
        for (int i=0; i < user_answer.length(); i++) {
            if (user_answer.charAt(i) == answer.charAt(i)) {
                strike++;
            } else if (answer.indexOf(user_answer.charAt(i)) >= 0) {
                ball++;
            }
        }
        String sentence = "";
        if (ball != 0) {
            sentence += ball + "볼";
        }
        if (strike != 0) {
            if (!sentence.equals("")) {
                sentence += " ";
            }
            sentence += strike + "스트라이크";
            if (strike == 3) {
                return true;
            }
        }

        if (sentence.equals("")) {
            sentence = "낫싱";
        }

        System.out.println(sentence);
        return false;
    }

    // TODO: [3] 랜덤 숫자 생성 기능
    public static String randomGenerator() {
        String computer = "";
        while (computer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String randomNumberToString = Integer.toString(randomNumber);
            if (!computer.contains(randomNumberToString)) {
                computer = computer + randomNumberToString;
            }
        }
        return computer;
    }

    // TODO: [2] 입력값 유효성 검사 기능
    public static boolean isValid(String sth) {
        if (!sth.matches("[1-9]{3}")) {
            return false;
        }
        String[] charArr = sth.split("");
        HashSet<String> charSet = new HashSet<>(Arrays.asList(charArr));
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

            if (is3Strike(answer, inputString)) {
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
