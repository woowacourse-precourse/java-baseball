package baseball.game;

import java.util.List;

/**
 * 플레이어와 컴퓨터의 숫자를 비교해서 볼과 스트라이크를 판단.
 */
public class NumberComparer {

    public int checkStrike(List<Integer> player, List<Integer> computer) {
        int strike = 0;
        int computerNumber;
        int playerNumber;

        for (int number = 0; number < player.size(); number++) {
            computerNumber = computer.get(number);
            playerNumber = player.get(number);
            if (computerNumber == playerNumber) { // 자리 위치까지 일치하는지 체크
                strike++;
            }
        }
        return strike;
    }

    public int checkBall(List<Integer> player, List<Integer> computer) {
        int strike = checkStrike(player, computer);
        int ball = 0;

        for (Integer number : player) {
            if (computer.contains(number)) {
                ball++;
            }
        }
        return (ball - strike);
    }
}
