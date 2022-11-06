package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    protected static List<Integer> Answer;

    public Player() {}

    public static boolean isInteger(String s){
        try  {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isPositiveNumber(String s){
        boolean result = true;
        if (Integer.parseInt(s) <= 0){
            result = false;
        }
        return result;
    }

    public static List<Integer> changeStringtoList(String s){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            result.add(Character.getNumericValue(s.charAt(i)));
        }
        return result;
    }

    public static boolean isDifferentNumbers(List<Integer> list){
        boolean result = true;
        Set<Integer> set = new HashSet<>(list);
        if(set.size() != list.size()){
            result = false;
        }
        return result;
    }

    public static void isValidAnswer(String input){
        if(input.length() != 3 || !isInteger(input) || !isPositiveNumber(input) || !isDifferentNumbers(changeStringtoList(input))){
            throw new IllegalArgumentException("게임종료");
        }
    }
    public static void guessAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        try {
            isValidAnswer(input);
            Answer = changeStringtoList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }




}
