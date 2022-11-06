package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static StringBuilder sb;

    public static void main(String[] args) {
        Application app = new Application();
        app.printStartingGuide();
        List<Integer> computerNumberList;
        List<Integer> userNumberList;
        while(true){
            computerNumberList = app.getComputerNumberList();
            while(true){
                app.printInputGuide();
                userNumberList = app.getUserNumberList();
                String result = app.getResult(userNumberList, computerNumberList);
                System.out.println(result);
                if(result.equals("3스트라이크")){
                    app.printEndingGuide();
                    app.printRestartGuide();
                    break;
                }
            }
            if(app.isEnding()){
                break;
            }
        }
    }

    public List<Integer> getComputerNumberList() {
        ArrayList<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = getValidRandomNumber(computerNumberList);
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }

    private int getValidRandomNumber(List<Integer> lst) {
        int pickNumber;
        do {
            pickNumber = Randoms.pickNumberInRange(1, 9);
        } while (!isValidNumber(pickNumber, lst));
        return pickNumber;
    }

    public boolean isValidNumber(int number, List<Integer> lst) {
        if (number < 1 || number > 9) {
            return false;
        }
        return !lst.contains(number);
    }

    private String getUserInput(){
        return Console.readLine();
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

    private int charToInt(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
        return c - '0';
    }

    private boolean isValidSize(String input) {
        return input.length() == 3;
    }

    private void printStartingGuide(){
        System.out.println("숫자 아구 게임을 시작합니다.");
    }

    private void printInputGuide(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printEndingGuide(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printRestartGuide(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }

    public boolean isEnding(){
        int gameOption = getGameOption();
        return gameOption == 2;
    }

    private int getGameOption(){
        String userInput = getUserInput();
        int userInputNumber = strToInt(userInput);
        if(!isValidOption(userInputNumber)){
            throw new IllegalArgumentException();
        }
        return userInputNumber;
    }

    private boolean isValidOption(int number){
        return number == 1 || number == 2;
    }

    private int strToInt(String input){
        try{
            return Integer.parseInt(input);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
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

    private String getResultStr(Map<String, Integer> typeScoreMap){
        if(isNothing(typeScoreMap)){
            return "낫싱";
        }
        sb = getStringBuilder();

        updateStrikeBallStr(sb, "Ball", typeScoreMap);
        updateStrikeBallStr(sb, "Strike", typeScoreMap);
        return sb.toString().strip();
    }

    private void updateStrikeBallStr(StringBuilder sb, String type, Map<String, Integer> typeScoreMap){
        int typeScore = typeScoreMap.get(type);
        if(typeScore > 0){
            sb.append(typeScoreMap.get(type))
                    .append(BallType.valueOf(type).getKorean())
                    .append(" ");
        }
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

    private boolean isNothing(Map<String, Integer> typeScoreMap){
        return typeScoreMap.get("Nothing") == 3;
    }

    private boolean isAllStrike(Map<String, Integer> typeScoreMap){
        return typeScoreMap.get("Strike") == 3;
    }

    private void putResult(Map<String, Integer> typeScoreMap, String digitResult){
        int prevScore = typeScoreMap.get(digitResult);
        typeScoreMap.put(digitResult, prevScore+1);
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

}
