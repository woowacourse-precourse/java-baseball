package baseball;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private List<Integer> userNumber;

    public void setUserNumber() {
        List<Integer> userNumber=makeUserNumber();

        if(isValidUserNumber(userNumber)){
            this.userNumber=userNumber;
        }
        else{
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다");
        }
    }

    public List<Integer> makeUserNumber() {
        System.out.println("숫자를 입력해주세요: ");
        String inputString = readLine();
        List<Integer> inputNumber=new ArrayList<>();
        for(int i=0;i<inputString.length();i++){
            inputNumber.add(inputString.charAt(i)-'0');
        }
        return inputNumber;
    }
    public boolean isValidUserNumber(List<Integer> inputNumber){
        return lengthCheck(inputNumber)
                &&numberCheck(inputNumber);
    }
    public boolean lengthCheck(List<Integer> inputNumber){
        return inputNumber.size()==3;
    }
    public boolean numberCheck(List<Integer> inputNumber){
        return inputNumber.stream()
                .filter(n->n>0&&n<10)
                .distinct()
                .count()==3;
    }
}
