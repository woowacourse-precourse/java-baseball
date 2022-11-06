package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void printMessage(String message){
        System.out.println(message);
    }

    public static List<Integer> createRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String receiveInput(){
        String input = Console.readLine();
        return input;
    }

    public static void checkInputLength(String inputString, int len){
        if(inputString.length()!=len)
            throw new IllegalArgumentException();
    }

    public static List <Integer> checkInputInteger(String inputString){
        List<Integer> inputStringToIntegerList = new ArrayList<Integer>();
        for(int i=0; i<inputString.length(); i++){
            if('0'<=inputString.charAt(i) && inputString.charAt(i)<='9') {
                inputStringToIntegerList.add((int) inputString.charAt(i) - '0');
            }
        }
        if(inputStringToIntegerList.size()!=3)
            throw new IllegalArgumentException();
        return inputStringToIntegerList;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}