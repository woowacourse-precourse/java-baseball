package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberBundle {
    private List<Integer> list = new ArrayList<Integer>();

    BaseballNumberBundle() {
    }
    BaseballNumberBundle(int number1, int number2, int number3) {
        addNumber(number1);
        addNumber(number2);
        addNumber(number3);
    }
    public List<Integer> getList() {
        return list;
    }
    public List<Integer> getReverseList() {
        List<Integer> reverseList = new ArrayList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reverseList.add(list.get(i));
        }
        return reverseList;
    }
    public void addNumber(Integer number) {
        list.add(number);
    }
}
