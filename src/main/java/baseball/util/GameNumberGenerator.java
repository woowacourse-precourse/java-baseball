package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public final class GameNumberGenerator {
    public static final int GAME_NUMBER_LENGTH = 3;
    public static final int GAME_NUMBER_MIN = 1;
    public static final int GAME_NUMBER_MAX = 9;
    private static ArrayList<Integer> gameNumberDomainList;

    private static void init() {

        gameNumberDomainList = createDomainList(GAME_NUMBER_MIN, GAME_NUMBER_MAX);
    }

    public static String createNumber() {
        init();
        return getLengthSizeRandomStringInDomain(GAME_NUMBER_LENGTH);
    }

    private static ArrayList<Integer> createDomainList(int start, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        return list;
    }

    private static String getLengthSizeRandomStringInDomain(int length) {
        String randomString = "";
        for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            int randomIndex = getRandomIndex(0, gameNumberDomainList.size() - 1);
            randomString += gameNumberDomainList.get(randomIndex);
            gameNumberDomainList.remove(randomIndex);
        }
        return randomString;
    }

    private static int getRandomIndex(int start, int end) {

        return Randoms.pickNumberInRange(start, end);
    }
}
