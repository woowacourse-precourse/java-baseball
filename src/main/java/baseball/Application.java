package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        }


    public static List computerRandomNo() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static String playerGetNo() throws IllegalArgumentException {
        String playerNo = "";
        playerNo = Console.readLine();
        if (playerNo.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (playerNo.length() == 3) {
            isnumbers(playerNo);
            isDuplication(playerNo);
        }
        return playerNo;
    }
    public static void isDuplication(String playerNo){
        for (int i = 0; i < 10; i++) {
            String tmp = Integer.toString(i);
            String str1 = playerNo.replaceAll(tmp, "");
            if (!(str1.length() >= 2)) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void isnumbers(String playerNo){
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(playerNo.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
}
