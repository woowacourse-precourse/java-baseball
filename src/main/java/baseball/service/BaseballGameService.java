package baseball.service;

import baseball.domain.BaseBallGame;
import baseball.utils.ArrayParser;
import baseball.utils.Constants;
import baseball.utils.InputValueValidator;

import baseball.utils.RandomNumber;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameService {

    private BaseBallGame game;

    public BaseballGameService(){

    }

    public void initGame(){
        int size = Constants.BASEBALL_GAME_NUMBER_LENGTH;
        int start = Constants.BASEBALL_GAME_NUMBER_RANGE_START;
        int end = Constants.BASEBALL_GAME_NUMBER_RANGE_END;

        this.game = new BaseBallGame(RandomNumber.getRandomNumber(size, start, end));
    }

    private void getUserGameInput() throws IllegalArgumentException{
        String input = Console.readLine();

        if(!validateGameInput(input)){
            throw new IllegalArgumentException();
        }

        game.setUserInput(ArrayParser.stringToIntegerList(input));
    }

    private boolean validateGameInput(String input){
        boolean isNumberOnly = InputValueValidator.isNumberOnly(input);
        boolean isNoDuplicated = InputValueValidator.isNoDuplicatedValue(input);
        boolean isLengthCorrect = InputValueValidator.isLengthCorrect(input, Constants.BASEBALL_GAME_NUMBER_LENGTH);

        return isNumberOnly && isNoDuplicated && isLengthCorrect;
    }
}
