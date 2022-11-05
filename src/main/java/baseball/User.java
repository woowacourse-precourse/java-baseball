package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public String readNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try{
            Validator.checkStart(input);
        }
        catch(IllegalArgumentException e){
            System.exit(0);
        }
        return input;
    }
    public String readEndInput(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input =Console.readLine();

        try{
            Validator.checkEndInput(input);
        }
        catch (IllegalArgumentException e){
            System.exit(0);
        }
        return input;
    }
}
