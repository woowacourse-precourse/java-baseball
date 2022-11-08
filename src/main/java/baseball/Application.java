package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int threeDigits = 999;

    public static void main(String[] args) throws IOException {

        String playerNumbers = Console.readLine();
        isValidLength(playerNumbers);

        List computerNumbers = RandomNum();
        System.out.println("computerNumbers::"+computerNumbers);


    }

    //랜덤 세자리 수 생성 함수
    public static List RandomNum(){
        List numList = new ArrayList<>();
        for(int i=0; i<3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
                if (numList.contains(num)) {
                    i--;
                } else if (!numList.contains(num)) {
                    numList.add(num);
                }
        }
        return numList;
    }

    public static void isValidLength(String playerNumber) {
        if(playerNumber.length() != 3) {
            throw new IllegalArgumentException("사용자의 숫자가 세자리보다 크거나 작다.");
        }
    }
}
