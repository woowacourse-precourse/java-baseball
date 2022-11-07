package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Application {
    public static void main(String[] args) {

        String numberPresentedByPlayer = ""; // User로부터 입력받을 숫자를 저장할 변수

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            //numberPresentedByPlayer = receivedUserInput.nextLine();
            List<String> threeNumber = new ArrayList<>();
            threeNumber = createThreeNumbers();
            System.out.println(threeNumber);
            numberPresentedByPlayer = receiveUserInput(); // 게임플레이어로 부터 숫자를 입력받고 변수에 저장
            System.out.println(numberPresentedByPlayer);

            break;

        }
    }

    // user로부터 3개의 숫자를 입력받는 메서드
    public static String receiveUserInput(){

        Scanner receivedUserInput = new Scanner(System.in); // Scanner 클래스를 통해 시스템의 입력장치로부터 읽은 Scanner 생성하여 변수에 저장

        //BufferedReader receiveInput = new BufferedReader(new InputStreamReader(System.in));

        //입력 데이터 읽기
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = receivedUserInput.nextLine();
        return numbers;

    }

    // 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택하는 메서드
    public static List<String> createThreeNumbers(){
        List<String> threeNumbersOfComputer = new ArrayList<>();
        Random random = new Random();
        while (true) {
            if (threeNumbersOfComputer.size() == 3){
                break;
            }
            else{
                int selectedNumberByComputer =  random.nextInt(9)+1;
                String selectedNumberByComputerStringType = String.valueOf(selectedNumberByComputer);
                // 생성된 난수가 이미 이전에 생성됐던 수가 아니라면 선택하기 (서로 다른 3개의 수이므로)
                if (!threeNumbersOfComputer.contains(selectedNumberByComputerStringType)){
                    threeNumbersOfComputer.add(String.valueOf(selectedNumberByComputerStringType));
                }
            }
        }
        return threeNumbersOfComputer;
    }

}
