package baseball;

import static baseball.Const.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Printer {

    private static final BufferedWriter bufferedWriter;

    static {
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void start() {
        println(START_GAME);
    }

    public static void finish() {
        println(FINISH_GAME);
    }

    private static void print(String s){
        try {
            bufferedWriter.write(s);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void println(String s) {
        try {
            bufferedWriter.write(s);
            bufferedWriter.write(LF);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
