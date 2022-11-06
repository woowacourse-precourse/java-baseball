package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameSystem {
    private static final String STR_GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String STR_PLAYER_INPUT = "숫자를 입력해주세요 : ";

    GameScore gameScore = new GameScore();
    PlayerInput player = new PlayerInput();
    Computer computer = new Computer();
    List<Integer> numOfComputer;
    List<Integer> numOfPlayer;

    int numStrikes;
    int numBalls;


    public GameSystem() {

    }

    public void GameStart() {
        System.out.println(STR_GAME_START);

        GamePlay();
    }

    private void MakeNumComputer() {
        numOfComputer = computer.randomNumber;
    }

    public void InputNumPlayer() {

        System.out.print(STR_PLAYER_INPUT);

        String inputStr = Console.readLine();
        numOfPlayer = player.ReturnPlayerNum(inputStr);
    }

    public void GamePlay() {

        MakeNumComputer();
        InputNumPlayer();

        numStrikes = gameScore.CheckStrikes(numOfComputer, numOfPlayer);
        numBalls = gameScore.CheckBalls(numOfComputer, numOfPlayer);

        gameScore.ReturnScore(numStrikes, numBalls);
    }

}
