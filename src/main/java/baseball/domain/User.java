package baseball.domain;
import java.util.ArrayList;
import java.util.Scanner;

import baseball.view.UserInput;

public class User {
    public static ArrayList<Integer> main(String[] args) {
        UserInput.getUserNumber();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> UserNumber = new ArrayList();

        for (int i=0; i<3; i++) {
            Integer num = sc.nextInt();
            UserNumber.add(num);
        }
        return UserNumber;
    }
}