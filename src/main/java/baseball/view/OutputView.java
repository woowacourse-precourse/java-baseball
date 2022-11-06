package baseball.view;

import java.util.List;

public class OutputView {
    private static final int BALL=1;
    private static final int STRIKE=2;

    public void printResult(List<Integer> counts){
        if(counts.get(BALL)==0&&counts.get(STRIKE)==0){
            System.out.print("낫싱");
        }
        if(counts.get(BALL)!=0){
            System.out.print(counts.get(BALL)+"볼 ");
        }
        if(counts.get(STRIKE)!=0){
            System.out.print(counts.get(STRIKE)+"스트라이크");
        }
        System.out.println();
    }
}
