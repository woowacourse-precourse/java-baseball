package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public static String receiveUserInput() {
        Result.printEnterNumberMessage();
        String input = Console.readLine();

        validateInput(input);

        return input;
    }

    public static boolean wantRestart() {
        Result.printStartNewGameMessage();

        String response = Console.readLine();
        validateRestartFlag(response);

        return response.equals("1");
    }

    private static void validateInput(String input) {
        // 입력된 값이 숫자인지 확인
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
        }

        // 세 자리 수인지 확인
        if(input.length() != 3) {
            throw new IllegalArgumentException("입력된 숫자가 세 자리 수가 아닙니다.");
        }

        // 서로 다른 숫자인지 확인
        if(validateDuplicateDigits(input)) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야 합니다.");
        }
    }

    private static boolean validateDuplicateDigits(String input) {
        int[] digits = new int[10];
        for(int i = 0; i < 3; i++) {
            int n = Character.getNumericValue(input.charAt(i));
            digits[n]++;
        }
        for(int x : digits) {
            if(x > 1) return true;
        }
        return false;
    }

    private static void validateRestartFlag(String response) {
        if(!response.equals("1") && !response.equals("2")) {
            throw new IllegalArgumentException("게임을 재시작/종료 하려면 1 또는 2를 입력해야 합니다.");
        }
    }
}
