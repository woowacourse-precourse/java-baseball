package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> numbers = new ArrayList<>();

    void saveUserInput(String input){
        numbers.clear();
        for(int i=0; i<input.length(); i++){
            this.numbers.add(Integer.parseInt(input.substring(i, i+1)));
        }
    }
}
