package baseball;

public class InputNumber {

    private String userNumber;

    public InputNumber(){
        this.userNumber = "" ;
    }

    public String userInputNumber(){
        System.out.println("숫자를 입력해주세요.");
        userNumber = Console.readLine();
        return userNumber;
    }


}
