package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        RandomBallNumbersGenerator randomBallNumbersGenerator = new RandomBallNumbersGenerator();
        do {
            List<BallNumber> randomBallNumbers = randomBallNumbersGenerator.createRandomBallNumbers();
            game.play(randomBallNumbers);
        } while (game.restart());
    }
}
