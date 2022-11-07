package baseball;

import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class InputNumber {

    private int num;

    public InputNumber() {
        setInputNumber();
    }
    private void setInputNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        num = sc.nextInt();
    }

    public int getInputNumber() {
        return num;
    }
}
