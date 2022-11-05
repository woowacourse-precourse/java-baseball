package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Player {
    public List<String> inputAnswer() {
        String inputAnswer = Console.readLine();
        List<String> playerAnswer = List.of(inputAnswer.split(""));


        return playerAnswer;
    }

}
