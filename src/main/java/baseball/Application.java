package baseball;

public class Application {
    public static void main(String[] args) {
        int nextRound;

        do {
            BaseballGame.Round();
            nextRound = BaseballGame.NextRound();
        } while(nextRound == 1);
    }
}
