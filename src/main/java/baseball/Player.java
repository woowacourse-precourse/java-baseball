package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int INIT_LIST_SIZE = 3;
    private static final List<Integer> numbers = new ArrayList<>(INIT_LIST_SIZE);

    public void initNumbers() {
        numbers.clear();
        System.out.println("숫자를 입력해주세요 : ");
        String playerNumberStr = Console.readLine();
        // 올바르게 입력했는지 체크하기
        playerNumberStr.chars()
                .mapToObj(c -> c - '0')
                .forEach(numbers::add);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
