package baseball.view;

import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);

    public static void output (String Message) {
        System.out.println(Message);
    }

    public static void outputLine(String Message) {
        System.out.println(Message);
    }

    public static String inputLine() {
        String line = AppView.scanner.nextLine().trim();

        while(line.equals("")) {
            line = AppView.scanner.nextLine().trim();
        }

        return line;
    }

}
