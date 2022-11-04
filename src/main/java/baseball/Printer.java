package baseball;

import baseball.score.Score;

public class Printer {
    public static void println(Score score) {
        Printer.println(score.toString());
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void print(String str) {
        System.out.print(str);
    }
}
