package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    public Answer inputAnswer() throws IllegalArgumentException {
        String inputAnswer = Console.readLine();
        Answer playerAnswer = new Answer(List.of(inputAnswer.split("")));

        playerAnswer.validate();

        return playerAnswer;
    }

}
