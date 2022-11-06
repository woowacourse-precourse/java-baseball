package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Number {
    public static String inputNumber = Console.readLine();
    public static String rangeCheck() {

        if(inputNumber.length()>3){
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }

        try{
            int input = Integer.parseInt(inputNumber);
        }catch (Exception ex){
            throw new IllegalArgumentException("숫자가 아닌 값을 포함하고 있습니다. 1-9까지의 숫자만 입력하세요.");
            //ex.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            int [] duplicate = new int[3];
            duplicate[i] = inputNumber.charAt(i);
            if(duplicate[0]==duplicate[1] || duplicate[1]==duplicate[2] || duplicate[0]==duplicate[2]){
                throw  new IllegalArgumentException("같은 숫자를 중복해서 입력할 수 없습니다.");
            }
        }

        return inputNumber;
    }




}
