package baseball.domain;


import java.util.ArrayList;
import java.util.List;

public class User {

    private static List<Integer> selectNumber = new ArrayList<>();

    public List<Integer> getSelectNumber() {
        return selectNumber;
    }

    public void setSelectNumber(String inputNumber) {
        initList();
        for (int index = 0; index < inputNumber.length(); index++) {
            selectNumber.add(inputNumber.charAt(index) - '0');
        }
    }

    public void initList() {
        selectNumber = new ArrayList<>();
    }
}
