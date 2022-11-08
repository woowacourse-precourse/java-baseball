package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class View {
    public abstract void show();

    public String getResponseToString() {
        return "";
    }

    public boolean getResponseToBoolean() {
        return false;
    }

    public void printLine(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public String readLine(String message) {
        print(message + " : ");
        String readLine = Console.readLine();
        printLine("");

        return readLine;
    }
}
