package baseball.facade;

import baseball.processor.*;

import java.util.List;


public class GameFacade {
    NumberMatchProcessor numberMatchProcessor = new NumberMatchProcessorImpl();
    GameInitProcessor gameInitProcessor = new GameInitProcessorImpl();
    NumberValidate numberValidate = new NumberValidate();

    public void gameStart(final Integer numberSize, List<Integer> computer) {
        List<Integer> userInput = gameInitProcessor.userInput();

        numberValidate.validation(userInput, numberSize);

        List<Integer> resultList = numberMatchProcessor.compare(computer, userInput);

        System.out.println(numberMatchProcessor.printHint(resultList));

        isMatchNumber(numberSize, computer, resultList);
    }

    public List<Integer> makeGameNumber(Integer numberSize){
        return gameInitProcessor.randomNumber(numberSize);
    }

    private void isMatchNumber(Integer numberSize, List<Integer> computer, List<Integer> resultList) {
        if (resultList.get(0).equals(numberSize)) callEndgame();
        if (!resultList.get(0).equals(numberSize)) gameStart(numberSize, computer);
    }

    private void callEndgame() {
        System.out.println(3 + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
