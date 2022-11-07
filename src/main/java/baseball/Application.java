package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> computernumber = new ArrayList<>();
    public static void checkstrikeball(List<Integer> personnumber){
        int strikecount=0;
        int ballcount=0;
        for(int i=0;i<3;i++){
            if(personnumber.get(i)==computernumber.get(i)){
                strikecount++;
            }else if(computernumber.contains(personnumber.get(i))){
                ballcount++;
            }
        }
        
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
