package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class View {
    public abstract void show();

    public String getResponse() {
        return "";
    }

    public static void printLine(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static String readLine(String message) {
        print(message + " : ");
        String readLine = Console.readLine();
        //printLine("");

        return readLine;
    }
}
