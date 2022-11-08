package baseball.view;

import baseball.util.GameUtil;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayerInput {
    public static List<Integer> inputPlayerNumber(){ //Game Class
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = readLine();
        if (!isRightInput(playerInput)) {
            throw new IllegalArgumentException();
        }
        return GameUtil.stringToIntList(playerInput);
    }

    public static boolean isRightInput(String input) { //Game Class
        if (input.length() != 3) return false;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) return false;
        }
        return true;
    }

    public static boolean inputContinue() { //Game Class
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int answer = Integer.parseInt(readLine());
        if (answer == 1) return true;
        return false;
    }
}
