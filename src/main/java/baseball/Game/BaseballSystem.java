package baseball.Game;

public class BaseballSystem {
    public BaseballSystem() {
    }

    public int[] score(int[] sysNum, int[] userNum, int numLen) {
        /* scoreTable = {볼, 스트라이크} */
        int[] scoreTable = {0, 0};

        for (int i = 0; i < numLen; i++) {
            if (sysNum[i] != userNum[i]) {
                scoreTable[0]++;
            }
            if (sysNum[i] == userNum[i]) {
                scoreTable[1]++;
            }
        }

        return scoreTable;
    }

}
