package baseball.domain;

import java.util.List;

public class Rule {
    private final boolean gameOver;

    public Rule() {
        gameOver = false;
    }

    public void getHint(List<Integer> numbers, List<Integer> computerNumbers) {
        for(int i=0; i<numbers.size(); i++) {
            int number = computerNumbers.indexOf(numbers.get(i));
            if(i == number) {
                Hint.addCount(Hint.STRIKE);
            }
            else if(number != -1) {
                Hint.addCount(Hint.BALL);
            }
        }

        System.out.println(Hint.getHintByCount());
    }

    public String gameOver() {
        return "";
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
