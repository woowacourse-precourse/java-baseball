package user;

public class User {

    private Integer tryNumber;

    public User(Integer tryNumber) {
        this.tryNumber = tryNumber;
    }

    public Integer getTryNumber() {
        return tryNumber;
    }

    public void tryCorrectNumber(Integer tryNumber){
        this.tryNumber = tryNumber;
    }
}
