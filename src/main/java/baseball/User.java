package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    String response;
    boolean result;

    public void request(){
        System.out.print("숫자를 입력해주세요 : ");
        this.response = Console.readLine();
    }

    public void pass(String answer){
        if(answer.equals("3스트라이크")){
            result = true;
        }else {
            System.out.print("숫자를 입력해주세요 : ");
            response = Console.readLine();
            result = false;
        }
    }
}
