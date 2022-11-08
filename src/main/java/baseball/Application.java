package baseball;
import java.util.Scanner;
import java.util.regex.Pattern;

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
            numberToVerify = "Error";
        }

        return numberToVerify;
    }

    static String verifyThreeNumber(String threeNumber) {
        String numberToVerify = threeNumber;

        try {
            int lengthOfNumber = numberToVerify.length();
            if (lengthOfNumber != 3) {
                throw new IllegalArgumentException();
            }

            boolean isOnlyNumber = Pattern.matches("^[0-9]*$", numberToVerify);
            if (!isOnlyNumber) {
                    throw new IllegalArgumentException();
            }

            char firstNumber = numberToVerify.charAt(0);
            char secondNumber = numberToVerify.charAt(1);
            char thirdNumber = numberToVerify.charAt(2);
            boolean hasSameNumbers = false;
            if (firstNumber == secondNumber || firstNumber == thirdNumber || secondNumber == thirdNumber) {
                hasSameNumbers = true;
            }
            if (hasSameNumbers) {
                throw new IllegalArgumentException();
            }


        } catch (IllegalArgumentException e) {
            System.out.println(e.getClass().getName());
            numberToVerify = "Error";
        }

        return numberToVerify;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
            while (true) {
                System.out.println("숫자 야구 게임을 시작합니다.");


                String userThreeNumber = getThreeNumberByUser();
                userThreeNumber = verifyThreeNumber(userThreeNumber);
                if (userThreeNumber.equals("Error")) {
                    break;
                }



                String userRetryNumber = getRetryNumberByUser();
                userRetryNumber = verifyRetryNumber(userRetryNumber);
                if (userRetryNumber.equals("1")) {
                    continue;
                } else if (userRetryNumber.equals("2")){
                    break;
                } else if (userRetryNumber.equals("Error")){
                    break;
                }

        }
    }
}
