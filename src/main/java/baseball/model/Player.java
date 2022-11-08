package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> numbers;

    public Player(){
        numbers = new ArrayList<>();
    }

    public void setNumbers(String input){
        for(String numberEach : input.split("")){
            numbers.add(Integer.parseInt(numberEach));
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
