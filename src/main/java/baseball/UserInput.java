package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private List<Integer> number = new ArrayList<Integer>();

    public void input() {
        System.out.print("숫자를 입력해주세요 : ");

        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();

        for (String str : inputString.split("")) {
            this.number.add(Integer.parseInt(str));
        }
    }

    public List<Integer> getNumber() {
        return number;
    }

}
