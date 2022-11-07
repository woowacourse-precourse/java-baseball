package baseball;

import camp.nextstep.edu.missionutils.Console;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /*
        1. 3자리 숫자를 랜덤으로 생성한다. 무한 루프로 진입한다.
            2. 시작 메시지를 출력하고 숫자 3자리를 입력 받는다.
            3. 입력받은 숫자가 제약조건에 맞는지 확인한다.
                -1 제약조건에 맞다면 4.으로 이동한다.
                -2 제약조건에 맞지 않으면 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
            4. 입력받은 숫자를 검사해 결과를 받는다.
            5. 결과를 확인한다.
                -1 3스트라이크일때 게임 종료 문구를 출력한다. 게임 지속 여부를 확인하고 1.로 가거나 종료한다.
                -2 그 외의 결과일때 2.로 돌아간다.
         */

        BaseballGame game = new BaseballGame();
        game.makeRandomNum();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.println("숫자를 입력해 주세요 :  ");
            String num = Console.readLine();

            game.checkIllegal(num);

            String result = game.getResult();

            if(result.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String keepGoing = Console.readLine();
                if(keepGoing.equals("1")){ //새로 시작
                    game.makeRandomNum(); //
                } else if(keepGoing.equals("2")){ //종료
                    return;
                }
            }
            System.out.println(result);
        }
    }
}
