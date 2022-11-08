package baseball.compute;

import java.util.*;

public class compare {
    int Strike = 0;
    int Ball = 0;
    boolean Nothing = true;

    compare(List<Integer> Answer, List<Integer> UsersAnswer){
        isBall(Answer, UsersAnswer);
    }

    public void isStrike(List<Integer> Answer, List<Integer> UsersAnswer) {
        int count = 0;
        for(int i = 0 ; i < 3; i++) {
            int a = Answer.get(i);
            int u = UsersAnswer.get(i);
            if (a == u) {
                count++;
            }
        }
        this.Strike = count;
    }
    public void isBall(List<Integer> Answer, List<Integer> UsersAnswer) {
        int count = 0;
        for(int i = 0 ; i < 3; i++) {
            int u = UsersAnswer.get(i);
            if (Answer.contains(i)) {
                count++;
            }
        }
        this.Ball = 0;
    }
    public void isNothing(){
        if (this.Strike == 0 && this.Ball == 0) { this.Nothing = true;}
        else { this.Nothing == false;}
    }
}
