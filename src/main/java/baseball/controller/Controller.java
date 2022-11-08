package baseball.controller;

import baseball.ui.HintView;
import baseball.ui.InputView;
import baseball.ui.ResultView;
import baseball.model.Result;
import baseball.model.State;
import baseball.service.Service;

public class Controller {
    InputView inputView;
    ResultView resultView;
    HintView hintView;
    Service service;
    State state;

    public Controller(){
        state = State.PROCEEDING;
        service = new Service();
        inputView = new InputView();
        resultView = new ResultView();
        hintView = new HintView();
    }

    public void playGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(isRestart()){
            playGameOneCycle();
        }
    }

    private void playGameOneCycle(){
        sendInputToService();
        sendToHintView();
        if(state == State.FINISH){
            getResult();
            restartGame();
        }

    }

    private void sendInputToService(){
        inputView.getBaseballInput();
        hintView.setHint(service.generateHint(inputView.getInput()));
    }

    private void sendToHintView(){
        hintView.printHint();
        if(hintView.checkWinningCondition()){
            state = State.FINISH;
        }
    }
    private void getResult(){
        resultView.printResult(state);
    }

    private boolean isRestart(){
        Result result = resultView.getResult();
        return result == Result.RESTART;
    }

    private void restartGame(){
        if(isRestart()){
            state = State.PROCEEDING;
            service.resetRandomAnswer();
        }
    }

}
