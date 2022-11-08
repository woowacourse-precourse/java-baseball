package baseball;

import java.util.ArrayList;
import java.util.List;

public class Play {

    public static void printResult(int ballCounter, int strikeCounter, boolean nothingTrue){
        if(ballCounter!=0 && strikeCounter!=0) {
            System.out.println(ballCounter+"볼 "+ strikeCounter+"스트라이크");
        }
        if(ballCounter==0 && strikeCounter!=0) {
            System.out.println(strikeCounter+"스트라이크");
        }
        if(ballCounter!=0 && strikeCounter==0) {
            System.out.println(ballCounter+"볼");
        }
        if(nothingTrue) System.out.println("낫싱");
    }
}
