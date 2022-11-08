package baseball.service;

import java.util.List;

import baseball.vo.Master;

import baseball.vo.User;
import baseball.view.RequestMessage;
import baseball.view.SystemMessage;
import baseball.utils.NumberGenerator;
import baseball.utils.Validator;

import camp.nextstep.edu.missionutils.Console;

public class GameService {

    Master master;
    User user;
    Validator validator = new Validator();
    RequestMessage requestMessage = new RequestMessage();
    SystemMessage systemMessage = new SystemMessage();

    public void setGame(int digit, int minNumber, int maxNumber) {
        master = new Master(NumberGenerator.createRandomNumbers(digit, minNumber, maxNumber));
        master.initCount();
    }

    public void getUserInputs() {
        requestMessage.requestInputNumbers();
        String userInput = Console.readLine();
        user = new User(validator.validateUserInput(userInput));
    }

    public void countStrikeAndBall() {
        List<Integer> gameNumbers = master.getGameNumbers();
        List<Integer> userNumbers = user.getUserNumbers();

        for (int i = 0; i < gameNumbers.size(); i++) {
            Integer gameNumber = gameNumbers.get(i);
            Integer userNumber = userNumbers.get(i);

            if (gameNumber == userNumber) {
                master.strike();
            } else if (gameNumbers.contains(userNumber)) {
                master.ball();
            }
        }

        systemMessage.showBallCounts(master.getStrikeCount(), master.getBallCount());
    }

    public Boolean makeResult() {
        int resultStrike = master.getStrikeCount();

        if (resultStrike == 3) {
            systemMessage.showStrikeOutMessage();
            return true;
        }

        return false;
    }

}
