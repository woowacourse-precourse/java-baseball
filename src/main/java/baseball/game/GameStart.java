package baseball.game;

import baseball.Number.InputNumber;
import baseball.Number.MakeInputNumberList;
import baseball.Number.MakeRandomNumberList;

import java.util.List;

public class GameStart {
    private String gameResult;

    private MakeRandomNumberList makeRandomNumberList = new MakeRandomNumberList();
    private InputNumber inputNumber = new InputNumber();
    private MakeInputNumberList makeInputNumberList = new MakeInputNumberList();
    private FindResultList findResultList = new FindResultList();
    private MakeResultListToWords makeResultListToWords = new MakeResultListToWords();
    private GameRestart gameRestart = new GameRestart();

    public GameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        makeRandomNumberList.makeRandomNumberList();

        do {
            inputNumber.userInputNumber();
            makeInputNumberList.makeInputNumberList(inputNumber.getInputnumber());

            List<Integer> inputNumberList = makeInputNumberList.getInputNumberList();
            List<Integer> randomNumberList = makeRandomNumberList.getRandomNumberList();

            List<String> resultList =findResultList.findMatchingOrNothing(inputNumberList, randomNumberList);

            this.gameResult = makeResultListToWords.makeResultToWords(resultList);
            System.out.println(gameResult);

        } while (!gameResult.equals("3스트라이크"));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        gameRestart.gameRestart();
    }
}
