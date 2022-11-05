package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        StrikeBall result = new StrikeBall();

        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber))
                computer.add(randomNumber);
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            do{
                startGame(computer,result);
            }while(endGame());
        }catch (IllegalArgumentException iae){
            return;
        }
    }

    public static boolean startGame(List<Integer> computer, StrikeBall result) throws IllegalArgumentException{
        while(true){
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            try{
                // 3자리 맞는지, 숫자 맞는지
                isRightNum(input);
            }catch (IllegalArgumentException e){
                throw e;
            }

            for(int index=0;index<input.length();index++){
                if(isContain(computer,input.charAt(index))){
                    if(isCorrectPosition(computer,input.charAt(index),index)) strike++;
                    else ball++;
                }
            }
            result.setBall(ball);
            result.setStrike(strike);
            if(strike==3){
                System.out.println(result.toString());
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                return true;
            }else{
                System.out.println(result.toString());
                continue;
            }
        }
    }

    public static void isRightNum(String input) throws IllegalArgumentException {
        try{
            if(input.length()!=3)
                throw new IllegalArgumentException();
            int inputNum = Integer.parseInt(input);
        }catch (NumberFormatException nfe){
            throw nfe;
        }
    }

    public static boolean isContain(List<Integer> computer, char inputElement){
        int inputElementNum = (int)(inputElement-'0');
        if(computer.contains(inputElementNum)) return true;
        else return false;
    }

    public static boolean isCorrectPosition(List<Integer> computer, char inputElement,int index){
        int inputElementNum = (int)(inputElement-'0');
        if(computer.get(index)==inputElementNum) return true;
        else return false;
    }

    public static boolean endGame(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();
        if(input.equals("1")) return true;
        else return false;
    }
}
