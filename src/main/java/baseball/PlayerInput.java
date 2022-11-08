package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PlayerInput {

    private static final String NUMBER_PATTERN = "[1-9]{3}";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String EXCEPTION_MESSAGE = "잘못된 값을 입력하였습니다.";

    public static List<Integer> inputPlayerNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        System.out.print(INPUT_MESSAGE);
        String playerInputs = Console.readLine();
        validatePlayerNumber(playerInputs);
        for (String playerInput : playerInputs.split("")) {
            playerNumber.add(Integer.parseInt(playerInput));
        }
        return playerNumber;
    }

    public static String inputRestartGame() {
        String gameProgress = Console.readLine();
        if (!gameProgress.equals(Game.RESTART_NUMBER) && !gameProgress.equals(Game.TERMINATE_NUMBER)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + Game.TERMINATE_MESSAGE);
        }
        return gameProgress;
    }

    private static void validatePlayerNumber(String playerInputs) {
        if(!Pattern.matches(NUMBER_PATTERN, playerInputs)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + Game.TERMINATE_MESSAGE);
        }

        for (int i = 0; i < playerInputs.length(); i ++) {
            if(playerInputs.indexOf(playerInputs.charAt(i)) != i) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
