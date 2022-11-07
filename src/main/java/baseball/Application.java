package baseball;

import baseball.domain.game.baseball.ConcreteCreatorBaseBall;
import baseball.view.BaseBallInput;
import baseball.view.UserInput;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        ConcreteCreatorBaseBall concreteCreatorBaseBall = new ConcreteCreatorBaseBall();
        concreteCreatorBaseBall.createGame();
    }
}