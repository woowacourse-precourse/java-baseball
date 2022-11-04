package baseball;

import net.bytebuddy.pool.TypePool;

import java.util.Map;
import java.util.Scanner;

public class IOManager {
    private static final Scanner in = new Scanner(System.in);
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
        String line = in.nextLine();

        // if not valid
        // throw new IllegalArgumentException();

        return 0;
    }

    public static void correctAnswer() {
        System.out.print(messages.get("CORRECT_ANSWER"));
    }

    public static boolean inputRestart() throws IllegalArgumentException {
        System.out.print(messages.get("ASK_RESTART"));
        String line = in.nextLine();

        if(line.equals("1"))
            return true;
        else if(line.equals("2"))
            return false;

        throw new IllegalArgumentException("wrong restart format");
    }
}