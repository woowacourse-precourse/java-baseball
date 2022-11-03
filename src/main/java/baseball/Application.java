package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int randomNumber = makeRandomNumber();
        System.out.println(randomNumber);
    }


    public static int makeRandomNumber() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = (int) ((Math.random() * 9) + 1);
            numList.add(num);
        }
        return removeRepetitionNumber(numList);
    }

    public static int removeRepetitionNumber(List<Integer> numList) {
        String tmp = "";

        for (int i = 0; i < numList.size()-1; i++) {
            if (numList.get(i) != numList.get(i+1)) tmp += numList.get(i);
        }

        tmp = tmp.substring(0,3);
        return Integer.parseInt(tmp);
    }
}
