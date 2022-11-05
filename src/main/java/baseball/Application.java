package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Application {
    private final static int BALL =0;
    private final static int STRIKE =1;
    private final static String CONTINUE ="1";
    private final static String END = "2";
    private static List<Integer> stringToIntegerList(String str){
        List<Integer> newList = new ArrayList<>();
        for (char x : str.toCharArray()) {
            newList.add(Character.getNumericValue(x));
        }
        return newList;
    }
    private static boolean isNotDuplicate(String str){
        List<Integer> numList = stringToIntegerList(str);
        Set<Integer> numSet = new HashSet<>(numList);
        return numSet.size() == numList.size();
    }
    private static boolean isValidSize(String str){
        return str.length()==3;
    }
    private static boolean isString_in_1to9(String str){
        return str.matches("[1-9.]+");
    }
    public static boolean isValidInput(String input){
        if(!isString_in_1to9(input)) return false;
        //정규 표현식을 이용해 Input이 숫자가 아닌 모든 경우와 Input의 범위가 1~9사이가 아닌 경우를 동시에 처리
        if(!isValidSize(input)) return false;
        if(!isNotDuplicate(input)) return false;
        return true;
    }
    public static List<Integer> createTargetNums(){
        List<Integer> targetNums = new ArrayList<>();
        while(targetNums.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNums.contains(randomNumber)) {
                targetNums.add(randomNumber);
            }
        }

        return targetNums;
    }
    private static int commonNums(List<Integer> list1, List<Integer>list2){
        list1.retainAll(list2);
        return list1.size();
    }
    private static int count_strikes(List<Integer> targetNums, List<Integer>userNums){
        int strike = 0;
        for(int index = 0 ; index<targetNums.size();index++){
            if(targetNums.get(index)==userNums.get(index))
                strike++;
        }
        return strike;
    }
    public static List<Integer> count_BallStrike(List<Integer> targetNums, List<Integer>userNums){
        List<Integer> b_s_list = new ArrayList<>();
        int balls = 0;
        int strikes = 0;

        balls = commonNums(targetNums,userNums);
        strikes = count_strikes(targetNums,userNums);
        balls-=strikes;

        b_s_list.add(balls);
        b_s_list.add(strikes);
        return b_s_list;
    }
    private static String userInput(){
        String input = Console.readLine();
        try {
            if(!isValidInput(input))
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            //TODO:어플리케이션 종료
        }
        return input;
    }
    private static void printResult(List<Integer> ball_Strike){
        int ball = ball_Strike.get(BALL);
        int strike = ball_Strike.get(STRIKE);
        System.out.println(ball +"볼 " + strike + "스트라이크");
    }
    private static boolean is3Strikes(List<Integer> targetNums,List<Integer> userNums){
        List<Integer> ball_Strike = count_BallStrike(targetNums,userNums);
        printResult(ball_Strike);
        if(ball_Strike.get(STRIKE)==3) return true;
        return false;
    }
    private static boolean mainGame(List<Integer> targetNums){
        List<Integer> userNums = stringToIntegerList(userInput());
        if(is3Strikes(targetNums,userNums))  return true;
        return false;
    }
    public static void play(){
        //랜덤숫자 생성
        List<Integer> targetNums = createTargetNums();
        //유저인풋받기 - 맞출때까지 반복
                while(!mainGame(targetNums));
        //재시작 or 종료
    }
    private static boolean askContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = userInput();
        if(input == CONTINUE) return true;
        return false;
    }
    public static void main(String[] args) {
        do{play();}while (askContinue());
    }
}
