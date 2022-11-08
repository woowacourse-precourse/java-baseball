package baseball;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ExecuteGame executeGame = new ExecuteGame();

        do {
        executeGame.play();
        } while (executeGame.canRepeatGame());
    }
}
