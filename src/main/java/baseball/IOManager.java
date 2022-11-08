package baseball;

import baseball.config.GameConfig;
import camp.nextstep.edu.missionutils.Console;

public class IOManager {
    public static void printProgramStartMessage() {
        System.out.print(GameConfig.messages.get("PROGRAM_START"));
    }

    public static int inputNumber() throws IllegalArgumentException {
        System.out.print(GameConfig.messages.get("REQUIRE_INPUT"));
        String line = Console.readLine();

        if(!checkValidInput(line)) {
            throw new IllegalArgumentException("wrong user input");
        }

        return Integer.parseInt(line);
    }

    private static boolean checkValidInput(String line) {
        if(line.length() != GameConfig.ANSWER_LEN) {
            return false;
        }

        for(int idx = 0; idx < GameConfig.ANSWER_LEN; idx++)
            if(line.charAt(idx) < '1' || line.charAt(idx) > '9') {
                return false;
            }

        return true;
    }

    public static void getHint(int ballNum, int strikeNum) {
        String hint = "";

        if(ballNum > 0) {
            hint += String.valueOf(ballNum) + "볼";
        }
        if(ballNum > 0 && strikeNum > 0) {
            hint += " ";
        }
        if(strikeNum > 0) {
            hint += String.valueOf(strikeNum) + "스트라이크";
        }

        if(hint.length() == 0) {
            hint = "낫싱";
        }

        System.out.println(hint);
    }

    public static void correctAnswer() {
        System.out.print(GameConfig.messages.get("CORRECT_ANSWER"));
    }

    public static boolean inputRestart() throws IllegalArgumentException {
        System.out.print(GameConfig.messages.get("ASK_RESTART"));
        String line = Console.readLine();

        if(line.equals("1")) {
            return true;
        }
        else if(line.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("wrong restart format");
    }
}