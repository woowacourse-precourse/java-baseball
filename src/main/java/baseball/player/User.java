package baseball.player;

import java.util.List;

public class User {

    private List<Integer> userNumberList;

    User(String inputNumber){
        this.userNumberList = generateNumberList(inputNumber);
    }


}
