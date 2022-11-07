package baseball.user;

import baseball.valid.Valid;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private int number;

    public int inputNumber() {
        int number = -1;
        while(number == -1){
            number = Valid.userInput(Console.readLine());
        }
        this.number = number;
        return number;
    }

    public Boolean restart() {
        int number = -1;
        while(number != 1 && number != 2) {
            number = Valid.userRestart(Console.readLine());
        }
        if(number == 1) return true;
        else return false;
    }


    public int getNumber() {
        return number;
    }
}
