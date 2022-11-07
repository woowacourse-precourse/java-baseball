package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public String descriptionAndInput(String description) {
        System.out.print(description);

        return Console.readLine();
    }

    public int[] makeRandomizedArray() {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        int[] RandomArray = new int[3];
        for (int i = 0; i < 3; i++) {
            RandomArray[i] = Randoms.pickNumberInList(numbers);
            numbers.remove(Integer.valueOf(RandomArray[i]));
        }
        return RandomArray;
    }

    public void printStartJavaBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }
}
