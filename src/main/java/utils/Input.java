package utils;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private Input() {}

    public static List<Integer> playerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        Validator.validate(input);
        return Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static String restartFlag() {
        String restartFlag = Console.readLine();
        Validator.validateRestartFlag(restartFlag);
        return restartFlag;
    }
}
