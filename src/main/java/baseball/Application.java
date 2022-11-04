package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            boolean[] isBall = new boolean[10];
            Arrays.fill(isBall, false);

            String computerNumber = setComputerNumber();
            setIsBall(isBall, computerNumber);

            String playerNumber = Console.readLine();

            if(checkPlayerNumber(playerNumber)){
                throw new IllegalArgumentException();
            }

            int ballCount = 0;
            int strikeCount = 0;
            for (int i = 0; i < computerNumber.length(); i++) {
                char computerNum = computerNumber.charAt(i);
                char playerNum = playerNumber.charAt(i);

                if (isBall[computerNum - '0']) {
                    ballCount++;
                }
                if (computerNum == playerNum) {
                    strikeCount++;
                }
            }

            System.out.println(makeMessage(ballCount, strikeCount));
            
        } catch (IllegalArgumentException exception) {

        }
    }

    public static String makeMessage(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        } else {
            String ballMessage = makeBallMessage(ballCount);
            String strikeMessage = makeStrikeMessage(strikeCount);

            if (ballCount == 0)  return strikeMessage;
            else if (strikeCount == 0) return ballMessage;
            return ballMessage + " " + strikeMessage;
        }
    }

    public static String makeBallMessage(Integer ballCount) {
        if (ballCount == 0) {
            return "";
        } else {
            return ballCount.toString() + "볼 ";
        }
    }

    public static String makeStrikeMessage(Integer strikeCount) {
        if (strikeCount == 0) return "";
        else return strikeCount.toString() + "스트라이크";
    }

    public static void setIsBall(boolean[] isBall, String computerNumber) {
        for (int i = 0; i < computerNumber.length(); i++) {
            char num = computerNumber.charAt(i);
            isBall[num - '0'] = true;
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
