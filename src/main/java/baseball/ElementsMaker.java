package baseball;

import java.util.List;

public interface ElementListMaker<T> {
    List<T> makeElementList(int listLength);
    List<T> convertToElementList(String stringNumber);
}
