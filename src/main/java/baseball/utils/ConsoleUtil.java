package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleUtil {
    public static void printIntro() {
        printLine("┏━━━━━━━━━━┓");
        printLine("   숫자 야구");
        printLine("┗━━━━━━━━━━┛");
        printLine("우아한테크코스 5기 프리코스 2주차 미션");
        printLine("만든이: 윤창욱 (Laeng)");
        printLine("");
    }

    public static void printHowToPlay() {
        printLine("┏━━━━━━━━━━┓");
        printLine("   게임 소개");
        printLine("┗━━━━━━━━━━┛");
        printLine("숫자 야구는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이에요.");
        printLine("여러분들이 컴퓨터가 생각한 3자리의 수를 모두 맞춰 '3스트라이크'를 하면 게임이 끝나요.");
        printLine("");
        printLine("예를 들어 컴퓨터가 생각한 3자리의 수가 425라고 가정해봐요.");
        printLine(" - 123을 입력했을 때 컴퓨터는 '1스트라이크' 라고 알려줘요.");
        printLine(" - 456을 입력했을 때 컴퓨터는 '1볼 1스트라이크' 라고 알려줘요.");
        printLine(" - 789를 입력했을 때 컴퓨터는 '낫싱' 이라고 알려줘요.");
        printLine("");
        printLine("이렇게 컴퓨터가 알려준 힌트를 통해 3자리의 숫자를 입력하여 컴퓨터가 생각하는 숫자를 맞추면 돼요.");
        printLine("중복되는 숫자가 없는 3자리의 숫자를 입력하는 것을 잊지 마세요.");
        printLine("이제 게임을 시작해볼까요?");
    }

    public static void printFinish(int strikePoint) {
        printLine(strikePoint + "개의 숫자를 모두 맞히셨습니다!");
    }

    public static void printQuit() {
        printLine("게임 종료");
    }

    public static String printThreeDigitNumberEnterQuestion() {
        return printQuestionAndWaitAnswer("숫자를 입력해주세요");
    }

    public static String printGameRestartQuestion() {
        return printQuestionAndWaitAnswer("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    private static String printQuestionAndWaitAnswer(String message) {
        print(message + " : ");
        String readLine = readLine();
        printLine("");

        return readLine;
    }

    public static void printLine(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static String readLine() {
        return Console.readLine();
    }
}