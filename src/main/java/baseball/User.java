package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {
    private static final Pattern compile = Pattern.compile("(([^1-9])\\2{0,})");
    private BaseBallNumber number;
    private Observer observer;

    public void register(Observer observer) {
        this.observer = observer;
    }

    public List<Hint> compareToComputer() {
        return observer.compare(number.getNumber());
    }

    public void mappingUserInputToBaseBallNumber() {
        String consoleInput = getConsoleInput();
        List<Integer> integerList = convertUserInputToIntegerList(consoleInput);
        number = BaseBallNumber.of(integerList);
    }

    public String baseBallNumberString() {
        return String.join("", convertUserInputToIntegerList())+"\n";
    }

    private List<Integer> convertUserInputToIntegerList(String consoleInput) {
        return Arrays.stream(splitChar(consoleInput)).map(Integer::parseInt).collect(Collectors.toList());
    }

    private String[] splitChar(String consoleInput) {
        return consoleInput.split("");
    }

    private List<String> convertUserInputToIntegerList() {
        return number.getNumber().stream().map(String::valueOf).collect(Collectors.toList());
    }

    public String getConsoleInput() {
        String input = Console.readLine();
        if (compile.matcher(input).find()) throw new IllegalArgumentException();
        return input;
    }
}
