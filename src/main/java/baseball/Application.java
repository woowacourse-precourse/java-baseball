package baseball;

import camp.nextstep.edu.missionutils.*;

import java.lang.reflect.Array;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        StrikeBall result = new StrikeBall();

        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            do{
                List<Integer> computer = createNum();
                startGame(computer,result);
            }while(endGame());
        }catch (IllegalArgumentException iae){
            throw iae;
        }
    }

    public static void startGame(List<Integer> computer, StrikeBall result) throws IllegalArgumentException{
        while(true){
            int[] ballStrike = new int[2];

            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine().trim();
            try{
                // 3자리 맞는지, 숫자 맞는지
                isRightNum(input);
            }catch (IllegalArgumentException e){
                throw e;
            }

            checkingNum(computer,input,ballStrike);
            result.setBall(ballStrike[0]);
            result.setStrike(ballStrike[1]);

            if(result.getStrike()==3){
                System.out.println(result.toString());
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }else{
                System.out.println(result.toString());
                continue;
            }
        }
    }

    public static ArrayList<Integer> createNum(){
        ArrayList<Integer> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return computer;
    }

    public static void isRightNum(String input) throws IllegalArgumentException {
        try{
            if(input.length()!=3) throw new IllegalArgumentException();
            Integer.parseInt(input);
        }catch (NumberFormatException nfe){
            throw nfe;
        }
    }

    public static int[] checkingNum(List<Integer> computer, String input, int[] ballStrike){
        for(int index=0;index<input.length();index++){
            if(isContain(computer,input.charAt(index)) && isCorrectPosition(computer,input.charAt(index),index)) ballStrike[1]++;
            else if(isContain(computer,input.charAt(index))) ballStrike[0]++;
        }
        return ballStrike;
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
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
        String input = Console.readLine();
        if(input.equals("1")) return true;
        else return false;
    }
}
