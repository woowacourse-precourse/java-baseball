package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Integer> makeUserNumberToList(String userNumberString){
        int userNumber = Integer.parseInt(userNumberString);
        List<Integer> listNumber = new ArrayList<>();
        while(userNumber < 0){
            listNumber.add(userNumber%10);
            userNumber /= 10;
        }
        return listNumber;
    }

}
