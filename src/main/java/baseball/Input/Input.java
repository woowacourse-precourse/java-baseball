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

    public void input(){
        Print.inputMsg();
        String userInput = Console.readLine();
        numbers = Stream.of(userInput.split(""))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

}
