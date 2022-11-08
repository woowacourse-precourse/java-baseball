package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

final class MissionRandom implements RandomInRange {
    @Override
    public int pickRandomInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
