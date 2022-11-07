package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumeralList = new ArrayList<>();

    public void setUserNumeralList(List<Integer> userNumeralList){
        this.userNumeralList = new ArrayList<>(userNumeralList);
    }


}
