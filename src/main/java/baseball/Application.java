package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public List<Integer> makeUserNumberToList(String userNumberString){
        int userNumber = Integer.parseInt(userNumberString);
        List<Integer> listNumber = new ArrayList<>();
        while(userNumber < 0){
            listNumber.add(userNumber%10);
            userNumber /= 10;
        }
        return listNumber;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
