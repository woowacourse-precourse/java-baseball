package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> convertToList(Integer number) {
        List<Integer> result = new ArrayList<>();

        for (String s : number.toString().split("")) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
