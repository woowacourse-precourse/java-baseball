package util;

import java.util.List;

public interface Comparator {
    List<Integer> doIntCompare(List<Integer> standard, List<Integer> target);
}
