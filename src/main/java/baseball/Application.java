package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerList = computerRandomNo();

        int playerPick = 1;
        while (playerPick != 2) {
            String computer = (computerList.get(0) + "" + computerList.get(1) + "" + computerList.get(2) + "");
            System.out.println(computer);
            int strikeCount = 0;
            int ballCount = 0;

            System.out.print("숫자를 입력해 주세요:");
            String player = playerGetNo();
            System.out.println();

            int[] count = countCheck(computer, player, ballCount, strikeCount);
            strikeCount = count[1];
            ballCount = count[0];

            if (strikeCount == 3) {
                System.out.println("축하드립니다 3스트라이크 입니다.");
                System.out.println("게임을 새로 시작하려면 1번 종료하려면 2번을 입력하세요.");
                playerPick = Integer.parseInt(Console.readLine());
                playerPick = playerPickNo(playerPick, computerList);
            } else if (strikeCount + ballCount > 0) {
                System.out.printf("%d볼 %d스트라이크 입니다 %n", ballCount, strikeCount);
            } else if (strikeCount + ballCount == 0) {
                System.out.println("낫싱");
            }
        }
    }

    public static int playerPickNo(int playerPick, List computerList) {
        if (playerPick == 1) {
            List list1 = computerRandomNo();
            for (int i = 0; i < computerList.size(); i++) {
                computerList.set(i, list1.get(i));
            }
            return 1;
        }
        if (playerPick == 2) {
            System.out.println("게임 종료");
            return 2;
        }
        return 0;
    }

    public static int[] countCheck(String computer, String player, int ballCount, int strikeCount) {
        for (int i = 0; i < 3; i++) {
            if (computer.contains(Character.toString(player.charAt(i)))) {
                ballCount++;
            }
            if (computer.charAt(i) == player.charAt(i)) {
                strikeCount++;
                ballCount--;
            }
        }
        return new int[]{ballCount, strikeCount};
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

    public static void isDuplication(String playerNo) {
        for (int i = 0; i < 10; i++) {
            String tmp = Integer.toString(i);
            String str1 = playerNo.replaceAll(tmp, "");
            if (!(str1.length() >= 2)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isnumbers(String playerNo) {
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(playerNo.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
}
