package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public static final String INPUT_NUM_MENT = "숫자를 입력해주세요 : ";
    private List<Integer> numList;

    public User() {
    }

    public void createNumList() throws IllegalArgumentException {
        System.out.print(INPUT_NUM_MENT);
        String str = Console.readLine();
        if (exceptionCheck(str)) {
            throw new IllegalArgumentException();
        }

        List<String> strings = Arrays.asList(str.split(""));
        List<Integer> inputNumList = strings.stream().map(Integer::parseInt).collect(Collectors.toList());

        this.numList = inputNumList;
    }

    private boolean exceptionCheck(String str) {
    }

    public List<Integer> getNumList() {
        return numList;
    }
}
