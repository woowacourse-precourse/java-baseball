package baseball;

import camp.nextstep.edu.missionutils.Console;

interface Game {
    int START = 1;
    int EXIT = 2;

    /* 게임을 시작하고 끝마치는 과정을 의미하는 게임 플레이 */
    void play();

    /* 게임 플레이가 종료된 후 게임을 다시 플레이할 것인지 사용자에게 묻고 결과를 확인할 수 있도록 반환 */
    int choiceRestartOrExit();

    /* 이하 여러 게임에서 사용될 수 있는 기능들 */

    static int countSameLetterInSameIndexWithoutDuplicate(String criterion, String comparisonTarget) {
        return (int) criterion.chars()
                .filter(i -> i == comparisonTarget.charAt(criterion.indexOf(i)))
                .count();
    }

    static int countSameLetterInDifferentIndexWithoutDuplicate(String criterion, String comparisonTarget) {
        return (int) criterion.chars()
                .filter(i -> i != comparisonTarget.charAt(criterion.indexOf(i)))
                .filter(i -> comparisonTarget.contains(String.valueOf((char) i)))
                .count();
    }

    static String getUserAnswerInString(String question) {
        System.out.print(question);
        return Console.readLine();
    }
}
