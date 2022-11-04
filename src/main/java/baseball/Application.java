package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            BullsAndCows game = new BullsAndCows();
            while ((doRepeat()) == 1) {
                game.playGame();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("잘못된 값을 입력하셨습니다.");
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }

    private static int doRepeat() {
        String repeatInput = getRepeatInput();
        if (!checkRepeatInputRegex(repeatInput)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(repeatInput);
    }

    private static String getRepeatInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        return Console.readLine();
    }

    private static boolean checkRepeatInputRegex(String repeatInput) {
        String regex = "^[1-2]$"; // 1 또는 2
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(repeatInput);
        return matcher.matches();
    }

}
