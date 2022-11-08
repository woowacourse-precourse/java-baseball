package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<Integer> enterNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();

        validateIsThreeNumber(playerInput);
        validateIsUniqueNumber(playerInput);

        return convertToIntegerList(playerInput);
    }

    public boolean wantToRestart() {
        int RESTART_NUMBER = 1;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerInput = enterRestartNumber();
        return playerInput == RESTART_NUMBER;
    }


    public int enterRestartNumber() {
        String playerInput = Console.readLine();
        validateIsRestartNumber(playerInput);
        return Integer.parseInt(playerInput);
    }

    private void validateIsThreeNumber(String playerInput) {
        if (!playerInput.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private void validateIsUniqueNumber(String playerInput) {
        int COMPARE_LENGTH = 3;
        long inputLength = Arrays.stream(playerInput.split("")).distinct().count();
        if (COMPARE_LENGTH != inputLength) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private void validateIsRestartNumber(String playerInput) {
        if (!playerInput.matches("^[1-2]$")) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    public static List<Integer> convertToIntegerList(String playerInput) {
        return Arrays.stream(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

}
