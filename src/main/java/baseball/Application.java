package baseball;

import baseball.domain.game.baseball.ConcreteCreatorBaseBall;
import baseball.domain.game.baseball.CreateBaseBall;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ConcreteCreatorBaseBall concreteCreatorBaseBall = new ConcreteCreatorBaseBall();
        CreateBaseBall game = new CreateBaseBall();
//        재시작 기능 구현
        concreteCreatorBaseBall.startGame();
    }
}