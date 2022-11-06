package baseball.game;

import baseball.view.InputView;

import java.util.ArrayList;

import static baseball.game.Game.*;
import static baseball.game.Option.COUNT_BALL;
import static baseball.game.Option.RESTART;
import static baseball.game.exception.ExceptionCase.*;
import static baseball.view.InputView.inputRestartView;
import static baseball.view.OutputView.*;


public class GameController {
    private static Integer index;
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
        index = 0;
        makeScoreList();
        userNumbers.stream().forEach(number->{
            countStrike(number,index);
            countBall(number,index);
            index++;
        });
    }
    private static void makeScoreList(){
        score = new ArrayList<>();
        for(int i=0;i<COUNT_BALL;i++){
            score.add(false);
        }
    }
    private static void countStrike(Integer number,int index){
        if(number.equals(computerNumbers.get(index))){
            strike++;
            score.set(index,true);
        }
    }
    private static void countBall(Integer number,int index){
        if(!score.get(index).equals(true)&computerNumbers.contains(number)){
            ball++;
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
    private static void restart(){
        String input = inputRestartView();
        catchWrongOrderRestartException(input);
        if(input.equals(RESTART)){
            start();
        }
    }

}
