package baseball.inputoutput;

import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class Outputing {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final String inputNumberMsg = "숫자를 입력해주세요 : ";
    private static final String gameEndMsg = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String gameStartMsg = "숫자 야구 게임을 시작합니다.";


    public static void exitOutput() throws IOException {
        bw.close();
    }

    //===============writing===============

    public static void writeCase(int strike, int ball) throws IOException {

        if (ball > 0) {
            bw.write(String.format("%d볼 ", ball));
        }

        if (strike > 0) {
            bw.write(String.format("%d스트라이크", strike));
        }

        if (ball==0 && strike==0) {
            bw.write(String.format("낫싱"));
        }
    }

    //================printing====================

    public static void printLine() throws IOException {
        bw.append("\n");
        bw.flush();
    }

    public static void printGameEnd() throws IOException {
        bw.append(gameEndMsg);
        printLine();
    }

    public static void printGameStart() throws IOException {
        bw.append(gameStartMsg);
        printLine();
    }

    public static void printInputting() throws IOException {
        bw.append(inputNumberMsg);
        bw.flush();
    }

}
