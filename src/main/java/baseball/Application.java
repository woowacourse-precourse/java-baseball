package baseball;

import java.util.List;

public class Application {

    public static int distinguishOut (List<Integer> inputNumberList, List<Integer> computerNumberList) {
        int outCounting = 0;

        for (int i = 0; i <3; i++) {
            if (inputNumberList.get(i) == computerNumberList.get(i)) {
                outCounting += 1;
            }
        }

        return outCounting;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
