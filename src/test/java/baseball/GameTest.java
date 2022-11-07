package baseball;

import baseball.Domain.Game;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void 컴퓨터_랜덤숫자_생성() {
        Game game = new Game();
        game.setAnswerNumber();
        System.out.println(game.answerNumber);
    }
}
