package baseball.game;

import static utils.Constant.*;

import baseball.entity.Computer;
import baseball.entity.Player;
import utils.View;
import utils.validation.Validation;
import utils.validation.Validator;

public class GameController {
    private static GameController instance;

    private  GameController(){}

    public static GameController getInstance() {
        if(instance == null){
            instance = new GameController();
        }

        return instance;
    }

    public Game getBaseBallGame(){
        return new BaseBallGame();
    }

    private class BaseBallGame implements Game{
        Computer computer;
        Player player;
        Validator numberInputValidator;

        public BaseBallGame() {
            computer = new Computer();
            player = new Player();

            numberInputValidator = Validator.build()
                    .addValidation(Validation.isLength(DIGIT_LENGTH))
                    .addValidation(Validation.isNumber())
                    .addValidation(Validation.isNotDuplicationNumber());
        }

        private void initialize(){
            computer.initialize();
        }

        private void start(){
            int predict, compareValue, ball, strike;

            do{
                View.printInput();
                String command = player.getCommand();

                if(numberInputValidator.validate(command)){
                    predict = Integer.parseInt(command);
                    compareValue = computer.compareAnswer(predict);

                    ball = compareValue / 10;
                    strike = compareValue % 10;

                    View.printHint(ball ,strike);
                }else{
                    throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
                }
            }while(strike == DIGIT_LENGTH);

            View.printGameEnd();
        }

        private void end(){
            View.printQuestionNewGame();
            String command = player.getCommand();
        }

        @Override
        public void play() {
            View.printIntro();

            initialize();
            start();
            end();
        }
    }
}
