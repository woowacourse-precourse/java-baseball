package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> numeralList = new ArrayList<>();

    public void setNumeralList(List<Integer> numeralList){
        this.numeralList = new ArrayList<>(numeralList);
    }

    public List<Integer> getNumeralList(){
        return numeralList;
    }
}
