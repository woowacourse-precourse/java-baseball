package baseball;

import java.util.List;

public class BaseballGame {

    private final String startMessage = "숫자 야구 게임을 시작합니다.";
    private final String sucessMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private int ballCondition;
    private int strikeCondition;
    private boolean threeStrike;

    private Computer computer;
    private Player player;

    public BaseballGame() {
        ballCondition = 0;
        strikeCondition = 0;
        threeStrike = false;
    }

    public int getBallCondition() {
        return ballCondition;
    }

    public int getStrikeCondition() {
        return strikeCondition;
    }

    public boolean isThreeStrike() {
        return threeStrike;
    }

    //게임 play
    public void game() {
        System.out.println(startMessage);
        while (true) {
            computer = new Computer();
            List<Integer> computerNumbers = computer.getRandomNumbers();
            player = new Player();
            play(computerNumbers);
            player.replay();
            String replay = player.getReplay();
            if (replay.equals("2")) {
                break;
            }
        }
    }

    private void play(List<Integer> computerNumbers) {
        threeStrike = false;
        while (true) {
            player.getPlayerInput();
            List<Integer> playerNumbers = player.getInputList();

            conditionCheck(computerNumbers, playerNumbers);
            printCondition();
            if (threeStrike) {
                System.out.println(sucessMessage);
                break;
            }
        }
    }

    //결과 check
    public void conditionCheck(List<Integer> computer, List<Integer> player) {
        ballCondition = 0;
        strikeCondition = 0;

        for (int i = 0; i < player.size(); i++) {
            if (player.get(i) == computer.get(i)) {
                strikeCondition += 1;
            } else if (computer.contains(player.get(i))) {
                ballCondition += 1;
            }
        }

        if (strikeCondition == 3) {
            threeStrike = true;
        }
    }

    public String printCondition() {
        String result = "";

        if (ballCondition != 0) {
            result += ballCondition + "볼 ";
        }
        if (strikeCondition != 0) {
            result += strikeCondition + "스트라이크";
        }
        if (ballCondition == 0 && strikeCondition == 0) {
            result += "낫싱";
        }

        System.out.println(result);
        return result;
    }
}
