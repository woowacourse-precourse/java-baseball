package baseball;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User_Input {
    public int getUserInput() {

        Scanner sc = new Scanner(System.in);
        int getNum = 0, flag;
        do{ // 숫자 외 입력 예외처리
            flag = 1;
            try{
                getNum = sc.nextInt();
            }
            catch(InputMismatchException e){
                flag=0;
                sc.nextLine();
                System.out.println("정상적인 숫자를 입력하세요");
            }
        } while(flag==0);

        if (!Checker(getNum)) {
            throw new IllegalArgumentException();
        }

        return getNum;
    }

    public static boolean Checker(Integer inputNum) {
        ArrayList<Integer> arrNum = new ArrayList<>();
        arrNum.add(0);
        if ((inputNum < 999) && (inputNum > 100)) {
            for (int i=0; i<3; i++) {
                int temp = inputNum % 10;
                if(arrNum.contains(temp)) {
                    return false;
                } else {
                    arrNum.add(temp);
                    inputNum /= 10;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
