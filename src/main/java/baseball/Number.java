package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Number {
    public static int rangeCheck() {
        String beforeCheck = Console.readLine();
        if(beforeCheck.length()>3){
            throw new IllegalArgumentException("입력값 초과, 입력값은 3자리 숫자여야 합니다.");
        }
        if(beforeCheck.length()<3){
            throw new IllegalArgumentException("입력값 미달, 입력값은 3자리 숫자여야 합니다.");
        }

        try{
            int input = Integer.parseInt(beforeCheck);
        }catch (Exception ex){
            throw new IllegalArgumentException("숫자가 아닌 값을 포함하고 있습니다. 1-9까지의 숫자만 입력하세요.");
            //ex.printStackTrace();
        }

        int afterCheck = Integer.parseInt(beforeCheck);
        int finalNumber = afterCheck;
        ArrayList<Integer> duplicate = new ArrayList<>(3);
        duplicate.clear();
        duplicate.add(afterCheck/100);
        afterCheck %=100;
        duplicate.add(afterCheck/10);
        afterCheck %=10;
        duplicate.add(afterCheck);
        if(duplicate.get(0)==duplicate.get(1) || duplicate.get(1)==duplicate.get(2) || duplicate.get(0)==duplicate.get(2)){
            throw new IllegalArgumentException("같은 숫자를 중복해서 입력할 수 없습니다.");
        }
        if(duplicate.get(0)==0 || duplicate.get(1)==0 || duplicate.get(2)==0){
            throw new IllegalArgumentException("0은 포함할 수 없습니다.");
        }
        return finalNumber;
    }
}
