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
        return score;
    }
}
