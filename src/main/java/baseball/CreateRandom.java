package baseball;

import camp.nextstep.edu.missionutils.Randoms;

class CreateRandom {
    int[] randomNumbers;

    public int[] makeRandomNums() {
        randomNumbers = new int[3];
        int i = 0;

        fillArray(i);

        return randomNumbers;
    }

    private void fillArray(int i) {
        int random;
        while (i < 3) {
            random = Randoms.pickNumberInRange(0, 9);
            boolean check = checkIfDuplicatedNumber(random);
            if (check) continue;

            randomNumbers[i] = random;
            i++;
        }
    }

    private boolean checkIfDuplicatedNumber(int random) {
        for(int i = 0 ; i < 3; i++ ) {
            if (randomNumbers[i] == random) {
                return true;
            }
        }
        return false;
    }

    public void initializer() {
        randomNumbers = new int[3];
    }
}
