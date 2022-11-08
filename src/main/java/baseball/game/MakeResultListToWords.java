package baseball.game;

import java.util.List;

public class MakeResultListToWords {

    private int strikeCount;
    private int ballCount;

    public String makeResultToWords(List<String> resultList){
        countStrikeAndBall(resultList);
        String result="";

        if(ballCount !=0){
            result += String.valueOf(ballCount) + "볼 ";
        }
        if (strikeCount !=0){
            result += String.valueOf(strikeCount) + "스트라이크";
        }
        else if(strikeCount ==0 && ballCount ==0){
            result += "낫싱";
        }
        return result;

    }
    private void countStrikeAndBall(List<String> resultList){
        int strikeCount =0;
        int ballCount=0;

        for(int index=0; index< resultList.size(); index++){
            if(resultList.get(index).equals("스트라이크")){
                strikeCount++;
            }
            else if(resultList.get(index).equals("볼")){
                ballCount++;
            }
        }
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

}
