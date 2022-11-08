package baseball;

public class BaseballGame {
    public void run() {
        final String RUN_TEXT = "숫자 야구 게임을 시작합니다.";
        final int NUMBER_INPUT_SIZE = 3;
        final int REPLAY_INPUT_SIZE = 1;
        final String REPLAY = "1";
        final String GAME_OVER = "2";

        System.out.println(RUN_TEXT);
        NumCreator numCreator = new NumCreator();
        String createdNum = numCreator.create(NUMBER_INPUT_SIZE);
        boolean isCorrect = false;
        do {
            InputNum inputNum = new InputNum();
            String inputStr = inputNum.input(NUMBER_INPUT_SIZE);

            ResultPrinter resultPrinter = new ResultPrinter();
            resultPrinter.printResult(inputStr, createdNum);
            isCorrect = resultPrinter.isCorrect();
        } while (!isCorrect);
        InputReplay inputReplay = new InputReplay();
        String replayStr = inputReplay.input(REPLAY_INPUT_SIZE);

        if (replayStr.equals(REPLAY)) {
            // 재시작
            run();
        }
        if (replayStr.equals(GAME_OVER)) {
            // 종료
        }
    }
}
