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

    public void setGame(int digit, int minNumber, int maxNumber) {
        master = new Master(NumberGenerator.createRandomNumbers(digit, minNumber, maxNumber));
    }

    public void getUserInputs() {
        RequestMessage.requestInputNumbers();
        String userInput = Console.readLine();
        user = new User(Validator.validateUserInput(userInput));
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

        SystemMessage.showBallCounts(master.getBallCount(), master.getStrikeCount());
    }

    public Boolean makeResult() {
        int resultStrike = master.getStrikeCount();

        if (resultStrike == 3) {
            SystemMessage.showStrikeOutMessage();
            return true;
        }

        master.initCount();
        return false;
    }

    public Boolean restartOrExit() {
        RequestMessage.requestRestartOrExit();
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return true;
        }

        return false;
    }

}
