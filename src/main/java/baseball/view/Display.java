package baseball.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static baseball.entity.NumberBaseball.GAME_ANSWER_MAX_VALUE;

public class Display {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void printInitMessage() {
        try {
            bw.write("숫자 야구 게임을 시작합니다.\n");
            bw.flush();
        } catch (IOException e) {

        }
    }

    public void printInputNumberMessage() {
        try {
            bw.write("숫자를 입력해주세요 : ");
            bw.flush();
        } catch (IOException e) {

        }
    }

    public void printEndingMessage() {
        try {
            bw.write(GAME_ANSWER_MAX_VALUE + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            bw.flush();
        } catch (IOException e) {

        }
    }

    static void printReGameMessage() {
        try {
            bw.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            bw.flush();
        } catch (IOException e) {

        }
    }

    void printBallAndStrikeMessage(int ball, int strike) {
        try {
            printBallMessage(ball);
            bw.write(" ");
            printStrikeMessage(strike);
        } catch (IOException e) {

        }
    }

    void printBallMessage(int n) {
        try {
            bw.write(n + "볼");
        } catch (IOException e) {

        }
    }

    void printStrikeMessage(int n) {
        try {
            bw.write(n + "스트라이크");
        } catch (IOException e) {

        }
    }

    void printNothingMessage() {
        try {
            bw.write("낫싱");
            bw.flush();
        } catch (IOException e) {

        }
    }

    void printNewLine() {
        try {
            bw.newLine();
        } catch (IOException e) {

        }
    }
}
