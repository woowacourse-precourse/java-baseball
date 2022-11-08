package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final int NUMBERS_LENGTH = 3;
    private final int START_INCLUSIVE = 1;
    private final int FINISH_INCLUSIVE = 9;
    private String number;

    /**
     * NUMBER_LENGTH 크기의 랜덤한 숫자를 생성해 반환
     * @return 컴퓨터가 사용할 랜덤한 숫자
     */
    private String getRandomNumber() {

        String randomNumber = "";

        for(int i = 0; i < NUMBERS_LENGTH; i++) {
            String pickNumber = String.valueOf(Randoms.pickNumberInRange(START_INCLUSIVE, FINISH_INCLUSIVE));

            if(randomNumber.contains(pickNumber)) {
                i--;
            } else {
                randomNumber += pickNumber;
            }
        }

        return randomNumber;
    }

    public void setRandomNumber() {
        this.number = getRandomNumber();
    }

    public String getNumber() {
        return this.number;
    }

}