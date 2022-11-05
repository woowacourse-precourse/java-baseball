package Util;

import java.util.Random;

public class RamdomNumber {
    private int[] randomNumber;

    public RamdomNumber(int size){
        randomNumber = new int[size];
    }

    public int[] makeRandomNumber(int size) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean[] alreadyUsed = new boolean[10];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int number = random.nextInt(9) + 1;

            if (!alreadyUsed[number]) {
                alreadyUsed[number] = true;
                randomNumber[i] = number;
            } else {
                i--;
            }
        }
        return randomNumber;
    }
}
