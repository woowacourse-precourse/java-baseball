package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameBranch {
    public int branch(int ballCount, int strikeCount) {
        if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String branch = Console.readLine();
            if (branch.equals("1")) {
                return -2;
            } else if (branch.equals("2")) {
                return -3;
            } else {
                throw new IllegalArgumentException();
            }
        } else if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
            return -1;
        } else if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
            return -1;
        } else if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return -1;
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            return -1;
        }
    }

}