package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public final static int RESTART = 1;
    public final static int END = 2;
    public final static String numberBaseballStartMessage = "숫자 야구 게임을 시작합니다.";
    public final static String playerNumberInputMessage = "숫자를 입력해주세요 : ";
    public final static String gameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String playerOptionMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        System.out.println(numberBaseballStartMessage);

        do {
            startGame();
        } while (selectPlayerOption() != END);
    }

    public static int selectPlayerOption() {
        System.out.println(gameEndMessage);
        System.out.println(playerOptionMessage);

        String playerSelect = Console.readLine();
        int playerSelectNumber = Integer.parseInt(playerSelect);

        if(playerSelectNumber!=END && playerSelectNumber!=RESTART){
            throw new IllegalArgumentException();
        }
        return playerSelectNumber;
    }

    private static void startGame() {
        boolean[] isBall = new boolean[10];
        Arrays.fill(isBall, false);
        String computerNumber = setComputerNumber();
        setIsBall(isBall, computerNumber);

        while(true){
            System.out.print(playerNumberInputMessage);
            String playerNumber = Console.readLine();

            if(!checkPlayerNumber(playerNumber)){
                throw new IllegalArgumentException();
            }

            if (compareNumbers(isBall, computerNumber, playerNumber)) break;
        }
    }

    private static boolean compareNumbers(boolean[] isBall, String computerNumber, String playerNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < computerNumber.length(); i++) {
            char computerNum = computerNumber.charAt(i);
            char playerNum = playerNumber.charAt(i);

            if (computerNum == playerNum)  strikeCount++;
            else if (isBall[playerNum - '0'])  ballCount++;
        }
        System.out.println(makeCountMessage(ballCount, strikeCount));
        return strikeCount == 3;
    }

    public static String makeCountMessage(Integer ballCount, Integer strikeCount) {
        if (ballCount == 0 && strikeCount == 0) return "낫싱";
        if (ballCount == 0)  return strikeCount.toString() + "스트라이크";
        if (strikeCount == 0) return ballCount.toString() + "볼";
        return ballCount.toString() + "볼" + " " + strikeCount.toString() + "스트라이크";
    }

    public static void setIsBall(boolean[] isBall, String computerNumber) {
        for (int i = 0; i < computerNumber.length(); i++) {
            char num = computerNumber.charAt(i);
            isBall[num - '0'] = true;
        }
    }

    public static boolean checkPlayerNumber(String playerNumber) {
        // 숫자 중복확인 배열
        boolean[] includedNumber=new boolean[10];
        Arrays.fill(includedNumber, false);
        if (playerNumber.length() != 3) {
            return false;
        }

        for (int i = 0; i < playerNumber.length(); i++) {
            char num = playerNumber.charAt(i);
            if (num < '1' || num > '9') return false;
            if (includedNumber[num - '0']) return false;
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
