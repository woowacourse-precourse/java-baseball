package baseball.handler;

import baseball.service.GameService;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHanlder {
    public void checkInputBallSize(String inputballs) {

        int checkindex = 0;
        List<Integer> randomballsize = GameService.makeRandomBall();;

        for(int i : randomballsize) {
            checkindex++;
        }

        if(checkindex != inputballs.length()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkSameInput(String inputballs) {

        String[] inputballarr = inputballs.split("");
        boolean sameinputcheck = true;

        if(inputballarr[0].equals(inputballarr[1])) sameinputcheck = false;
        if(inputballarr[1].equals(inputballarr[2])) sameinputcheck = false;
        if(inputballarr[0].equals(inputballarr[2])) sameinputcheck = false;

        if(!sameinputcheck){
            throw new IllegalArgumentException();
        }
    }

    public void CatchNonZero(String inputballs) {

        List<Integer> checknonzero = new ArrayList<>();
        String[] inputballarr = inputballs.split("");

        for(int i = 0; i < inputballs.length(); i++) {
            checknonzero.add(Integer.valueOf(inputballarr[i]));
        }

        if(checknonzero.contains(0)) {
            throw new IllegalArgumentException();
        }
    }
}