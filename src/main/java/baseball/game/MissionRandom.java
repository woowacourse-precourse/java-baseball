package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

class MissionRandom implements RandomInRange {
    @Override
    public Digit pickRandomInRange(int startInclusive, int endInclusive) {
        return Digit.from(Randoms.pickNumberInRange(startInclusive, endInclusive));
    }
}
