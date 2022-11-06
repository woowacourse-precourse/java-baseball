package io;

import camp.nextstep.edu.missionutils.Console;

public class IOProcessor {
    public static String getUserInput(String message, String postfix) {
        System.out.print(message + postfix);
        return Console.readLine();
    }
}