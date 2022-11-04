package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {

    int userNumber;

    public UserNumber() {}
    public UserNumber(int userNumber) {
        // validation
        this.userNumber = userNumber;
    }

    public void setUserNumber() {
        int userNumberStr = Integer.parseInt(Console.readLine());
        // validation
        if(false) {
            throw new IllegalArgumentException();
        }
        this.userNumber = userNumber;

    }

    // override method for test
    public void setUserNumber(String input) {
        // validation
        if(false) {
            throw new IllegalArgumentException();
        }
        this.userNumber = Integer.parseInt(input);
    }






}
