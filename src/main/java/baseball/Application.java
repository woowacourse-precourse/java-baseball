package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static void endGameState(){

    }

    static void compareNumber(){

    }

    static String pickMyNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String myNumber = Console.readLine();

        // 입력받은 값이 3자리인지
        if(myNumber.length() != 3){
            throw new IllegalArgumentException();
        }

        // 각 자리가 1~9까지의 수로 이루어져 있는지
        int chkNum;
        for(int i = 0; i < myNumber.length(); i++){
            chkNum = Character.getNumericValue(myNumber.charAt(i));
            if(chkNum < 1 || chkNum > 9){
                throw new IllegalArgumentException();
            }
        }

        // 각 자리가 서로 다른 숫자인지
        if(myNumber.charAt(0) == myNumber.charAt(1)){
            throw new IllegalArgumentException();
        }
        if(myNumber.charAt(0) == myNumber.charAt(2)){
            throw new IllegalArgumentException();
        }
        if(myNumber.charAt(1) == myNumber.charAt(2)){
            throw new IllegalArgumentException();
        }

        //System.out.println(myNumber);
        return myNumber;
    }

    static List<Integer> pickComputerNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void startGameState()throws IllegalArgumentException{
        List<Integer> computerNum = pickComputerNum();
        try{
            String myNum = pickMyNum();
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

    }

    static void startApplicationState(){
        // 리턴값에 따라 반복 여부 결정 필요
        startGameState();
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        try{
            startApplicationState();
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
        System.out.println("게임 종료");
    }
}
