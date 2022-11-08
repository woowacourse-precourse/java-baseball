package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Game {
    private static final boolean ON = true;
    private static final boolean OFF = false;
    private boolean gamePower;

    public void run() {
        this.gamePower = ON;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(gamePower) {
            Computer computer = new Computer();
            computer.setComputerBaseballList();
            computer.printComputerBaseballList();
            this.runStage(computer);
            getGamePower();
        }
    }
    public void runStage(Computer computer) {
        User user = new User();
        boolean gameStatus = ON;
        while(gameStatus) {
            System.out.println("숫자를 입력해주세요 : ");
            user.setBaseballList();
            BaseballList userBaseballList = user.getUserBaseballList();
            int ballCount = computer.getBalls(userBaseballList);
            int strikeCount = computer.getStrikes(userBaseballList);

            if(ballCount == 0 && strikeCount == 0) System.out.println("낫싱");
            if(ballCount > 0 && strikeCount == 0) System.out.println(ballCount + "볼");
            if(ballCount > 0 && strikeCount > 0) System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            if(ballCount == 0 && strikeCount > 0) System.out.println(strikeCount + "스트라이크");

            if(computer.getStrikes(userBaseballList) == 3) {
                gameStatus = OFF;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }
    public void getGamePower() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        isOneOrTwo(input);
        if(input.compareTo("1") == 0) {
            this.gamePower = ON;
        }
        if(input.compareTo("2") == 0) {
            this.gamePower = OFF;
        }
    }

    private void isOneOrTwo(String input) {
        String pattern = "^[1-2]{1}";
        if(!Pattern.matches(pattern, input))
            throw new IllegalArgumentException();
    }
}
