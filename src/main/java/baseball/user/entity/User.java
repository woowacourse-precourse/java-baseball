package baseball.user.entity;

public class User {
    private final int NUMBER_LENGTH = 3;
    private final Integer[] userAnswer;

    public User(){
        this.userAnswer = new Integer[NUMBER_LENGTH];
    }

    public void setUserAnswer(String number) {
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            userAnswer[i] = Character.getNumericValue(number.charAt(i));
        }
    }

    public Integer[] getUserAnswer(){
        return userAnswer;
    }
}
