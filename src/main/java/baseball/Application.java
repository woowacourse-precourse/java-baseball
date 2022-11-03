package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");

        int strikeCount = 0;
        int ballCount = 0;
        int nothingCount = 0;

        int escapeNumber = 1;
        while (escapeNumber != 1){

            System.out.println("숫자를 입력해주세요 :");
            Scanner scanner = new Scanner(System.in);
            int userInputNumber = scanner.nextInt();

            List<Integer> user = new ArrayList<>();

            for (int i = 0; i < 3 ; i++) {
                user.add(userInputNumber%10);
                userInputNumber /= 10;
            }


            for (int position = 0 ; position<3 ; position++ ){

                if (computer.contains(user.get(position))){

                    if (computer.indexOf(user.get(position)) == position){

                        strikeCount ++;
                        //strike 상황
                    } else if (computer.indexOf(user.get(position)) != position){

                        ballCount ++;
                        //ball 상황
                    }

                } else if (!computer.contains(user.get(position))){

                    nothingCount ++;

                }

            }

            if (nothingCount == 3){
                System.out.println("낫싱");
            } else if (ballCount > 0 || strikeCount > 0){
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            } else if (ballCount == 0){
                System.out.println(strikeCount + "스트라이크" );
            } else if (strikeCount == 0) {
                System.out.println(ballCount + "볼" );
            }




            // 예외사항 (아직 x)//






        }







    }
}
