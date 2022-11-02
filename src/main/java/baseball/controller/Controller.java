package baseball.controller;

import baseball.ball.Ball;

public class Controller {

    Ball ball = new Ball();

    public boolean findException(String input){
        boolean check = false;
        if (input.length()==3){
            check = !checkInput(input);
        }
        return check;
    }

    private static boolean checkInput(String input) {
        boolean check = false;
        for (int i = 0 ; i < 3 ; i++){
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                check = true;
                break;
            }
        }
        return check;
    }
}
