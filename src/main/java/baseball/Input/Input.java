package baseball.Input;

import baseball.print.Print;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private List<Integer> numbers = new ArrayList<>();
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void input() throws IllegalArgumentException  {
        Print.inputMsg();

        try {
            String userInput = Console.readLine();
            numbers = Stream.of(userInput.split(""))
                    .map(Integer::parseInt).collect(Collectors.toList());
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        if (!valid(numbers))
            throw new IllegalArgumentException();
    }

    private Boolean valid(List<Integer> numbers){
        if (numbers.size() > 3 || numbers.isEmpty())
            return false;

        return checkDuplicate(numbers);
    }

    private Boolean checkDuplicate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() == numbers.size();
    }

    public Boolean replay(){
        Print.replay();
        int userInput  = 0;
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
