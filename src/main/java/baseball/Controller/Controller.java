package baseball.Controller;

import static baseball.Constants.Constants.ANSWER;
import static baseball.Constants.Constants.GAME_END;
import static baseball.Constants.Constants.GAME_RESTART;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.Constants.Constants;
import baseball.Domain.ThrowBall;
import baseball.Service.GameService;
import baseball.Service.Rule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Rule rule = new Rule();
    GameService gameService = new GameService();

    /**
     * 게임시작하는 Method
     * @return 스트라이크 볼 현황
     */
    public String gameStart() {
        List<Integer> computerAnswer = new ArrayList<>();
        computerAnswer.addAll(gameService.ComputerAnswer());
        String answer;
        System.out.println(Constants.GAME_START);

        do {
            String input = readLine();
            if (input.length() >= 4) {
                throw new IllegalArgumentException();
            }
            ThrowBall throwBall = new ThrowBall(input);
            answer = rule.ruleCheck(computerAnswer, throwBall);
            System.out.println(answer);
        } while (!answer.equals("3스트라이크"));
        System.out.println(ANSWER + " " + GAME_END);
        return answer;
    }

    /**
     * 재시작하는 Method
     * @return 재시작상태 true false
     * @throws IllegalArgumentException 예상치못한 입력값이 들어오는경우
     */
    public boolean gameRestart() throws IllegalArgumentException {
        System.out.println(GAME_RESTART);
        String input = readLine();
        if (input.equals("1")) {
            gameStart();
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
