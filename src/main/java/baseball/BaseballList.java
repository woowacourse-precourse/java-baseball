package baseball;

import java.util.List;
import java.util.Objects;

public class BaseballList {
    private final List<Baseball> baseballList;

    public BaseballList(List<Baseball> baseballList) {
        this.baseballList = baseballList;
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
