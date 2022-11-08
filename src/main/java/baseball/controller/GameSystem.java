package baseball.controller;

import baseball.view.Result;
import baseball.model.Answer;
import baseball.model.StrikeBall;
import baseball.model.UserGuess;
import baseball.model.UserTerminate;
import baseball.view.InitAnswer;
import baseball.view.UserGuessInput;
import baseball.view.UserTerminateInput;

import java.util.List;
import java.util.Map;

public class GameSystem extends BaseballGameException {
    private boolean isExit;
    private boolean isAnswer;

    public void GameProcess(){
        Answer answer = new Answer();
        InitAnswer initAnswer = new InitAnswer();
        UserTerminateInput userTerminateInput = new UserTerminateInput();
        this.isExit = false;
        this.isAnswer = false;

        while(!isExit){
            List<Integer> baseballAnswer = initAnswer.initAnswerList(answer);
            InGame(isAnswer, baseballAnswer);

            String terminateInput = userTerminateInput.processTerminate();

            UserTerminate userTerminate = new UserTerminate(terminateInput);
            userTerminate.convertStringToInteger();
            Integer terminateValue = userTerminate.getTerminate();

            chkUserTerminateInputValid(terminateValue);

            if(userTerminateInput.permitTerminate(terminateValue)){
                break;
            }
        }
    }

    public void InGame(boolean isAnswer, List<Integer> baseballAnswer){
        UserGuessInput userGuessInput = new UserGuessInput();
        UserGuess userGuess = new UserGuess();
        while(!isAnswer){
            String initUserGuess = userGuessInput.processGuess();
            userGuess.convertStringToList(initUserGuess);
            List<Integer> convertedUserGuess = userGuess.getGuess();
            chkUserGuessInputValid(convertedUserGuess);

            StrikeBall strikeBall = new StrikeBall(convertedUserGuess,baseballAnswer);
            strikeBall.countBall();
            strikeBall.countStrike();
            Map<String, Integer> count = strikeBall.getCount();

            Result result = new Result(count);
            isAnswer = result.showResult();

            if(isAnswer) break;
        }
    }
}
