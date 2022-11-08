package baseball.handler;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.GameService.RANDOMBALL;
import static baseball.service.GameService.errorCheck;

public class ExceptionHanlder {
    public void checkInputBallSize(String inputBalls) {

        int checkIndex = 0;

        for(int i = 0 ; i<inputBalls.length(); i++) {
            checkIndex++;
        }

        if(checkIndex != RANDOMBALL.size()) {
            errorCheck = 1;
            throw new IllegalArgumentException();
        }
    }

    public void checkSameInput(String inputBalls) {

        String[] inputBallArr = inputBalls.split("");
        boolean sameInputCheck = true;

        if(inputBallArr[0].equals(inputBallArr[1])) sameInputCheck = false;
        if(inputBallArr[1].equals(inputBallArr[2])) sameInputCheck = false;
        if(inputBallArr[0].equals(inputBallArr[2])) sameInputCheck = false;

        if(!sameInputCheck){
            errorCheck = 1;
            throw new IllegalArgumentException();
        }
    }

    public void CatchNonZero(String inputBalls) {

        List<Integer> checkNonZero = new ArrayList<>();
        String[] inputBallArr = inputBalls.split("");

        for(int i = 0; i < inputBalls.length(); i++) {
            checkNonZero.add(Integer.valueOf(inputBallArr[i]));
        }

        if(checkNonZero.contains(0)) {
            errorCheck = 1;
            throw new IllegalArgumentException();
        }
    }
}