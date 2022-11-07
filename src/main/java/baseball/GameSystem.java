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
    Computer computer = new Computer();
    List<Integer> numOfComputer;
    List<Integer> numOfPlayer;

    int numStrikes;
    int numBalls;

    boolean gameActivate = true;


    public GameSystem() {

    }

    public void GameStart() {
        System.out.println(STR_GAME_START);

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

    public void GamePlay() {

        //numOfComputer = computer.randomNumber;
        numOfComputer = Arrays.asList(7,2,4);
        numOfPlayer = player.ReturnPlayerNum(InputNumPlayer());

        GetGameReturnValue();

        System.out.println(numOfComputer+"  "+numOfPlayer);
        System.out.println(gameScore.ReturnScore(numStrikes, numBalls));

        if(numStrikes == 3) {
            System.out.println(STR_GAME_END);

            GameStartAgain();
        }
    }

    public void GameStartAgain() {
        System.out.println(STR_GAME_AGAIN);

        String inputReOrEnd = Console.readLine();
        InputGameRestartOrEnd(inputReOrEnd);
    }

    public void InputGameRestartOrEnd(String input) {

        if(input.equals("1")) {
            System.out.println(true);
            GamePlay();
        }
    }

}
