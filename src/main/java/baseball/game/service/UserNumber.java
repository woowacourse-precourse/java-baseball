package baseball.game.service;

import java.util.*;
import java.util.stream.Collectors;


public class UserNumber {

    public static List<Integer> generate(String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

    }

}
