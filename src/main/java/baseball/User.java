package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    private static final Integer MAX_BASEBALLLIST_SIZE = 3;
    private BaseballList baseballList;

    public void setBaseballList() {
        String input = Console.readLine();
        // 유저 input validation - 3자리인지, 숫자인지, 중복된 수 없는지
        isValidInput(input);
        this.baseballList = new BaseballList(
                Arrays.stream(input.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }
    public void printUserBaseballList(){
        this.baseballList.printBaseballList();
    }

    public BaseballList getUserBaseballList() {
        return this.baseballList;
    }

    private void isValidInput(String input) {
        isThreeDigitNumber(input);
        isDistinctInput(input);
    }
    private void isDistinctInput(String input) {
        if(Arrays.stream(input.split("")).distinct().count() != MAX_BASEBALLLIST_SIZE)
            throw new IllegalArgumentException();
    }

    private void isThreeDigitNumber(String input) {
        String pattern = "[1-9]{3}";
        if(!Pattern.matches(pattern, input))
            throw new IllegalArgumentException();
    }
}
