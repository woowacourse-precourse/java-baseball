package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerAnswer;

    public List<Integer> inputAnswer() {
        String inputAnswer = Console.readLine();

        validate(inputAnswer);
        toList(inputAnswer);

        return this.playerAnswer;
    }

    public void validate(String inputAnswer) {

    }

    public void toList(String inputAnswer) {
        List<Integer> playerAnswer = new ArrayList<>();
        for (String digit : inputAnswer.split("")) {
            playerAnswer.add(Integer.parseInt(digit));
        }
        this.playerAnswer = playerAnswer;
    }
}
