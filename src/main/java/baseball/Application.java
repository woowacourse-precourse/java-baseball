package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean gameFinishFlag = false, equalNumberFlag = false;
        int userNumber, strikeCount, ballCount;
        while(gameFinishFlag) {

            int randomNumber = 000; //상대방(컴퓨터)의 수를 생성하는 메소드 호출

            // TODO : 게임 진행 과정은 추가적인 메소드로 분리해야 할 듯!
            while (equalNumberFlag) {
                System.out.print("숫자를 입력해주세요 : ");
                try{
                    userNumber = Integer.parseInt(Console.readLine());
                }
                catch (NumberFormatException ex) {
                    // 유효하지 않은 사용자 입력에 대해 예외 처리하는 메소드 호출
                }

                strikeCount = 0; // 스트라이크 개수를 체크하는 메소드 호출
                ballCount = 0; // 볼 개수를 체크하는 메소드 호출

                boolean nothing = true; // 낫싱을 체크하는 메소드 호출

                // TODO : 결과 출력에 대해 추가적인 메소드로 분리해야 할 듯!
                if (nothing) {
                    System.out.println("낫싱");
                } else {
                    if (strikeCount == 0 && ballCount != 0)
                        System.out.println(ballCount + "볼");
                    else if (strikeCount != 0 && ballCount == 0)
                        System.out.println(strikeCount + "스트라이크");
                    else
                        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                }

                // 판정 결과를 정답과 비교하는 메소드 호출
            }
        }
    }
}
