package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    //숫자 입력
    String[] inputArray;
    List<Integer> userNumList;

    int reStartNum;

    int i; //리스트 입력을위한 반복횟수 초기화용 상수
    int size =3;

    public String userNumLengthCheck () {
        String inputNum = Console.readLine();
        if(inputNum.length() !=3){
            throw new IllegalArgumentException();
            }
        return inputNum;
    }
    public String[] userNumFormatCheck (String inputNum) {
        for(int i = 0 ; i < inputNum.length() ; i++) {
            if(48>=inputNum.charAt(i) && inputNum.charAt(i)>57)
                throw new IllegalArgumentException();
            }  inputArray=inputNum.split("");
            return inputArray;
    }
    public List<Integer> userNumList (String[] inputArray){
        userNumList = new ArrayList<>();
        i=0;
        while(userNumList.size() < size){
            if(! userNumList.contains(Integer.parseInt(inputArray[i]))) {
                userNumList.add(Integer.parseInt(inputArray[i]));
                i++;
            }else{throw new IllegalArgumentException();}
        }   return userNumList;
    }

    public boolean restart (){
        reStartNum =Integer.parseInt(Console.readLine());
        if(reStartNum==1){
            return true;
        } else if (reStartNum==2) {
            return false;
        }else {
            throw new IllegalArgumentException();
        }
    }





}
