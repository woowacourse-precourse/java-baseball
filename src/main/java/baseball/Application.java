package baseball;

import baseball.play.Play;

import static baseball.play.Play.START_MESSAGE;

public class Application {
    public static void main(String[] args) {
        Play play = new Play();
        System.out.println(START_MESSAGE);
        play.playBaseball();
    }
}
