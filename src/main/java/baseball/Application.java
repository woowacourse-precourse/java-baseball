package baseball;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        PrintStream ps = new PrintStream(System.out);
        ExecuteGame executeGame = new ExecuteGame(System.in, ps);

        do {
        executeGame.play();
        } while (executeGame.canRepeatGame());
    }
}
