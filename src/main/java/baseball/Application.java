package baseball;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Application {
    public static List<Integer> InputNumber () throws IOException {
        List<Integer> user = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] userNumber;

        System.out.println("숫자를 입력해주세요 : ");

        userNumber = br.readLine().split("");
        for(int i=0; i<userNumber.length; i++){
            user.add(Integer.parseInt(userNumber[i]));
        }

        return user;
    }
    public static void main(String[] args) throws IOException {
        List<Integer> computer = new ArrayList<>();
        List<Integer> Input = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구게임을 시작합니다.");
        Input = InputNumber();
        System.out.println(Input);

    }
}
