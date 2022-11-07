package baseball.domain;


public class BaseballGame {

    private Computer computer;
    private Score score;

    private BaseballGame() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public void init() {
        computer.init();
        score.init();
    }

    public static class Builder {
        private BaseballGame baseballGame = new BaseballGame();

        public Builder computer(Computer computer) {
            baseballGame.computer = computer;
            return this;
        }

        public Builder score(Score score) {
            baseballGame.score = score;
            return this;
        }

        public BaseballGame build() {
            return baseballGame;
        }
    }
}
