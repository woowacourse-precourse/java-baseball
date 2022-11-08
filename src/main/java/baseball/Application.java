package baseball;
import java.util.Scanner;

public class Application {
    static String inputThreeNumberByUser() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
            while (true) {
                System.out.print("숫자 야구 게임을 시작합니다.\n");
                String userThreeNumber = inputThreeNumberByUser();




                break;
        }
    }
}
