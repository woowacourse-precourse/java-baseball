package baseball.game;

import java.util.Objects;

public class Score {
    private final Game game;

    public Score(Game game) {
        this.game = game;
    }

    public Integer strike(){
        int score = 0;
        for (int i = 0; i<game.getComputers().size();i++){
            if (Objects.equals(game.getComputers().get(i),
                    game.getUserNumbers().get(i)))
                score ++;
        }
        if (score == 3) game.answerIsCorrect();
        return score;
    }

    public Integer ball(){
        int score = 0;
        for (int i = 0; i<game.getUserNumbers().size();i++){
            int n = game.getUserNumbers().get(i);
            if (game.getComputers().contains(n)
                    && game.getComputers().indexOf(n) != i)
                score ++;
        }
        return score;
    }

    public Boolean ifNothing(){
        for (int n : game.getUserNumbers()) {
            if (game.getComputers().contains(n))
                return false;
        }
        return true;
    }
}
