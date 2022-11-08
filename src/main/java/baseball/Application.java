package baseball;

import baseball.starter.BaseballGameStarter;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BaseballGameStarter baseballGameStarter = new BaseballGameStarter();
        List<List<String>> initializedGame = baseballGameStarter.initializeNewGame();
        List<String> userInputValue = initializedGame.get(0);
        List<String> computerGeneratedValue = initializedGame.get(1);
        baseballGameStarter.operateRefereeJudgement(userInputValue, computerGeneratedValue);
    }
}