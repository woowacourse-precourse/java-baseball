package baseball.interaction;

import baseball.message.Message;
import baseball.enums.system.UserAction;
import baseball.validation.Condition;
import baseball.validation.system.IsOperationCodeCond;
import baseball.validation.Validator;
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
    public UserAction getUserInput() {
        String input = Console.readLine();

        List<Condition> conditions = List.of(
                IsOperationCodeCond.getInstance()
        );

        Integer notPassConditionIndex = validator.getNotPassConditionIndex(input, conditions);

        if (notPassConditionIndex != PASS_ALL_CONDITIONS_INDEX) {
            Condition notPassCondition = conditions.get(notPassConditionIndex);
            throw new IllegalArgumentException(notPassCondition.getErrorMessage());
        }

        return UserAction.getEnumByValue(input);
    }
}
