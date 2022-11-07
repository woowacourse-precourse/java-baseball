package baseball.game;

import java.util.List;
import java.util.Objects;

public class Score {
    private final List<Integer> user;
    private final Game game;

    public Score(Game game) {
        this.user = game.getUserNumbers();
        this.game = game;
    }

    public Integer strike(){
        int score = 0;
        for (int i = 0; i<game.getComputers().size();i++){
            if (Objects.equals(game.getComputers().get(i), user.get(i)))
                score ++;
        }
        if (score == 3) game.answerIsCorrect();
        return score;
    }

    public Integer ball(){
        int score = 0;
        for (int i = 0; i<user.size();i++){
            int n = user.get(i);
            if (game.getComputers().contains(n)
                    && game.getComputers().indexOf(n) != i)
                score ++;
        }
        return score;
    }

    public Boolean ifNothing(){
        for (int n : user) {
            if (game.getComputers().contains(n))
                return false;
        }
        return true;
    }
}
