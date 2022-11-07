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
