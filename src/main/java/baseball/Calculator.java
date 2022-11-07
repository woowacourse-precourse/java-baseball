package baseball;

import java.util.Map;

public class Calculator {
    private Calculator() {}

    /*
     * 컴퓨터와 사용자의 정보를 받아 점수를 계산한다.
     * 스트라이크 10점, 볼 1점, 낫싱 0점
     *
     * @return int
     * */
    public static int calculateScore(Computer computer, User user) {
        Map<Character, Integer> numberIndexMap = computer.getNumberIndexMap();
        String userGameNumber = user.getGameNumber();
        int score = 0;

        for (int index = 0; index < userGameNumber.length(); index++) {
            char currentUserNumber = userGameNumber.charAt(index);
            if (numberIndexMap.containsKey(currentUserNumber)) {
                score += getScoreByIndex(numberIndexMap.get(currentUserNumber), index);
            }
        }

        return score;
    }

    /*
     * 컴퓨터 숫자별 인덱스 정보 Map에서 가져온 numberIndex와 사용자의 현재 숫자를 받아, 점수를 반환
     * 같다면 10점, 다르다면 1점
     *
     * @return int
     * */
    private static int getScoreByIndex(int numberIndex, int index) {
        if (numberIndex == index) {
            return 10;
        }
        return 1;
    }
}
