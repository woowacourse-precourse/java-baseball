package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BaseballList {
    private final List<Baseball> baseballList;

    public BaseballList(List<Integer> baseballListInput) {
        this.baseballList = baseballListInput.stream()
                .map(baseball -> new Baseball(baseball))
                .collect(Collectors.toList());
    }

    public void printBaseballList() {
        for(Baseball baseball: this.baseballList) {
            baseball.printBaseball();
        }
    }
    public Boolean contains(Baseball comparingBaseball) {
        for(Baseball baseball: this.baseballList) {
            if(baseball.equals(comparingBaseball)) return true;
        }
        return false;
    }
    public List<Baseball> getBaseballList() {
        return this.baseballList;
    }
    public Baseball getBaseballByIndex(int index){
        return this.baseballList.get(index);
    }
    public Integer size(){
        return this.baseballList.size();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballList that = (BaseballList) o;
        return Objects.equals(baseballList, that.baseballList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballList);
    }
}
