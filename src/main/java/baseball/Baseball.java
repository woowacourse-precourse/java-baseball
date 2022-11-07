package baseball;



public class Baseball {
    private String userNumber;
    private String randomNumber;

    public Baseball() {
        userNumber = "";
        randomNumber = "";
    }

    public void setUserNumber(String number) {
        this.userNumber = number;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getRandomNumber() {
        return randomNumber;
    }


}
