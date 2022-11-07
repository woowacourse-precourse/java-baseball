package baseball.domain;

import baseball.constants.ComparingResults;
import baseball.constants.GuideSentences;
import baseball.exception.GameExceptionHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class GameOperator {

    private QuestionNumberSetter questionNumberSetter;
    private Map<ComparingResults, Integer> resultMap = new TreeMap<>();
    private List<Integer> inputNumberList = new ArrayList<>();

    public GameOperator() {
        questionNumberSetter = new QuestionNumberSetter();
    }

    public void numberBaseballGame() {
        boolean start = true;

        System.out.println(GuideSentences.START_GUIDE.getSentence());

        while (start) {
            questionNumberSetter.pickThreeRandomNumbers();

            oneGame();

            start = askAboutRestart();
        }
    }

    /* === 게임 1회 진행 === */
    private void oneGame() {
        String resultString = "";

        while (!resultString.equals("3스트라이크")) {
            getNumbersFromUser();

            compareWithRandomNumbers();

            resultString = makeResultSentence();

            System.out.println(resultString);
        }
    }

    /* 게임 1회 : 사용자 입력 관련 메소드 */
    private void getNumbersFromUser() {
        guideToInputNumbers();
        getInputNumbers();
    }

    private void guideToInputNumbers() {
        System.out.print(GuideSentences.INPUT_GUIDE.getSentence());
    }

    private void getInputNumbers() {
        String input = Console.readLine();
        GameExceptionHandler.handleInGameException(input);

        Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .forEach(inputNumberList::add);
    }

    /* 게임 1회 : 숫자 비교 메소드 */
    private void compareWithRandomNumbers() {
        resultMap = questionNumberSetter.compareWithRandomNumbers(inputNumberList);
        inputNumberList.clear();
    }

    /* 게임 1회 : 결과 출력 메소드 */
    private String makeResultSentence() {
        String resultString = convertResultMapToString();

        return resultString;
    }

    private String convertResultMapToString() {
        List<String> resultList = divideEachResult();

        String resultString = String.join(" ", resultList);

        return resultString;
    }

    private List<String> divideEachResult() {
        List<String> resultList = new ArrayList<>();

        for (Map.Entry<ComparingResults, Integer> oneResult : resultMap.entrySet()) {
            if (oneResult.getKey() == ComparingResults.NOTHING) {
                resultList.add(oneResult.getKey().getResult());
                break;
            }

            String resultSentence =
                    oneResult.getValue().toString() + oneResult.getKey().getResult();
            resultList.add(resultSentence);
        }
        resultMap.clear();

        return resultList;
    }

    /* === 재시작 여부 확인 관련 메소드 === */
    private boolean askAboutRestart() {
        guideGameOverAndRestart();

        boolean restart = getRestartInput();

        return restart;
    }

    private void guideGameOverAndRestart() {
        System.out.println(GuideSentences.END_GUIDE.getSentence());
        System.out.println(GuideSentences.RESTART_GUIDE.getSentence());
    }

    private boolean getRestartInput() {
        boolean restart = true;

        String restartInput = Console.readLine();
        GameExceptionHandler.handleAfterGameOverException(restartInput);

        if (restartInput.equals("2")) {
            restart = false;
        }

        return restart;
    }
}
