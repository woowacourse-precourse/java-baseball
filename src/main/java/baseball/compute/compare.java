package baseball.compute;

import java.util.*;

public class compare {
    private int Strike = 0;
    private int Ball = 0;
    private boolean Nothing = true;

    public compare(){
        this.Strike = 0;
        this.Ball = 0;
        this.Nothing = true;
    }

    public void printStrike(){
        System.out.println("Strike:"+this.Strike);
    }
    public void printBall(){
        System.out.println("Ball:"+this.Ball);
    }
    public void printNothing(){
        System.out.println("Nothing:"+this.Nothing);
    }

    public boolean isfullStrike(){
        if(this.Strike == 3) return true;
        return false;
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
            if (Answer.contains(u)) {
                //System.out.println("포함됨"+u);
                count++;
            }
        }
        this.Ball = count - this.Strike;
    }
    public void isNothing(){
        if (this.Strike == 0 && this.Ball == 0) { this.Nothing = true; }
        else {this. Nothing = false; }
    }

    public String PrintInfo(){
        String output = "";
        if (this.Ball >= 1){
            output += this.Ball + "볼 ";
        }

        if(this.Strike >= 1){
            output += this.Strike + "스트라이크";
        }
        if (this.Ball == 0 && this.Strike == 0) {
            output += "낫싱";
        }
        return output;
    }

}
