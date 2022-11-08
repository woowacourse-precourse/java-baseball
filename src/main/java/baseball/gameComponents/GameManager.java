package baseball.gameComponents;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameManager {
    private GameComponent gameComponent;
    private Validator validator;
    public GameManager(GameComponent gameComponent, Validator validator) {
        this.gameComponent = gameComponent;
        this.validator = validator;
    }
    public void gameStart() {
        boolean isRestart = true;
        while(isRestart) {
            gameOneRound();
            isRestart = gameComponent.restartOrEndGame();
        }
    }
    private void gameOneRound() {
        final List<Integer> answer = gameComponent.generateRandomNumber();
        validator.validateNumber(answer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isCorrectGuess = false;
        while(!isCorrectGuess) {
            List<Integer> guess = getGuessFromUser();
            int[] result = gameComponent.examineGuess(guess, answer);
            isCorrectGuess = gameComponent.examineResultAndPrint(result);
        }
    }
    private List<Integer> getGuessFromUser() {
        System.out.print("숫자를 입력해주세요: ");
        String guess = Console.readLine();
        validator.isPositiveNumber(guess);
        List<Integer> convertedGuess = gameComponent.convertStringToList(guess);
        validator.validateNumber(convertedGuess);
        return convertedGuess;
    }
}
