package baseball.game;

import baseball.view.InputView;

import java.util.Scanner;

import static baseball.game.Game.*;
import static baseball.game.Option.COUNT_BALL;
import static baseball.game.Option.RESTART;
import static baseball.game.exception.ExceptionCase.*;
import static baseball.view.InputView.inputRestartView;
import static baseball.view.InputView.startProgramView;
import static baseball.view.OutputView.*;


public class GameController {
    public static void start(){
        Game game = new Game();
        playGame();
    }
    public static void playGame(){
        String input = InputView.inputNumbersView();
        catchSpaceException(input);
        setUserNumber(input);
        countScore();
        result();
    }
    private static void countScore(){
        ball = 0;
        strike = 0;
        for(int i=0;i<COUNT_BALL;i++){
            countStrike(i);
        }
    }
    private static void restart(){
        String input = inputRestartView();
        catchWrongOrderRestartException(input);
        if(input.equals(RESTART)){
            start();
        }
    }
    private static void result(){
        resultView(strike,ball);
        if(strike==3){
            threeStrike();
            restart();
            return;
        }
        playGame();
    }
    private static void countStrike(int i){
        if(userNumbers.get(i).equals(computerNumbers.get(i))){
            strike++;
        }else if(computerNumbers.contains(userNumbers.get(i))){
            ball++;
        }
    }
}
