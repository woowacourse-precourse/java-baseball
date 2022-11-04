package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameIO {

    private static GameIO instance;

    public GameIO() {
    }

    public static GameIO getInstance() {
        if (instance == null) {
            instance = new GameIO();
        }
        return instance;
    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public boolean isLegalInput(String input) throws IllegalArgumentException {
        if (!(isOnlyNumber(input) && isThreeDigit(input) && isAllDifferent(input))) {
            throw new IllegalArgumentException();
        }
        return true;
    }
    public boolean isOnlyNumber(String input) {
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return false;
        }
        return true;
    }
    public boolean isThreeDigit(String input) {
        if (input.length() != 3) {
            return false;
        }
        return true;
    }
    public boolean isAllDifferent(String input) {
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        if (first == second || second == third || first == third) {
            return false;
        }
        return true;
    }

    public String convertIntToString(int intValue) {
        return String.valueOf(intValue);
    }

    public void printStartLog() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printGameEndInfo() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void printFinishLog() {
        System.out.println("게임을 종료합니다. 즐거우셨나요?");
    }
    public void printResult(String result) {
        System.out.println(result);
    }
    public void printInputExceptionLog() {
        System.out.println("입력이 잘못되었습니다. 게임을 종료합니다.");
    }
}
