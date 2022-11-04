package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

class CreateRandom {
    public int[] makeRandomNums() {
        int[] randomNumbers = new int[3];
        int i = 0;

        fillArray(i, randomNumbers);

        return randomNumbers;
    }

    private void fillArray(int i, int[] randomNumbers) {
        int random;
        while (i < 3) {
            random = pickNumberInRange(0, 9);
            boolean check = checkIfDuplicatedNumber(random,randomNumbers);
            if (check) continue;

            randomNumbers[i] = random;
            i++;
        }
    }

    private boolean checkIfDuplicatedNumber(int random, int[] randomNumbers) {
        for(int i = 0 ; i < 3; i++ ) {
            if (randomNumbers[i] == random) {
                return true;
            }
        }
        return false;
    }
}
