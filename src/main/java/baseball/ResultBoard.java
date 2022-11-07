package baseball;

import java.util.ArrayList;
import java.util.Iterator;

public class ResultBoard {
    String ballResult;
    String strikeResult;
    ArrayList<String> totalResult;
    public ResultBoard(ArrayList<Integer> judgement){
        Integer ball = judgement.get(0);
        Integer strike = judgement.get(1);
        totalResult=new ArrayList<>();

        if(ball!=0){
            ballResult=Integer.toString(ball);
            ballResult=ballResult.concat("볼");
            totalResult.add(ballResult);
        }
        if(strike!=0){
            strikeResult=Integer.toString(strike);
            strikeResult=strikeResult.concat("스트라이크");
            totalResult.add(strikeResult);
        }
    }
    public void showResult(){
        if(totalResult.isEmpty()){
            System.out.println("낫싱");
            return;
        }

        for(String result : totalResult){
            System.out.print(result);
            if(totalResult.indexOf(result)==0){
                System.out.print(" ");
            }
            if(totalResult.indexOf(result)==1){
                System.out.print("\n");
            }
        }
    }
}
