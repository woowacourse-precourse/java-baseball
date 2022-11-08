package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserGuess {
    private List<Integer> guess;

    public List<Integer> getGuess(){
        return this.guess;
    }

    public void convertStringToList(String inputString){
        this.guess = Arrays.stream(inputString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
