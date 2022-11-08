package baseball.utils;

import baseball.utils.resources.OutputMessage;

public class MessagePrinter {
    private MessagePrinter() { }

    public static void print(OutputMessage content) {
        System.out.print(content.text());
    }

    public static void printLine(OutputMessage content) {
        System.out.println(content.text());
    }

    public static void printLine(String text) {
        System.out.println(text);
    }
}
