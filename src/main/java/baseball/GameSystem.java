package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class GameSystem {
    private static final String STR_GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String STR_PLAYER_INPUT = "숫자를 입력해주세요 : ";
    private static final String STR_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STR_GAME_AGAIN ="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    GameScore gameScore = new GameScore();
    PlayerInput player = new PlayerInput();
    Computer computer;
    List<Integer> numOfComputer;
    List<Integer> numOfPlayer;

    int numStrikes;
    int numBalls;

    String gameValue ;


    public GameSystem() {

    }

    public void GameStart() {
        System.out.println(STR_GAME_START);
        initValue();
        GamePlay();
    }

    public String InputNumPlayer() {
        System.out.print(STR_PLAYER_INPUT);

        return Console.readLine();
    }

    private void GetGameReturnValue() {
        numStrikes = gameScore.CheckStrikes(numOfComputer, numOfPlayer);
        numBalls = gameScore.CheckBalls(numOfComputer, numOfPlayer);
    }

    private void PrintGameValue() {
        gameValue = gameScore.ReturnScore(numStrikes, numBalls);
        System.out.println(gameValue);
    }

    public boolean GamePlay() {

        //numOfComputer = computer.randomNumber;
        numOfPlayer = player.ReturnPlayerNum(InputNumPlayer());
        System.out.println(numOfComputer+ "    "+ numOfPlayer);

        GetGameReturnValue();
        PrintGameValue();

        if(numStrikes == 3) {
            System.out.println(STR_GAME_END);
            return false;
        }

        GamePlay();
        return false;
    }

    public boolean GameStartAgain() {
        boolean boolRestart;
        System.out.println(STR_GAME_AGAIN);

        String inputReOrEnd = Console.readLine();

        boolRestart = InputGameRestartOrEnd(inputReOrEnd);
        if(boolRestart) {
            return true;
        }

        return false;
    }

    public boolean InputGameRestartOrEnd(String input) {
        if(input.equals("1")) {
            return true;
        }

        return false;
    }

    public void initValue() {
        numStrikes = 0;
        numBalls = 0;

        computer = new Computer();
        numOfComputer = computer.randomNumber;
    }

}
