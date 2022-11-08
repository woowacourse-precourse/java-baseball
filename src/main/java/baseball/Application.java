package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application extends ApplicationVariables {

    public static void main(String[] args) {
        while(true){
            if( playGame(generateRandomNumber()).equals(STOP_GAME) ) break;
        }
    }

    public static List<Integer> generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(INT_BOTTOM_RANGE, INT_UP_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static String playGame(List<Integer> computer){
        System.out.println(GAME_START_TEXT);

        BaseBallGameValidation validation = new BaseBallGameValidation();

        while(true){
            System.out.print(INPUT_TEXT);
            String input = Console.readLine();
            String[] inputSplits = input.split("");

            validation.validateInputCase(inputSplits);
            validation.validateDuplicateNumber(inputSplits);

            int[] inputNumbers = Arrays.stream(inputSplits).mapToInt(Integer::valueOf).toArray();

            GameStatus gameStatus = new GameStatus();
            gameStatus.saveNumberStatus(inputNumbers, computer);
            String response = responseNumberStatus(gameStatus);
            System.out.println(response);

            if(gameStatus.strike == INT_SIZE) {
                System.out.println(GAME_END_TEXT);
                break;
            }
        }

        return Console.readLine();
    }

    private static String responseNumberStatus(GameStatus gameStatus){
        StringBuilder sb = new StringBuilder();

        if(gameStatus.nothing) return NOTHING_TEXT;
        else {
            if(gameStatus.ball > 0) sb.append(gameStatus.ball).append(BALL_TEXT);
            if(gameStatus.strike > 0) sb.append(gameStatus.strike).append(STRIKE_TEXT);
        }

        return sb.toString();
    }

}
