package baseball;

import baseball.play.GameProgressFlow;

import static baseball.print.OutputStatement.informStartNumberBaseballGame;

public class Application {

    public static void main(String[] args) {
        GameProgressFlow gameProgressFlow = new GameProgressFlow();

        informStartNumberBaseballGame();
        gameProgressFlow.startGame();
    }
}