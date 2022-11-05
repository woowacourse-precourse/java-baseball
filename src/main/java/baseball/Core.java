package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

public class Core {
    public boolean isDigitStrike(List<Integer> computerNumber, List<Integer> userNumber, int index){
        return computerNumber.get(index).equals(userNumber.get(index));
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> userNumber){
        int count=0;
        for(int index=0; index<userNumber.size(); index++){
            if(isDigitStrike(computerNumber,userNumber,index)){
                count++;
            }
        }
        return count;
    }

    public List<Integer> generateComputerRandomNumber(){
        List<Integer> computerRandomNumber = new ArrayList<>();
        while (computerRandomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }
        return computerRandomNumber;
    }

    public boolean isDigitBall(List<Integer> computerNumber,List<Integer> userNumber, int index){
        if(isDigitStrike(computerNumber, userNumber, index)){
            return false;
        }
        for(int cur=0; cur<computerNumber.size(); cur++){
            if(index==cur){
                continue;
            }
            if(userNumber.get(index)==computerNumber.get(cur)){
                return true;
            }
        }
        return false;
    }

    public int countBall(List<Integer> computerNumber,List<Integer> userNumber){
        int count=0;
        for(int index=0; index<userNumber.size(); index++){
            if(isDigitBall(computerNumber, userNumber, index)){
                count++;
            }
        }
        return count;
    }

    public boolean isEndFlagged(int strikes){
        if(strikes==3){
            return true;
        }
        return false;
    }

    public void validateUserInputOneOrTwo(String input){
        if(input.equals("1") || input.equals("2")){
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    public void validateUserInputThreeDifferentNumbers(String input){
        if(input.length()!=3){
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
        HashSet<Character> set = new HashSet<>();
        for(char c : input.toCharArray()){
            if(!Character.isDigit(c) || c=='0'){
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
            set.add(c);
        }
        if(set.size()!=3){
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
    }
}
