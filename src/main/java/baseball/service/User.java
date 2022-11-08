package baseball.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    public String userInput(){
        return Console.readLine();
    }
    public List<Integer> getUserNumber(String userNumber){
        String[] split = userNumber.split("");

        return Arrays.stream(split).map(c->Integer.valueOf(c)).collect(Collectors.toList());
    }
}
