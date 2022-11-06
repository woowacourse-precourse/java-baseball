package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Rival {
    private final int LENGTH_OF_NUMBER = 3;
    private List<Integer> number;

    public void createNumber(){
        number = new ArrayList<>();
        while(number.size() < LENGTH_OF_NUMBER){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!number.contains(randomNumber)){
                number.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumber(){
        return number;
    }

    public boolean contains(int n){
        for(int i = 0; i < LENGTH_OF_NUMBER; i++){
            if(number.get(i) == n){
                return true;
            }
        }
        return false;
    }

    public int getIndexOf(int n){
        int index = -1;
        for(int i = 0; i < LENGTH_OF_NUMBER; i++){
            if(number.get(i) == n){
                index = i;
            }
        }
        return index;
    }
}
