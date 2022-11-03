package baseball.component;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {

    private static final String PLAYER_NUMBER_INPUT_REGEX = "^([1-9])(?!\\1)([1-9])(?!(\\1|\\2))([1-9])$";


    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            BaseballGameRule baseballGameRule = new BaseballGameRule();
            playSingleGame(baseballGameRule);
        } while(canPlayNextGame());
    }

    public void playSingleGame(BaseballGameRule baseballGameRule){

        List<Integer> computerNumbers = generateThreeRandomNumbers();
        List<Integer> playerNumbers;
        List<Integer> playerScore;

        baseballGameRule.setComputerNumbers(computerNumbers);
        do{
            playerNumbers = readPlayerNumbers();
            playerScore = baseballGameRule.verifyPlayerScore(playerNumbers);
            printBallStrikeCountScore(playerScore);

        }while(playerScore.get(1) != 3);

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

    private void printBallStrikeCountScore(List<Integer> score){

        int ballCount = score.get(0);
        int strikeCount = score.get(1);

        if(ballCount==0 && strikeCount==0){
            System.out.println("낫싱");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if(ballCount != 0) {
            stringBuilder.append(ballCount);
            stringBuilder.append("볼 ");
        }
        if(strikeCount != 0) {
            stringBuilder.append(strikeCount);
            stringBuilder.append("스트라이크 ");
        }
        stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());

        System.out.println(stringBuilder.toString());
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

    private List<Integer> generateThreeRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private void validatePlayerNumberInput(String playerInput) throws IllegalArgumentException{
        if( !playerInput.matches(PLAYER_NUMBER_INPUT_REGEX) ){
            throw new IllegalArgumentException("[ERROR] 0이아닌 서로 다른 3자리 수를 입력하세요.");
        }
    }

    private void validatePlayerNextGameInput(String playerInput) throws IllegalArgumentException{
        if( !(playerInput.equals("1") || playerInput.equals("2"))){
            throw new IllegalArgumentException("[ERROR] 1 또는 2를 입력해주세요");
        }
    }
}
