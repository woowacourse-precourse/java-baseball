package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // scan user input
        System.out.println("서로다른 세 숫자를 입력하세요");
        String userRandNumber = Console.readLine();
        System.out.println(userRandNumber);

        // make random number
        List<Integer> correct = new ArrayList<>();

        while (correct.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!correct.contains(randNumber)) {
                correct.add(randNumber);
            }
        }

        // count STRIKE
        int countStrike = 0;
        for(int i=0; i<correct.size(); i++) {
            int eachUserNumber = userRandNumber.charAt(i) - '0';
            if (eachUserNumber == correct.get(i)) {
                countStrike ++;
            }
        }
    }
}