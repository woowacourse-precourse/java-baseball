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

    public static boolean exceptionCheck(String str) {

        char[] chars = str.toCharArray();

        // input이 3자리 숫자가 아닌 경우
        if (chars.length!=3)
            return true;

        // input에 숫자가 아닌게 포함되어있을 경우
        for (int i=0; i<chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                return true;
            }
        }

        // input에 중복되는 숫자가 있을 경우
        if ((chars[0] == chars[1]) || (chars[1] == chars[2]) || (chars[0] == chars[2])) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumList() {
        return numList;
    }
}
