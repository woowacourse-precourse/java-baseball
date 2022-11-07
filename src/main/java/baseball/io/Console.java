package baseball.io;

import baseball.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Console {
    private final Validator validator;

    public Console(Validator validator) {
        this.validator = validator;
    }

    public List<Integer> getUserNumber() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();

        validation(input);

        return makeUserNumberList(input);
    }

    public void validation(String input) {
        if (!validator.validateDigit(input) || !validator.validateLength(input) || !validator.validateDuplicate(input)) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> makeUserNumberList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
