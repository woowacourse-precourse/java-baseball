package baseball.Input;

import baseball.print.Print;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static List<Integer> input() throws IllegalArgumentException  {
        Print.inputMsg();
        List<Integer> numbers;
        try {
            String userInput = Console.readLine();
            numbers = Stream.of(userInput.split(""))
                    .map(Integer::parseInt).collect(Collectors.toList());
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        if (!valid(numbers))
            throw new IllegalArgumentException();
        return numbers;
    }

    private static Boolean valid(List<Integer> numbers){
        if (numbers.size() != 3)
            return false;

        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() == numbers.size();
    }

    public static Boolean replay(){
        Print.replay();
        int userInput;
        try {
            userInput = Integer.parseInt(Console.readLine());
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        switch (userInput){
            case 1: return true;
            case 2: return false;
            default:
                throw new IllegalArgumentException();
        }
    }
}
