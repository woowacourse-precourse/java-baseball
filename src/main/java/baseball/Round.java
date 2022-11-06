package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Round {
    private static StringBuilder sb;
    private static List<Integer> userNumberList = new ArrayList<>();

    public void run(List<Integer> computerNumberList){
        boolean isCorrect = false;
        do{
            userNumberList = getUserNumberList();
            // 결과 출력
            isCorrect = printResultAndUpdateIsCorrect(userNumberList, computerNumberList);
        }while(!isCorrect);
        //게임 종료 가이드
        printEndingGuide();
    }

    public List<Integer> getUserNumberList() {
        List<Integer> lst = new ArrayList<>();
        String input = getUserInput();
        if (!isValidSize(input)) {
            throw new IllegalArgumentException();
        }
        for (int index = 0; index < 3; index++) {
            int indexInt = charToInt(input.charAt(index));
            if (!isValidNumber(indexInt, lst)) {
                throw new IllegalArgumentException();
            }
            lst.add(indexInt);
        }
        return lst;
    }

    private String getUserInput(){
        return Console.readLine();
    }

    private boolean isValidSize(String input) {
        return input.length() == 3;
    }

    private int charToInt(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
        return c - '0';
    }

    public boolean isValidNumber(int number, List<Integer> lst) {
        if (number < 1 || number > 9) {
            return false;
        }
        return !lst.contains(number);
    }

    private boolean printResultAndUpdateIsCorrect(List<Integer> userNumberList, List<Integer> computerNumberList){
        String result = getResult(userNumberList, computerNumberList);
        System.out.println(result);
        return result.equals("3스트라이크");
    }

    public String getResult(List<Integer> userNumberList, List<Integer> computerNumberList){
        Map<String, Integer> typeScoreMap = getTypeScoreMap();
        for(int index = 0; index < 3; index++){
            int nowDigit = userNumberList.get(index);
            String digitResult = getNumberResult(nowDigit, index, computerNumberList);
            putResult(typeScoreMap, digitResult);
        }
        return getResultStr(typeScoreMap);
    }

    public Map<String, Integer> getTypeScoreMap(){
        return new HashMap<>(){{
            put("Strike", 0);
            put("Ball", 0);
            put("Nothing", 0);
        }};
    }

    private String getNumberResult(int nowDigit, int index, List<Integer> computerNumberList){
        int digitIndex = computerNumberList.indexOf(nowDigit);
        if(digitIndex == -1){
            return "Nothing";
        }
        if(index == digitIndex){
            return "Strike";
        }
        return "Ball";
    }

    private void putResult(Map<String, Integer> typeScoreMap, String digitResult){
        int prevScore = typeScoreMap.get(digitResult);
        typeScoreMap.put(digitResult, prevScore+1);
    }

    private String getResultStr(Map<String, Integer> typeScoreMap){
        if(isNothing(typeScoreMap)){
            return "낫싱";
        }
        sb = getStringBuilder();

        updateStrikeBallStr(sb, "Ball", typeScoreMap);
        updateStrikeBallStr(sb, "Strike", typeScoreMap);
        return sb.toString().strip();
    }

    private boolean isNothing(Map<String, Integer> typeScoreMap){
        return typeScoreMap.get("Nothing") == 3;
    }

    private StringBuilder getStringBuilder(){
        if(Objects.isNull(sb)){
            sb = new StringBuilder();
        }
        else{
            sb.setLength(0);
        }
        return sb;
    }

    private void updateStrikeBallStr(StringBuilder sb, String type, Map<String, Integer> typeScoreMap){
        int typeScore = typeScoreMap.get(type);
        if(typeScore > 0){
            sb.append(typeScoreMap.get(type))
                    .append(BallType.valueOf(type).getKorean())
                    .append(" ");
        }
    }
    private void printEndingGuide(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
