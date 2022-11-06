package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;

public class Game {

    private final Computer computer;
    private final Player player;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    // 게임 전체 진행 순서
    public void run() {
        boolean gameStart = true;
        while (gameStart) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computerNum = computer.makeNumber();
            boolean strikeOut = false;
            while (!strikeOut) {
                List<Integer> playerNum = player.inputNum();
                HashMap<String, Integer> map = compareNum(computerNum, playerNum);
                int strike = map.get("strike");
                int ball = map.get("ball");
                String message = getMessage(strike, ball);
                System.out.println(message);
                strikeOut = setStrikeOut(strike);
            }
            gameStart = gameEnd();
        }
    }

    // 입력값과 컴퓨터 값 비교
    public HashMap<String, Integer> compareNum(List<Integer> numberList, List<Integer> computer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (numberList.get(i).equals(computer.get(i))) {
                strike += 1;
            } else if (computer.contains(numberList.get(i))) {
                ball += 1;
            }
        }
        HashMap<String, Integer> map = new HashMap<>();

        map.put("strike", strike);
        map.put("ball", ball);

        return map;
    }

    // 스트라이크와 볼 값에 따른 메세지
    public String getMessage(int strike, int ball) {

        String message = null;

        if (strike == 0 && ball == 0) {
            message = "낫싱";
        } else if (strike > 0 && ball == 0) {
            message = strike + "스트라이크";
        } else if (strike == 0 && ball > 0) {
            message = ball + "볼";
        } else if (strike > 0 && ball > 0) {
            message = ball + "볼 " + strike + "스트라이크";
        }
        return message;
    }

    // 3스트라이크 아웃시
    public boolean setStrikeOut(int strike) {
        if (strike == 3) {
            return true;
        }
        else {
            return false;
        }
    }

    // 게임 재시작 및 종료 입력 메서드
    public boolean gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        return setRestart(Integer.parseInt(restart));
    }

    // 게임 새로 시작 및 종료 결정 메서드
    public boolean setRestart(int num) {
        if (num == 1) {
            return true;
        } else if (num == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }
}
