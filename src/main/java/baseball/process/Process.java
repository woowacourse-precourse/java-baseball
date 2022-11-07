package baseball.process;

import baseball.RandomNumber;

public class Initialization {
    private int numberOfDigit;
    private int randomNumber;

    Initialization(final int NUMBER_OF_DIGIT){
        numberOfDigit = NUMBER_OF_DIGIT;
        RandomNumber randomNumberObject = new RandomNumber(numberOfDigit);
        randomNumber = randomNumberObject.getRandomNum();
    }

    public int getRandomNumber(){
        return randomNumber;
    }
}
