package baseball.user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.RuleConst.*;

public class User {
    private List<Integer> numbers;
    private InputValidator inputValidator;

    public User() {
        this.numbers = new ArrayList<>(List.of(0, 0, 0));
        this.inputValidator = new InputValidator();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void setNumbers(String number) {
        numbers = Arrays.stream(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public void generateNumber() {
        this.numbers = new ArrayList<>(List.of(0, 0, 0));

        System.out.println("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        inputValidator.validate(number);
        setNumbers(number);
    }
}
