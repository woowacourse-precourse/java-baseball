package baseball.controller;

import baseball.computer.Computer;
import baseball.game.Game;
import baseball.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final InputView INPUTVIEW;
    private final OutputView OUTPUTVIEW;
    private final Game GAME;

    private static final int RESTART=1;
    private static final int END=2;
    private static final String ENTERING_WRONG_NUMBER_MESSAGE="숫자를 잘못 입력하셨습니다.프로그램을 종료합니다.";

    private static boolean gameState=false;
    private Player player;
    private Computer computer;

    public void working(){
        INPUTVIEW.noticeGameStart();
        do {
            startGame();
            chooseGameState();
        }while(gameState);
    }
    public GameController(){
        INPUTVIEW=new InputView();
        OUTPUTVIEW= new OutputView();
        GAME=new Game();
        player=new Player();
        computer=new Computer();

    }
    private void chooseGameState(){
        int userChoice;
        INPUTVIEW.requestMoreGame();
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
        computer=GAME.prepareComputer(computer);
        do {
            INPUTVIEW.requestEnteringNumbers();
            GAME.initializeStrikeAndBallCount();
            player=GAME.preparePlayer(player);
            GAME.judgeState(computer, player);
            OUTPUTVIEW.showMessage(GAME.showResult());
        }while (GAME.isNotFinished());
        OUTPUTVIEW.showSuccessMessage();
    }
}
