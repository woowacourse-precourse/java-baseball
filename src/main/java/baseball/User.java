package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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

    public void printUserInput() {
        makeBaseBallNumber();
        printBaseBallNumber();
    }

    public void makeBaseBallNumber() {
        String consoleInput = getConsoleInput();
        List<Integer> integerList = toIntegerList(consoleInput);
        number = BaseBallNumber.of(integerList);
    }

    private List<Integer> toIntegerList(String consoleInput) {
        return Arrays.stream(splitChar(consoleInput)).map(Integer::parseInt).collect(Collectors.toList());
    }

    private String[] splitChar(String consoleInput) {
        return consoleInput.split("");
    }

    public void printBaseBallNumber() {
        System.out.println(String.join("", number.getNumber().stream().map(String::valueOf).collect(Collectors.toList())));
    }

    public String getConsoleInput() {
        String input = Console.readLine();
        if (compile.matcher(input).find()) throw new IllegalArgumentException();
        return input;
    }
}
