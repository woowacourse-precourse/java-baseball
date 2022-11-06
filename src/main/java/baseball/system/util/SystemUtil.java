package baseball.system.util;

import baseball.console.Interactive;
import baseball.message.Message;
import baseball.validation.condition.Condition;
import baseball.validation.condition.systeminput.IsOperationCodeCond;
import baseball.validation.Validator;
import baseball.game.message.GameMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class SystemUtil implements Interactive {

    private static final SystemUtil instance = new SystemUtil();
    private static final Validator validator = Validator.getInstance();

    private SystemUtil() {
    }

    public static SystemUtil getInstance() {
        return instance;
    }

    public void print(Message message) {
        System.out.println(message.getMessage());
    }

    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public Integer getUserInput() {
        Integer input = Integer.parseInt(Console.readLine());

        List<Condition> conditions = List.of(
                IsOperationCodeCond.getInstance()
        );

        if (validator.isAnyConditionsFalse(input, conditions)) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
