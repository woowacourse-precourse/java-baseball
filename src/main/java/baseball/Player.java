package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    List<Integer> playerNumber;

    public Player(List<Integer> player) {
        this.playerNumber = player;
    }

    public void player3NumberInput() {

        System.out.print("숫자를 입력해주세요 : ");
        String playerStringNumber = Console.readLine();

        if (!(doubleCheck(playerStringNumber) && isNumeric(playerStringNumber) && playerStringNumber.length() == 3)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }

        for (int i = 0; i < playerStringNumber.length(); i++) {
            playerNumber.add(Integer.parseInt(String.valueOf(playerStringNumber.charAt(i))));
        }
    }

    public static boolean doubleCheck(String playerStringNumber) {

        List stringToArray = new ArrayList();

        for (int index = 0; index < playerStringNumber.length(); index++) {
            stringToArray.add(playerStringNumber.charAt(index));
        }

        Set stringToSet = new HashSet<>(stringToArray);

        if (playerStringNumber.length() != stringToSet.size()) {
            return false;
        }

        return true;
    }

    public static boolean isNumeric(String playerStringNumber) {

        return playerStringNumber.chars().allMatch(Character::isDigit);
    }


}


