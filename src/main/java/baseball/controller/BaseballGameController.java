package baseball.controller;

import baseball.components.BaseballGameRule;
import baseball.components.Score;
import baseball.utils.GameUtils;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {

    public static final String PLAYER_NUMBER_INPUT_ERROR_MSG = "[ERROR] 0이아닌 서로 다른 3자리 수를 입력하세요.";
    public static final String NEXT_GAME_INPUT_ERROR_MSG = "[ERROR] 1 또는 2를 입력해주세요";

    private static final String PLAYER_NEXT_GAME_INPUT_REGEX = "^[12]$";
    private static final String PLAYER_NUMBER_INPUT_REGEX = "^([1-9])(?!\\1)([1-9])(?!(\\1|\\2))([1-9])$";


    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            BaseballGameRule baseballGameRule = new BaseballGameRule();
            playSingleGame(baseballGameRule);
        } while(canPlayNextGame());
    }

    public void playSingleGame(BaseballGameRule baseballGameRule){

        List<Integer> computerNumbers = GameUtils.generateThreeRandomNumbers();
        List<Integer> playerNumbers;
        Score playerScore;

        baseballGameRule.setComputerNumbers(computerNumbers);
        do{
            playerNumbers = readPlayerNumbers();
            playerScore = baseballGameRule.generatePlayerScore(playerNumbers);
            printBallStrikeCountScore(playerScore);

        }while(!baseballGameRule.isWin(playerScore));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    private List<Integer> readPlayerNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputString = Console.readLine();
        validatePlayerNumberInput(playerInputString);

        List<Integer> playerNumbers = new ArrayList<>();
        for(int index = 0; index < playerInputString.length(); index++){
            int number = Character.getNumericValue(playerInputString.charAt(index));
            playerNumbers.add(number);
        }

        return playerNumbers;
    }

    private void printBallStrikeCountScore(Score score){
        String scoreMessage = score.toString();
        System.out.println(scoreMessage);
    }

    private boolean canPlayNextGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String nextGamePlayerInput = Console.readLine();
        validatePlayerNextGameInput(nextGamePlayerInput);

        if(nextGamePlayerInput.equals("1")){
            return true;
        }
        return false;
    }

    private void validatePlayerNumberInput(String playerInput) throws IllegalArgumentException{
        if( !playerInput.matches(PLAYER_NUMBER_INPUT_REGEX) ){
            throw new IllegalArgumentException(PLAYER_NUMBER_INPUT_ERROR_MSG);
        }
    }

    private void validatePlayerNextGameInput(String playerInput) throws IllegalArgumentException{
        if( !playerInput.matches(PLAYER_NEXT_GAME_INPUT_REGEX) ){
            throw new IllegalArgumentException(NEXT_GAME_INPUT_ERROR_MSG);
        }
    }
}
