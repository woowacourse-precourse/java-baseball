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

    public List<Integer> generateRandomNumber(int length){
        List<Integer> computerRandomNumber = new ArrayList<>();
        while (computerRandomNumber.size() < length) {
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

    public List<Integer> stringToIntegerList(String str){
        List<Integer> integerList = new ArrayList<>();
        for(String s : str.split("")){
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }

    public void printGameResult(int strikes, int balls){
        if(strikes==3){
            System.out.println("3스트라이크");
            return;
        }
        if(strikes==0 && balls==0){
            System.out.println("낫싱");
            return;
        }
        if(strikes>0 && balls>0){
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
            return;
        }
        if(strikes>0){
            System.out.printf("%d스트라이크\n",strikes);
            return;
        }
        if(balls>0){
            System.out.printf("%d볼\n",balls);
        }
    }
}
