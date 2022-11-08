package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.lang.IllegalArgumentException;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        startMessage();
        String answer = createAnswer();

        while (true) {
            String input = getInput();
            if (!isStrike(input, answer))
                continue;
            else if (isStop())
                break;
            answer = createAnswer();
        }
    }
    private static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private static void inputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static String getInput() {
        inputMessage();
        String number = Console.readLine();
        if (!checkValidate(number)) {
            throw new IllegalArgumentException();
        }
        return number;
    }
    public static boolean checkValidate (String number) {
        if (!checkLength(number))
            return false;
        if (!checkIsDigit(number))
            return false;
        return true;
    }
    public static boolean checkLength (String number) {
        if (number.length() != 3)
            return false;
        return true;
    }
    public static boolean checkIsDigit (String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c) | c == '0')
                return false;
        }
        return true;
    }
    public static String createAnswer () {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(Integer.toString(randomNumber));
            }
        }
        return String.join("",computer);
    }
    public static boolean isStrike (String input, String answer) {
        int strikeCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i))
                strikeCnt++;
        }
        int ballCnt = input.length()-input.replaceAll("["+answer+"]","").length()-strikeCnt;
        strikeMessage(strikeCnt, ballCnt);
        if (strikeCnt == 3)
            return true;
        return false;
    }
    public static void strikeMessage (int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크\n"+"3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"+"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else if (strike + ball == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike+"스트라이크");
        } else if (strike == 0) {
            System.out.println(ball+"볼");
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
    public static boolean isStop () {
        int input = Integer.parseInt(Console.readLine());
        if (input == 2)
            return true;
        if (input == 1)
            return false;
        throw new IllegalArgumentException();
    }
}
