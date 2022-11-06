package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class BaseBallNumber {

    List<Integer> number;

    public BaseBallNumber(List<Integer> number) {
        this.number=number;
    }

    public boolean hasSameNumber() {
        long count = number.stream().distinct().count();
        if(count!=number.size()) return true;
        return false;
    }

    public List<Integer> getNumber() {
        return number.stream().collect(Collectors.toList());
    }
}
