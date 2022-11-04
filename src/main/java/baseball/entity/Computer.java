package baseball.entity;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    List<Integer> numbers;

    public Computer(){
        numbers = new ArrayList<>();
    }

    public int createRandomNumber(){
        return 1;
    }

    public void putNumber(int number){

    }

    public boolean isAlreadyInNumbers(int number){
        return false;
    }

    public List<Integer> getNumbers(){
        return List.of(0);
    }


}
