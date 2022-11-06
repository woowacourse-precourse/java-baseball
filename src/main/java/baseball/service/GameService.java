package baseball.service;

import baseball.entity.*;
import baseball.utils.*;
import baseball.view.*;

import java.util.*;

public class GameService {
    Game game;
    User user;
    UserRequest userRequest = new UserRequest();

    public void setGame() {
        game = new Game();
        user = new User();
        game.setAnswer(RandomUtils.getRandomValue());
    }

    public void playGame() {
        int strike = 0;
        while (strike < 3) {
            game.initialGameValue();
            user.setUserInput(getInput());
            countLoop(game.getAnswer(), user.getUserInput());
            strike = game.getStrikeCounter();
        }
    }

    public void endGame() {
        SystemMessage.getCorrectMessage();
    }
    public String replayGame() {
        SystemMessage.chooseRestartExit();
        return userRequest.numberInput();
    }

    public List<Integer> getInput() {
        SystemMessage.getInputMessage();
        String input = userRequest.numberInput();
        Validation.validateSize(input);
        return Parser.stringToInt(input, new ArrayList<>());
    }

    public void countBallStrike(List<Integer> answer, List<Integer> userInput, int i) {
        if (Objects.equals(answer.get(i), userInput.get(i))) {
            game.incStrikeCounter();
        }
        else if (answer.contains(userInput.get(i))) {
            game.incBallCounter();
        }
    }

    public void countLoop(List<Integer> answer, List<Integer> userInput) {
        for (int i = 0; i < 3; i++) {
            countBallStrike(answer,userInput,i);
        }
        SystemMessage.getScoreMessage(game.getStrikeCounter(), game.getBallCounter());
    }

}
