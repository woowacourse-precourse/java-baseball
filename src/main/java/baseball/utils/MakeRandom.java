package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MakeRandom {
    private MakeRandom() {
    }
    private static class LazyHolder {
        private static final MakeRandom INSTANCE = new MakeRandom();
    }
    public static MakeRandom getInstance() {
        return LazyHolder.INSTANCE;
    }

    public List<Integer> numbers() {
//        List<Integer> numberList = new ArrayList<>();
//        while (numberList.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!numberList.contains(randomNumber))
//                numberList.add(randomNumber);
//        }
//        return numberList;
        return Randoms.pickUniqueNumbersInRange(1,9,3);
    }
}
