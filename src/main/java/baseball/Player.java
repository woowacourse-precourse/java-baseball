package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    public static final int RANGE_START = 1;
    public static final int RANGE_END = 9;
    public static final int LENGTH_LIMIT = 3;
    private List<Integer> integerList = new ArrayList<>();

    public List<Integer> getIntegerListAsInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> integerList = convertIntegerStringToIntegerList(input);

        validateLength(integerList);
        validateNumbers(integerList);

        return integerList;
    }

    private List<Integer> convertIntegerStringToIntegerList(String str) {
        List<Integer> integers = new ArrayList<>();
        for (char chr : str.toCharArray()) {
            integers.add(chr - '0');
        }
        return integers;
    }

    private void validateLength(List<Integer> integerList) {
        if (integerList.size() != LENGTH_LIMIT) {
            throw new IllegalArgumentException("입력의 길이는 3이어야 합니다.");
        }
    }

    private void validateNumbers(List<Integer> integerList) {
        Set<Integer> set = new HashSet<>();

        for (int num : integerList) {
            if (num < RANGE_START || num > RANGE_END) {
                throw new IllegalArgumentException("각 자리의 범위는 1부터 9까지입니다.");
            }
            set.add(num);
        }

        if (set.size() != LENGTH_LIMIT) {
            throw new IllegalArgumentException("각 자리는 서로 달라야 합니다.");
        }
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }
}
