package baseball.bo;

import java.util.List;

public class StrikesAndBalls {
    private List<Integer> strikesAndBalls;

    public StrikesAndBalls(int strikes, int balls) {
        this.strikesAndBalls = List.of(strikes, balls);
    }

    private void setStrikesAndBalls(int strikes, int balls) {
        this.strikesAndBalls = List.of(strikes, balls);
    }

    public List<Integer> getStrikesAndBalls() {
        return strikesAndBalls;
    }

    public int getStrikes() {
        return strikesAndBalls.get(0);
    }

    public void calcStrikesAndBalls(List<Integer> users, List<Integer> answers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(answers.get(i))) {
                strikes++;
                continue;
            }
            if (users.contains(answers.get(i))) {
                balls++;
            }
        }
        this.setStrikesAndBalls(strikes, balls);
    }

}
