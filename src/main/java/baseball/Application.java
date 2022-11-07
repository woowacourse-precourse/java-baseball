package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        String numberPresentedByPlayer = ""; // User로부터 입력받을 숫자를 저장할 변수

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            //numberPresentedByPlayer = recivedUeserInput.nextLine();
            numberPresentedByPlayer = reciveUeserInput();
            System.out.println(numberPresentedByPlayer);

            break;

        }
    }

    // user로부터 3가지 숫자를 입력받는 함수
    public static String reciveUeserInput(){

        Scanner recivedUeserInput = new Scanner(System.in); // Scanner 클래스를 통해 시스템의 입력장치로부터 읽은 Scanner 생성하여 변수에 저장

        //BufferedReader reciveInput = new BufferedReader(new InputStreamReader(System.in));

        //입력 데이터 읽기
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = recivedUeserInput.nextLine();
        return numbers;

    }


}
