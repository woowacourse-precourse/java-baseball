package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    String value;

    User(){
    }

    public void inputUser(){
        System.out.print("숫자를 입력해주세요 : ");
        this.value=Console.readLine();
        checkInputException();
    }

    boolean checkOverlap(){//set을 이용 && 1~9 check

        char first_num= value.charAt(0);
        char second_num= value.charAt(1);
        char third_num= value.charAt(2);

        if(first_num==second_num||first_num==third_num||second_num==third_num){
            return true;
        }
        return false;
    }

    void checkInputException(){
        if(value.length()!=3||checkOverlap()){
            IllegalArgumentException e=new IllegalArgumentException("입력 오류");
            throw e;
        }
    }

}
