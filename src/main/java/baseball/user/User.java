package baseball.user;

import baseball.GameMessage;
import baseball.option.Option;
import baseball.option.validation.OptionValidation;
import baseball.user.validation.UserValidation;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {

    private List<Integer> gameNumber;

    public User() {
        gameNumber = new ArrayList<>();
    }

    public List<Integer> getGameNumber() {
        return gameNumber;
    }

    public void inputNumber() {
        gameNumber.clear();
        System.out.print(GameMessage.INPUT_NUMBER);
        String userInput = Console.readLine();

        UserValidation.validate(userInput);

        Stream<String> userStream = Stream.of(userInput.split(""));
        gameNumber = userStream.mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
    }

    public boolean inputOption() {
        System.out.println(GameMessage.INPUT_OPTION);
        String userInput = Console.readLine();

        OptionValidation.validate(userInput);
        int option = Integer.parseInt(userInput);

        if (option == Option.END.getOption()) {
            return Option.END.getStatus();
        }

        return Option.RESTART.getStatus();
    }
}
