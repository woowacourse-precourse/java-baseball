package baseball.model;

import java.util.List;

import static baseball.model.NumberProperty.SIZE;
import static baseball.view.Message.*;

public class Judge {
    private int count = 0, strike = 0;

    public void compareNumbers(List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < SIZE.get(); i++) {
            if (player.contains(computer.get(i))) {
                count++;
            }
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
    }

    public StringBuilder setResult() {
        StringBuilder resultMessage = new StringBuilder();
        if (count == 0) resultMessage.append(NOTHING.get());
        if (count != strike) resultMessage.append(count - strike).append(BALL.get());
        if (strike != 0) resultMessage.append(strike).append(STRIKE.get());
        resultMessage.append("\n");
        if (strike == SIZE.get()) resultMessage.append(SUCCESS.get());

        return resultMessage;
    }

    public boolean gameSucceeded() {
        return strike == SIZE.get();
    }
}
