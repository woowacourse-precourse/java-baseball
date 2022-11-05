package baseball.game;

import baseball.view.InputView;

import java.util.Scanner;

import static baseball.game.Game.*;
import static baseball.game.Option.COUNT_BALL;
import static baseball.view.InputView.inputRestartView;
import static baseball.view.InputView.startProgramView;
import static baseball.view.OutputView.*;


public class GameController {
    public static void start(Scanner scanner){
        startProgramView();
        Game game = new Game();
        playGame(scanner);
    }
    public static void playGame(Scanner scanner){
        String input = InputView.inputNumbersView(scanner);
        setUserNumber(input);
        countScore();
        result(scanner);
    }
    private static void countScore(){
        ball = 0;
        strike = 0;
        for(int i=0;i<COUNT_BALL;i++){
            countStrike(i);
        }
    }
    private static void result(Scanner scanner){
        resultView(strike,ball);
        if(strike==3){
            threeStrike();
            return;
        }
        playGame(scanner);
    }
    private static void countStrike(int i){
        if(userNumbers.get(i).equals(computerNumbers.get(i))){
            strike++;
        }else if(computerNumbers.contains(userNumbers.get(i))){
            ball++;
        }
    }
}
