package baseball;

import java.util.Arrays;
import java.util.List;

public class Service {

    public List<String> stringToList(String string) {
        return Arrays.asList(string.split(""));
    }
}
