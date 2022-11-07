package baseball.gameComponents;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameManager {
    private MainFunctions mainFunctions;
    private SubUtils subUtils;

    public GameManager(MainFunctions mainFunctions, SubUtils subUtils) {
        this.mainFunctions = mainFunctions;
        this.subUtils = subUtils;
    }

    public void gameStart() {
        boolean isRestart = true;
        while(isRestart) {
            gameOneRound();
            isRestart = mainFunctions.restartOrEndGame();
        }
    }

    private void gameOneRound() {
        final List<Integer> answer = mainFunctions.generateRandomNumber();
        subUtils.validateNumber(answer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isCorrectGuess = false;
        while(!isCorrectGuess) {
            List<Integer> guess = getGuessFromUser();
            int[] result = mainFunctions.examineGuess(guess, answer);
            isCorrectGuess = mainFunctions.examineResultAndPrint(result);
        }
    }

    private List<Integer> getGuessFromUser() {
        System.out.print("숫자를 입력해주세요: ");
        String guess = Console.readLine();
        subUtils.isPositiveNumber(guess);
        List<Integer> convertedGuess = subUtils.convertStringToList(guess);
        subUtils.validateNumber(convertedGuess);
        return convertedGuess;
    }
}
