package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

   public static List<Integer> getPlaceValuesFromNum(int num)  {
        int count = 0;
        List<Integer> placeValuesFromNum = new ArrayList<>();
        for(int temp = num; temp > 0; temp /= 10, count++) {
            if(temp % 10 == 0)  throw new IllegalArgumentException();
            placeValuesFromNum.add(temp % 10);
        }
        placeValuesFromNum.add(num);
        if(count == 3)  return placeValuesFromNum;
        else throw new IllegalArgumentException("세 자릿수를 입력해주세요.");
    }
}
