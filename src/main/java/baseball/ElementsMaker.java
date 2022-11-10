package baseball;

import java.util.List;

public interface ElementsMaker<T> {
    List<T> makeElements(int listLength);
    List<T> convertToElements(String number);
}
