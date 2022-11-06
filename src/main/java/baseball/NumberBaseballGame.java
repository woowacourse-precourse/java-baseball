package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    private static List<Integer> computerNumber;
    private static List<Integer> userNumber;

    public NumberBaseballGame(){
        computerNumber = new ArrayList<>();
    }

    public static void getRandomThreeDigitNumber() {
        for (int i = 0; i < 3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
    }

    public static List<Integer> getUserNumberList(String userNumber){
        String[] userNumberArray = userNumber.split("");
        List<Integer> userNumberList = new ArrayList<>();
        for (String number : userNumberArray) {
            userNumberList.add(Integer.parseInt(number));
        }
        return userNumberList;
    }

}
