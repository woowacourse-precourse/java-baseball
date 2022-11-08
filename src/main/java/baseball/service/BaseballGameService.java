package baseball.service;

import baseball.domain.BaseBallGame;
import baseball.utils.ArrayParser;
import baseball.utils.Constants;
import baseball.utils.RandomNumber;
import baseball.utils.validators.UserInputValidator;
import baseball.view.BaseBallGameView;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameService {

    private BaseBallGame game;

    public void initGame(){
        int size = Constants.BASEBALL_GAME_NUMBER_LENGTH;
        int start = Constants.BASEBALL_GAME_NUMBER_RANGE_START;
        int end = Constants.BASEBALL_GAME_NUMBER_RANGE_END;

        this.game = new BaseBallGame(RandomNumber.getRandomNumber(size, start, end));
    }

    public void playGame(){
        while (game.getStrikeCount() < Constants.BASEBALL_GAME_MAX_STRIKE){
            game.setScoreZero();
            getUserGameInput();
            updateScore();
            Hint();
        }
        congratulations();
    }

    private void congratulations(){
        BaseBallGameView.printCongratulations();
    }

    private void Hint(){
        BaseBallGameView.printHint(game.getStrikeCount(), game.getBallCount());
    }

    private void updateScore(){
        for(int index=0; index<Constants.BASEBALL_GAME_NUMBER_LENGTH; index++){
            computeScore(index);
        }
    }

    private void computeScore(int answerIndex){
        for(int inputIndex=0; inputIndex<Constants.BASEBALL_GAME_NUMBER_LENGTH; inputIndex++){
            if(checkStrike(answerIndex, inputIndex)){
                game.increaseStrike();
                break;
            }
            if(checkBall(answerIndex, inputIndex)){
                game.increaseBall();
            }
        }
    }

    private boolean checkStrike(int answerIndex, int inputIndex){
        return (checkBall(answerIndex,inputIndex) && (answerIndex == inputIndex));
    }

    private boolean checkBall(int answerIndex, int inputIndex){
        return (game.getAnswer().get(answerIndex).equals(game.getUserInput().get(inputIndex)));
    }

    private void getUserGameInput(){
        BaseBallGameView.printRequestNumber();
        String input = Console.readLine();

        UserInputValidator.validateGameInput(input);

        game.setUserInput(ArrayParser.stringToIntegerList(input));
    }
}
