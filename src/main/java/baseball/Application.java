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
    private static boolean checkValidate (String number) {
        if (!checkLength(number))
            return false;
        if (!checkIsDigit(number))
            return false;
        return true;
    }
    private static boolean checkLength (String number) {
        if (number.length() != 3)
            return false;
        return true;
    }
    private static boolean checkIsDigit (String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c) | c!='0')
                return false;
        }
        return true;
    }
    private static String createAnswer () {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(Integer.toString(randomNumber));
            }
        }
        return String.join("",computer);
    }
    private static boolean isStrike (String input, String answer) {
        int strikeCnt = 0;
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i)==answer.charAt(i))
                strikeCnt++;
        }
        int ballCnt = input.length()-input.replaceAll("["+answer+"]","").length()-strikeCnt;
        if (strikeCnt == 3)
            return true;
        return false;
    }

}
