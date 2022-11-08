package baseball.domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player) {
        StringBuilder sb = new StringBuilder();
        Judgement judgement = new Judgement();

        int strikeCount = 0;
        int size = computer.size();
        for (int i = 0; i < size; i++) {
            if (judgement.hasPlace(computer, i, player.get(i))) {
                strikeCount++;
            }
        }

        int ballCount = judgement.correctCount(computer, player) - strikeCount;

        if (ballCount > 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크 ");
        }
        if (sb.length() == 0) {
            sb.append("낫싱 ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
