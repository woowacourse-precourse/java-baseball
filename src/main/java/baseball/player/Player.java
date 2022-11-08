package baseball.player;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
    private static final int NUMBER_OF_TRIAL=3;
    private static final int RANGE_START_NUMBER=1;
    private static final int RANGE_END_NUMBER=9;
    private List<Integer> digits = new ArrayList<>();
    public int getNumberPosition(int number){
        return digits.indexOf(number);
    }
    public List<Integer> getDigits(){
        return Collections.unmodifiableList(digits);
    }
    public <T, U> List<U> transform(List<T> list, Function<T, U> function){
        return list.stream().map(function).collect(Collectors.toList());
    }
    public void createNumbers(){

        String chosenNumbers = Console.readLine();
        InputException.isWrongUserInput(chosenNumbers);
        List<String> separatedUserInput = List.of(chosenNumbers.split(""));
        List<Integer> playerNumber = transform(separatedUserInput, Integer::parseInt);
        digits=playerNumber;
    }
}