package baseball;

import java.util.IllformedLocaleException;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    public List<Integer> input() {
        List<Integer> result = new ArrayList<>();

        System.out.println("숫자를 입력해주세요 : ");
        String read = Console.readLine();

        for (String num : read.split("")) {
            result.add(Integer.parseInt(num));
        }

        return result;
    }
}
