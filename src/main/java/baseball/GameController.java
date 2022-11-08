package baseball;

import static baseball.Constants.NUMBER_LENGTH;
import static baseball.Constants.RESTART;
import static baseball.Constants.STOP;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.String.format;

import java.util.List;

public class GameController {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END = NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String PLAYER_INPUT = "숫자를 입력해주세요 : ";
    private static final String ASK_RESTART = format("현게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART, STOP);
    private static final String GAME_END_CONDITION = NUMBER_LENGTH + "스트라이크";
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Judgement judgement = new Judgement();
    private final InputValidation inputValidation = new InputValidation();

    public void playGame() {
        boolean play = true;

        while (play) {
            start();
            play = askRestart();
        }
    }

    public void start() {
        System.out.println(GAME_START);

        List<Integer> computerNumbers = computer.createComputerNumbers();

        String judgementResult = "";

        while (!judgementResult.equals(GAME_END_CONDITION)) {
            System.out.print(PLAYER_INPUT);

            String validatedInput = inputValidation.validatePlayerNumbersInput(readLine());

            List<Integer> playerNumbers = player.createPlayerNumbers(validatedInput);
            judgementResult = judgement.getJudgementResult(computerNumbers, playerNumbers);

            System.out.println(judgementResult);
        }

        System.out.println(GAME_END);
    }

    public boolean askRestart() {
        System.out.println(ASK_RESTART);
        String validatedInput = inputValidation.validateRestartInput(readLine());

        return validatedInput.equals(RESTART);
    }
}
