package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    private static void printStartText(String txt){
        System.out.println(txt);
    }
    private static List<Integer> createRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static void printAskInputText(String txt){
        System.out.printf(txt);
    }
    private static String getInput(){
        String input="";
        input = Console.readLine();
        return input;
    }
    private static void ableToParseInt(String input){
        try {
            int temp=0;
            temp=Integer.parseInt(input);
        }catch (Exception e){
            IllegalArgumentException exception = new IllegalArgumentException();
            throw exception;
        }
    }
}
