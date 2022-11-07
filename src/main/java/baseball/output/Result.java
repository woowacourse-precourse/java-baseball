package baseball.output;

import static baseball.Constants.*;

import baseball.BallType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final StringBuilder sb = new StringBuilder();
    private String result;
    private boolean isCorrect;

    public Result(){
        this.result = "";
        this.isCorrect = false;
    }

    public void updateResult(List<Integer> userNumberList, List<Integer> computerNumberList){
        this.result =  getResult(userNumberList, computerNumberList);
        this.isCorrect = (result.equals(ALL_STRIKE_RESULT));
    }

    public void printResult() {
        System.out.println(result);
    }

    public boolean getIsCorrect() {
        return isCorrect;
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
            put("Strike", 0);
            put("Ball", 0);
            put("Nothing", 0);
        }};
    }

    private String getDigitResult(int nowDigit, int index, List<Integer> computerNumberList){
        int digitIndex = computerNumberList.indexOf(nowDigit);
        if(digitIndex == MISSING_INDEX){
            return "Nothing";
        }
        else if(index == digitIndex){
            return "Strike";
        }
        return "Ball";
    }

    private void putResult(Map<String, Integer> typeScoreMap, String digitResult){
        int prevScore = typeScoreMap.get(digitResult);
        typeScoreMap.put(digitResult, prevScore+1);
    }

    private String getResultStr(Map<String, Integer> typeScoreMap){
        sb.setLength(0);
        appendScore(sb, "Missing", typeScoreMap);
        appendScore(sb, "Ball", typeScoreMap);
        appendScore(sb, "Strike", typeScoreMap);
        return sb.toString().strip();
    }

    private void appendScore(StringBuilder sb, String type, Map<String, Integer> typeScoreMap){
        int typeScore = typeScoreMap.get(type);
        if(type.equals("Missing") && typeScore == NUMBER_LENGTH){
            sb.append(BallType.valueOf(type).getKorean());
        }
        else if(typeScore > 0){
            sb.append(typeScoreMap.get(type))
                    .append(BallType.valueOf(type).getKorean())
                    .append(" ");
        }
    }
}
