package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    
    public static String random(){
        boolean check = true;
        ArrayList<Integer> num = new ArrayList<>();
        while(check){
            int random = Randoms.pickNumberInRange(1,9);
            if(!num.contains(random)){
                num.add(random);
            }
            if(num.size() == 3){
                check = false;
            }
        }
        return num.toString();
    }
    
    public static boolean checkRepeat(String number){
        ArrayList<Character> charList = new ArrayList<>();
        for(int n = 0;n < 3; n++){
            if(charList.contains(number.charAt(n))){
                return true;
            }
            if(charList.size() == 3){
                return false;
            }
            else {
                charList.add(number.charAt(n));
            }
        }
        return true;
    }
    
}
