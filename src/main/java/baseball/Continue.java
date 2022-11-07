package baseball;

import java.util.*;

public class Continue {
    public boolean decideContinue(){
        System.out.println("다시 하시겠습니까? 재시작 : 1 , 종료 :2");
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        if(input == '1'){
            return true;
        }
        else{
            return false;
        }
    }

}
