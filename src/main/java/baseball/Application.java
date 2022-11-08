package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!exit) {
            boolean collect = false;
            baseballGame(collect);
            exit = UserInterface.exitOrRestart();
        }
    }

    private static void baseballGame(boolean collect) {
        List<Integer> computer = Baseball.getComputerNumber();
        while (!collect) {
            List<Integer> user = UserInterface.getUsersAnswer();
            int strikeCount = Baseball.getStrikeCount(computer, user);
            int ballCount = Baseball.getBallCount(computer, user) - strikeCount;
            collect = UserInterface.resultOutput(strikeCount, ballCount);
        }
    }
}
