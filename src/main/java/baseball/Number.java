package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Number {
    public static int rangeCheck() {
        String beforeCheck = Console.readLine();
        if(beforeCheck.length()>3){
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }

        try{
            int input = Integer.parseInt(beforeCheck);
        }catch (Exception ex){
            throw new IllegalArgumentException("숫자가 아닌 값을 포함하고 있습니다. 1-9까지의 숫자만 입력하세요.");
            //ex.printStackTrace();
        }

        int afterCheck = Integer.parseInt(beforeCheck);
        int finalNumber = afterCheck;
        int [] duplicate = new int[3];
        duplicate[0] = afterCheck/100;
        afterCheck %=100;
        duplicate[1] = afterCheck/10;
        afterCheck %=10;
        duplicate[2] = afterCheck;
        if(duplicate[0]==duplicate[1] || duplicate[1]==duplicate[2] || duplicate[0]==duplicate[2]){
                throw new IllegalArgumentException("같은 숫자를 중복해서 입력할 수 없습니다.");
        }
        if(duplicate[0]==0 || duplicate[1]==0 || duplicate[2]==0){
            throw new IllegalArgumentException("0은 포함할 수 없습니다.");
        }
        return finalNumber;
    }
}
