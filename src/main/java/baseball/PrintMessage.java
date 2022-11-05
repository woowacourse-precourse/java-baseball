package baseball;

import static baseball.Constant.*;
public class PrintMessage {

    Score score = new Score();

    public void gameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void gameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void enterNumber() {
        System.out.println(PLEASE_ENTER_NUMBERS);
    }

    public void chooseRestartOrQuitGame() {
        System.out.println(CHOOSE_TO_START_OR_QUIT_GAME);
    }

    public void ballCount() {
        score.getBall();
        System.out.print(score.ball+BALL);
    }

    public void strikeCount() {
        score.getStrike();
        System.out.print(score.strike+STRIKE);
    }

    public void notThing() {
        System.out.println(NOT_THING);
    }
}
