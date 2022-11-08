package baseball.service;

import baseball.vo.Master;
import baseball.vo.User;
import baseball.view.RequestMessage;
import baseball.utils.NumberGenerator;
import baseball.utils.Validator;

import camp.nextstep.edu.missionutils.Console;

public class GameService {

    Master master;
    User user;
    Validator validator = new Validator();
    RequestMessage requestMessage = new RequestMessage();

    public void setGame(int digit, int minNumber, int maxNumber) {
        master = new Master(NumberGenerator.createRandomNumbers(digit, minNumber, maxNumber));
        master.initCount();
    }

    public void getUserNumbers() {
        requestMessage.requestInputNumbers();
        String userInput = Console.readLine();
        user = new User(validator.validateUserInput(userInput));
    }

}
