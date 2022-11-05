package baseball;

import java.util.List;

public class BallStrikeCheck {
    Number num = new Number();

    List computerNumber =  num.randomNumber();
    String userNumber = num.userNumber();

    int ball = 0;
    int strike = 0;

    private void ballStrikeCount() {
        for(int i = 0; i<userNumber.length(); i++) {
            if(computerNumber.contains(userNumber.charAt(i)+"") == true && i != computerNumber.indexOf(userNumber.charAt(i)+"")) {
                ball += 1;
            } else if(computerNumber.contains(userNumber.charAt(i)+"") == true && i == computerNumber.indexOf(userNumber.charAt(i)+"")) {
                strike += 1;
            }
        }
    }
}
