package baseball.play;

import baseball.input.UserInput;
import baseball.output.Guide;
import baseball.output.Result;

import java.util.*;

public class Round {
    private final UserInput userInput = new UserInput();

    public void run(List<Integer> computerNumberList){
        boolean isCorrect = false;

        do{
            List<Integer> userNumberList = userInput.getNumberList();
            Result result = new Result(userNumberList, computerNumberList);
            result.printResult();
            isCorrect = result.getIsCorrect();
        }while(!isCorrect);

        Guide.printEndingGuide();
    }
}
