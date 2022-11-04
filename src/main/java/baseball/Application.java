package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            String computerNumber = setComputerNumber();
            String playerNumber = Console.readLine();

            if(checkPlayerNumber(playerNumber)){
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException exception) {

        }
    }

    public static boolean checkPlayerNumber(String playerNumber) {
        boolean[] includedNumber=new boolean[10];

        // 3개의 수인지 확인
        if (playerNumber.length() != 3) {
            return false;
        }

        Arrays.fill(includedNumber, false);

        for (int i = 0; i < playerNumber.length(); i++) {
            char num = playerNumber.charAt(i);
            // 1~9까지의 수인지 확인
            if (num < '1' || num > '9') {
                return false;
            }
            // 이미 포함된 수인지 확인
            if (includedNumber[num - '0']) {
                return false;
            }
            includedNumber[num - '0'] = true;
        }
        return true;
    }

    public static String setComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return toStringComputerNumber(computerNumber);
    }

    public static String toStringComputerNumber(List<Integer> target) {
        String result="";
        for (Integer num : target) {
            result += num.toString();
        }

        return result;
    }
}
