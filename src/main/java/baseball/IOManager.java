package baseball;

import java.util.Map;
import camp.nextstep.edu.missionutils.Console;

public class IOManager {
    private static final Map<String, String> messages = Map.of(
            "PROGRAM_START", "숫자 야구 게임을 시작합니다.\n",
            "REQUIRE_INPUT", "숫자를 입력해주세요 : ",
            "CORRECT_ANSWER", "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n",
            "ASK_RESTART", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
    );

    public static void printProgramStartMessage() {
        System.out.print(messages.get("PROGRAM_START"));
    }

    public static int inputNumber() throws IllegalArgumentException {
        System.out.print(messages.get("REQUIRE_INPUT"));
        String line = Console.readLine();

        if(!checkValidInput(line))
            throw new IllegalArgumentException("wrong user input");

        return Integer.parseInt(line);
    }

    private static boolean checkValidInput(String line) {
        if(line.length() != GameConfig.ANSWER_LEN)
            return false;

        for(int idx = 0; idx < GameConfig.ANSWER_LEN; idx++)
            if(line.charAt(idx) < '1' || line.charAt(idx) > '9')
                return false;

        return true;
    }

    public static void getHint(int ballNum, int strikeNum) {
        String hint = "";

        if(ballNum > 0)
            hint += String.valueOf(ballNum) + "볼";
        if(ballNum > 0 && strikeNum > 0)
            hint += " ";
        if(strikeNum > 0)
            hint += String.valueOf(strikeNum) + "스트라이크";

        if(hint.length() == 0)
            hint = "낫싱";

        System.out.println(hint);
    }

    public static void correctAnswer() {
        System.out.print(messages.get("CORRECT_ANSWER"));
    }

    public static boolean inputRestart() throws IllegalArgumentException {
        System.out.print(messages.get("ASK_RESTART"));
        String line = Console.readLine();

        if(line.equals("1"))
            return true;
        else if(line.equals("2"))
            return false;

        throw new IllegalArgumentException("wrong restart format");
    }
}