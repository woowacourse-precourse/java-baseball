package baseball;

public class UserEndGameException {
    public int checkUserHasOneOrTwo(int userNum) {
        if(userNum != 1 && userNum != 2 ){
            throw new IllegalArgumentException();
        }

        return userNum;
    }
}
