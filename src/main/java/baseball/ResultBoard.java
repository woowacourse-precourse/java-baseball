package baseball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResultBoard {

    ArrayList<String> totalResult;

    public ResultBoard(ArrayList<Integer> judgement) {
        String ballResult;
        String strikeResult;
        Integer ball = judgement.get(0);
        Integer strike = judgement.get(1);

        totalResult = new ArrayList<>();

        if (ball != 0) {
            ballResult = Integer.toString(ball);
            ballResult = ballResult.concat("볼");
            totalResult.add(ballResult);
        }
        if (strike != 0) {
            strikeResult = Integer.toString(strike);
            strikeResult = strikeResult.concat("스트라이크");
            totalResult.add(strikeResult);
        }
        if(ball!=0&& strike!=0){
            List<String> space = List.of(" ");
            totalResult.addAll(1,space);
        }
        if(ball!=0 || strike!=0) {
            totalResult.add("\n");
        }
    }

    public void showResult() {
        if (totalResult.isEmpty()) {
            System.out.println("낫싱");
            return;
        }
        for (String result : totalResult) {
            System.out.print(result);
        }
    }
}
