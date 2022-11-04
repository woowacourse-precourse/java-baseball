package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    static final int SIZE = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;

    public int getRandomNumber() {
        int number = 0;

        for (int i = 0; i < SIZE; i++) {
            number *= 10;
            number += Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        }

        return number;
    }

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
    }

    public void inputValidator(String input) {
        // 세 자리수가 아닌 경우
        if (input.length() != SIZE) throw new IllegalArgumentException();
        // 서로 같은 숫자가 존재하는 경우
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2))
            throw new IllegalArgumentException();
        // 1~9 범위 외의 랜덤 숫자가 있는 경우
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') throw new IllegalArgumentException();
        }
    }

    public void countBallAndStrike(String randomNumber, String input){
        // 자리 & 숫자 모두 일치
        if (randomNumber.equals(input)) return;

        // 볼, 스트라이크 개수 세기
        int ball = 0;
        int strike = 0;
        for (int i =0; i< SIZE; i++){
            if (randomNumber.charAt(i) == input.charAt(i)) strike++;
            else if (randomNumber.contains(String.valueOf(input.charAt(i)))) ball++;
        }
    }
}