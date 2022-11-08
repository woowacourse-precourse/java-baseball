package baseball.controller;

import baseball.domain.Baseball;
import baseball.service.BaseballService;
import baseball.util.io.BaseballInput;
import baseball.util.io.BaseballOutput;
import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class BaseballController {

    private final BaseballService baseballService;
    private final Validator<List<Integer>> validator;
    private static final int INPUT_SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;
    public BaseballController(BaseballService baseballService, Validator<List<Integer>> validator) {
        this.baseballService = baseballService;
        this.validator = validator;
    }

    public void play() {
        BaseballOutput.printInit();
        do {
            playOneCycle();
        } while (BaseballInput.gameRestart());
    }

    public void playOneCycle() {
        List<Integer> goal = createGoal();
        while (true) {
            List<Integer> inputNumbers = BaseballInput.gamePlay(validator);
            Baseball result = baseballService.judge(inputNumbers, goal);
            BaseballOutput.printResult(result);

            if (result.getStrike() == INPUT_SIZE) {
                BaseballOutput.printSuccess();
                break;
            }
        }

    }

    private List<Integer> createGoal() {
        List<Integer> goal = new ArrayList<>();
        while (goal.size() < INPUT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!goal.contains(randomNumber)) {
                goal.add(randomNumber);
            }
        }
        return goal;
    }

}
