package baseball.domain;


import java.util.ArrayList;
import java.util.List;

public class User {

    private static List<Integer> selectNumber = new ArrayList<>();

    public List<Integer> getSelectNumber() {
        return selectNumber;
    }

    public void setSelectNumber(List<Integer> selectNumber) {
        this.selectNumber = selectNumber;
    }
}
