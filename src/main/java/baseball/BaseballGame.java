package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    BaseballGame() {

    }

    public void start() {

    }

    void finishOneGame() {

    }

    boolean continueGame() {
        return false;
    }

    void finishEntireGame() {

    }

    class Computer {
        List<Integer> answer = new ArrayList<>();
        boolean isGameEnd = false;

        void setAnswer() {
            answer.clear();
            while (answer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!answer.contains(randomNumber)) {
                    answer.add(randomNumber);
                }
            }
        }

        void giveResult(List<Integer> suggestion) {
            final int MAX_STRIKE = 3;
            int strike = checkStrike(suggestion);
            int ball = checkBall(suggestion);
            if (ball != 0) System.out.print(ball + "볼 ");
            if (strike != 0) System.out.print(strike + "스트라이크");
            if (ball == 0 && strike == 0) System.out.print("낫싱");
            System.out.println("");
            if (strike == MAX_STRIKE) {
                setIsGameEnd(true);
            }
        }

        int checkBall(List<Integer> suggestion) {
            int ball = 0;
            for (int i = 0; i < answer.size(); i++) {
                if (answer.get(i) != suggestion.get(i) && suggestion.contains(answer.get(i))) {
                    ball++;
                }
            }
            return ball;
        }

        int checkStrike(List<Integer> suggestion) {
            int strike = 0;
            for (int i = 0; i < answer.size(); i++) {
                if (answer.get(i) == suggestion.get(i)) {
                    strike++;
                }
            }
            return strike;
        }

        void setIsGameEnd(boolean toSet) {
            isGameEnd = toSet;
        }

        public boolean getIsGameEnd(){
            return isGameEnd;
        }
    }
}

class Player {
    String input() {
        return "";
    }

    List<Integer> suggest() {
        List<Integer> suggestion = new ArrayList<>();
        return suggestion;
    }

    boolean validSuggestion() {
        return false;
    }

    boolean continueGame() {
        return false;
    }

    boolean validContinueGame() {
        return false;
    }

}

