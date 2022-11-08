package baseball.output;

import static baseball.Constants.*;

import baseball.BallType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final StringBuilder sb = new StringBuilder();
    private String result;
    private boolean correct;

    public Result(){
        this.result = "";
        this.correct = false;
    }

    public void updateResult(List<Integer> userNumberList, List<Integer> computerNumberList){
        this.result =  getResult(userNumberList, computerNumberList);
        this.correct = (result.equals(ALL_STRIKE_RESULT));
    }

    public void printResult() {
        System.out.println(result);
    }

    public boolean getCorrect() {
        return correct;
    }

    public String getResult(){
        return result;
    }


    private String getResult(List<Integer> userNumberList, List<Integer> computerNumberList){
        Map<String, Integer> typeScoreMap = getTypeScoreMap();

        for(int index = 0; index < NUMBER_LENGTH; index++){
            int nowDigit = userNumberList.get(index);
            String digitResult = getDigitResult(nowDigit, index, computerNumberList);
            putResult(typeScoreMap, digitResult);
        }
        return getResultStr(typeScoreMap);
    }

    private Map<String, Integer> getTypeScoreMap(){
        return new HashMap<>(){{
            put(BallType.Strike.getEnglish(), 0);
            put(BallType.Ball.getEnglish(), 0);
            put(BallType.Nothing.getEnglish(), 0);
        }};
    }

    private String getDigitResult(int nowDigit, int index, List<Integer> computerNumberList){
        int digitIndex = computerNumberList.indexOf(nowDigit);
        if(digitIndex == MISSING_INDEX){
            return BallType.Nothing.getEnglish();
        }
        else if(index == digitIndex){
            return BallType.Strike.getEnglish();
        }
        return BallType.Ball.getEnglish();
    }

    private void putResult(Map<String, Integer> typeScoreMap, String digitResult){
        int prevScore = typeScoreMap.get(digitResult);
        typeScoreMap.put(digitResult, prevScore+1);
    }

    private String getResultStr(Map<String, Integer> typeScoreMap){
        sb.setLength(0);
        appendScore(sb, BallType.Nothing.getEnglish(), typeScoreMap);
        appendScore(sb, BallType.Ball.getEnglish(), typeScoreMap);
        appendScore(sb, BallType.Strike.getEnglish(), typeScoreMap);
        return sb.toString().strip();
    }

    private void appendScore(StringBuilder sb, String type, Map<String, Integer> typeScoreMap){
        int typeScore = typeScoreMap.get(type);
        if(type.equals(BallType.Nothing.getEnglish())){
            if(typeScore == NUMBER_LENGTH){
                sb.append(BallType.valueOf(type).getKorean());
            }
        }
        else if(typeScore >  0){
            sb.append(typeScoreMap.get(type))
                    .append(BallType.valueOf(type).getKorean())
                    .append(" ");
        }
    }
}
