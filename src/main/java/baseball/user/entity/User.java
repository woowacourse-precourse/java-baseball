package baseball.user.entity;

public class User {
    private final int NUMBER_LENGTH = 3;

    public String inputUserNumber;
    public Integer[] userNumbersArr;

    public User(){
        this.userNumbersArr = new Integer[NUMBER_LENGTH];
    }

}
