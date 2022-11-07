package baseball;

import java.util.Arrays;
import java.util.List;

public class Service {

    public List<String> stringToList(String string) {
        return Arrays.asList(string.split(""));
    }

    private List<String> AddToListExcludeContainsString(List<String> list, String string){
        if(!list.contains(string)) {
            list.add(string);
        }
        return list;
    }
}
