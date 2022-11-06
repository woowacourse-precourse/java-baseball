package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<Integer> enterNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();

        return convertToIntegerList(playerInput);
    }

    public static List<Integer> convertToIntegerList(String playerInput) {
        return Arrays.stream(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }


}
