package baseball;
import java.util.Scanner;

public class Application {
    static String getThreeNumberByUser() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }

    static String getRetryNumberByUser() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }

    static String verifyRetryNumber(String retryNumber) {
        String numberToVerify = retryNumber;

        try {
            if (!numberToVerify.equals("1") && !numberToVerify.equals("2")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getClass().getName());
        }

        return numberToVerify;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
            while (true) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                String userThreeNumber = getThreeNumberByUser();


                String userRetryNumber = getRetryNumberByUser();
                userRetryNumber = verifyRetryNumber(userRetryNumber);

                if (userRetryNumber.equals("1")) {
                    continue;
                } else if (userRetryNumber.equals("2")){
                    break;
                } else {
                    break;
                }

        }
    }
}
