package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    int response;
    boolean result;
    boolean oneMore=true;

    public void request(){
        System.out.println("숫자를 입력해주세요 : ");
        response = Integer.parseInt(Console.readLine());
    }

    public void pass(String answer){
        if(answer.equals("3스트라이크")){
            result = true;
        }else {
            System.out.println("숫자를 입력해주세요 : ");
            response = Integer.parseInt(Console.readLine());
            result = false;
        }
    }
}
