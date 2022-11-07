package baseball.handler;

import baseball.service.GameService;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.GameService.BALL_NUMBERS;


public class ExceptionHanlder {
    public void checkInputBallSize(String inputball){
        List<Integer> checksize;
        int checkindex = 0;
        checksize = GameService.makeRandomBall();

        for(int i : checksize) {
            checkindex++;
        }
        if(checkindex != inputball.length()){
            throw new IllegalArgumentException();
        }
    }
    //변수 다시보기
    public void checkSameInput(String inputball){
        boolean doublecheck = true;
        String[] inputballarr = inputball.split("");

        if(inputballarr[0].equals(inputballarr[1])) doublecheck = false;
        if(inputballarr[1].equals(inputballarr[2])) doublecheck = false;
        if(inputballarr[0].equals(inputballarr[2])) doublecheck = false;

        if(!doublecheck){
            throw new IllegalArgumentException();
        }
    }

    public void nonZero(String inputball) {
        List<Integer> checkballs = new ArrayList<>();
        String[] inputballarr = inputball.split("");

        for(int i=0; i<inputball.length(); i++){
            checkballs.add(Integer.valueOf(inputballarr[i]));
        }
        if(checkballs.contains(0)){
            throw new IllegalArgumentException();
        }
    }
}



