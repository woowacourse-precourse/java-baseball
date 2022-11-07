package iosystem;

import baseball.GameMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputSystem {

    private InputSystem(){
    }

    public static List<Integer> inputTryNumber(){
        System.out.print(GameMessage.TRY_CORRECT);
        String input = Console.readLine();
        // TODO 검증
        List<String> characterList = Arrays.asList(input.split(""));
        return characterList.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

}
