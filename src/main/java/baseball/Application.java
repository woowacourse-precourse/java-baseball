package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String menu = "";
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!menu.equals("2")) {
            gameStart();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            menu = Console.readLine();
        }
    }

    public static List<Integer> makeRandomNumber() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    public static String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) > 57 || input.charAt(i) < 49) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < 9; i++) {
            if (countChar(input, (char)(49 + i)) != 0) {
                throw new IllegalArgumentException();
            }
        }

        return input;
    }

    public static int countChar(String input, char ch) {
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                cnt++;
            }
        }

        return cnt;
    }

    public static List<Integer> compareNumber(String input, List<Integer> computer) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < computer.size(); i++) {
            String str = Integer.toString(computer.get(i));

            if (input.contains(str) && input.indexOf(str) == i) {
                strikeCnt++;
            } else if (input.contains(str)) {
                ballCnt++;
            }
        }
        return List.of(strikeCnt, ballCnt);
    }

    public static void printResult(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }

            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
    }

    public static boolean quit(int strike) {
        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    public static void gameStart() {
        List<Integer> computer = makeRandomNumber();

        while (true) {
            String input = getNumber();
            List<Integer> cnt = compareNumber(input, computer);

            printResult(cnt.get(1), cnt.get(0));
            if (quit(cnt.get(0))) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}