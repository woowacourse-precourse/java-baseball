package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class PlayerNumber {
    static String playerNum;
    static CheckPlayerNum check = new CheckPlayerNum();

    public static String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static ArrayList<Integer> getPlayerNumber() {
        playerNum = getUserNumber();
        check.setPlayerNumber(playerNum);
        char[] chArray = playerNum.toCharArray();
        int length = chArray.length;
        ArrayList<Integer> playerIntNumList = new ArrayList<Integer>();

        for(int i = 0; i < length; i++) {
            char c = chArray[i];
            int n = Character.getNumericValue(c);

            playerIntNumList.add(n);
        }

        return playerIntNumList;
    }
}
