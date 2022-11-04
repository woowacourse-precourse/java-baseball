package baseball.view;

import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);

    public static void output (String Message) {
        System.out.print(Message);
    }

    public static void outputLine(String Message) {
        System.out.println(Message);
    }

    public static String inputLine() {
        String line = readLine();
        return line;
    }
}
