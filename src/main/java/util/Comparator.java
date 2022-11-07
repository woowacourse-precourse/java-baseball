package util;

import java.util.List;

public interface Comparator<T> {
    List<Integer> doCompare(T standard, T target);
}
