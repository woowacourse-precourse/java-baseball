package baseball.controller;

import baseball.computer.Computer;
import baseball.game.Game;
import baseball.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Game game;

    private static final int RESTART=1;
    private static final int END=2;
    private static final String ENTERING_WRONG_NUMBER_MESSAGE="숫자를 잘못 입력하셨습니다.프로그램을 종료합니다.";

    private static boolean gameState=false;
    private Player player;
    private Computer computer;

    public GameController(){
        inputView=new InputView();
        outputView= new OutputView();
        game=new Game();
        player=new Player();
        computer=new Computer();

    }
    private void chooseGameState(){
        int userChoice;
        inputView.requestMoreGame();
        userChoice= Integer.parseInt(Console.readLine());
        if(userChoice==END){
            gameState=false;
        }
        else if(userChoice==RESTART){
            gameState=true;
        }else{
            throw new IllegalArgumentException(ENTERING_WRONG_NUMBER_MESSAGE);
        }

    }
    private void setGameState(){
        gameState=true;
    }
    public void startGame(){

        setGameState();
        computer=game.prepareComputer(computer);
        do {
            inputView.requestEnteringNumbers();
            game.initializeStrikeAndBallCount();
            player=game.preparePlayer(player);
            game.judgeState(computer, player);
            game.showResult();

        }while (game.isFinished());
        outputView.showSuccessMessage();
    }
}
