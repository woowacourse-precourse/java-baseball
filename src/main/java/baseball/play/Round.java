package baseball.play;

import baseball.input.UserInput;
import baseball.output.Guide;
import baseball.output.Result;

import java.util.*;

public class Round {
    UserInput userInput = new UserInput();

    public void run(List<Integer> computerNumberList) {
        Result result = new Result();

        do {
            Guide.printInputGuide();
            List<Integer> userNumberList = userInput.getNumberList();
            result.updateResult(userNumberList, computerNumberList);
            result.printResult();
        } while (!result.getCorrect());

        Guide.printEndingGuide();
    }
}
