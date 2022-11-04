package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class InputNumber {
    public List<Integer> input() {
        System.out.println("숫자를 입력해주세요 : ");

        return parseInput(Console.readLine());
    }

    private List<Integer> parseInput(String read) {
        List<Integer> result = new ArrayList<>();

        if (read.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (String num : read.split("")) {
            int parsedNum = parseInt(num);
            if (result.contains(parsedNum)) {
                throw new IllegalArgumentException();
            }
            result.add(parsedNum);
        }

        return result;
    }

    private int parseInt(String num) {
        try {
            return Integer.parseInt(num);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
