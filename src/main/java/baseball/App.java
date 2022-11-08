package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class App {

    /*
    *   computerInput과 playerInput을 비교하여 같은 인덱스에 같은 값이 있다면 해당 값을
    *   computerInput과 playerInput내에서 삭제하고 스트라이크 카운트를 1증가 시킨다.
    *
    * @param computerInput 중복없는 3개의 난수
    *   1~9사이의 중복없는 3개의 난수가 들어있다.
    * @param playerInput
    *   사용자가 입력한 1~9사이의 숫자 3개가 들어있다.
    *
    * @return 스트라이크의 갯수
    * */
    public static int getStrikeCount(List<Integer>computerInput, List<Integer>playerInput){

        int strikeCount = 0;

        for (int i = 2; i >= 0; i--) {

            Integer player_val = playerInput.get(i);
            Integer computer_val = computerInput.get(i);

            if (player_val == computer_val) {

                playerInput.remove(i);
                computerInput.remove(i);
                strikeCount++;
            }
        }

        return strikeCount;
    }

    /*
     * computerInput내에 playerInput의 인자가 있다면 삭제하고 볼카운트를 1 증가시킨다.
     * 
     * @param computerInput 중복없는 3개 이하의 난수
     *   1~9사이의 중복없는 3개이하의 난수가 들어있다.
     * @param playerInput
     *   사용자가 입력한 1~9사이의 숫자 3개이하가 들어있다.
     *
     * @return 볼의 갯수
     * */
    public static int getBallCount(List<Integer> computerInput, List<Integer> playerInput) {

        int ballCount = 0;

        for (Integer player_val : playerInput) {

            if (computerInput.contains(player_val)) {

                computerInput.remove(player_val);
                ballCount++;
            }
        }

        return ballCount;
    }

    /*
     *  ballCount와 strikeCount의 갯수에 따라 볼과 스트라이크 여부를 리턴한다.
     *
     * @param ballCount 볼의 갯수
     * @param strikeCount 스트라이크 갯수
     *
     * @return 결과값을 리턴한다
     * (예 : 1볼 1스트라이크)
     * */
    public static String getResult(int ballCount, int strikeCount) {

        String result  = new String();

        if (ballCount != 0) {
            result += ballCount + "볼";
        }

        if (strikeCount != 0) {

            if (ballCount != 0) {
                result += " ";
            }

            result += strikeCount + "스트라이크";
        }

        if (ballCount == 0 && strikeCount == 0) {
            result = "낫싱";
        }

        return result;
    }

    /*
    *   computerInput을 기준으로 게임을 시작한다.
    *   (어떻게 설명해야할지를 모르겠습니다. 하나하나 적자니 너무 난잡하고 너무 간단하게 적자니 모호한거같습니다.)
    *
    * @param computerInput 중복없는 3개의 난수
    *   1~9사이의 중복없는 3개의 난수가 들어있다.
    *
    * @throws IllegalArgumentException 사용자의 잘못된 입력
    * 
    * @return 결과값을 리턴함 
    *   (예 : 1볼 1스트라이크, 낫싱)
    * */
    private String startGame(List<Integer> computerInput) throws IllegalArgumentException
    {

        String result = new String();

        System.out.println("숫자 야구 게임을 시작합니다");
        while (true) {

            System.out.print("숫자를 입력해주세요 : ");
            String read_player_input = Console.readLine();

            List<Integer> player_input = new ArrayList<>();

            List<Integer> bak_computer_input = new ArrayList<>(computerInput);

            /*에러검사*/
            try {
                /*
                1. 길이 검사
                2. 문자 검사
                3. 중복 검사
                * */
                CheckException.checkLength(read_player_input, 3);
                CheckException.checkChar(read_player_input,'1', '9');
                CheckException.checkDup(read_player_input);
            } catch (IllegalArgumentException e) {
                throw e;
            }

            /*사용자 입력을 List에 Integer로 저장*/
            for (int i = 0; i < read_player_input.length(); i++) {
                Integer tmp_val = Integer.valueOf(read_player_input.charAt(i) - '0');
                player_input.add(tmp_val);
            }

            /*스트라이크 카운트*/
            int strike_count = getStrikeCount(bak_computer_input, player_input);

            /*볼 카운트*/
            int ball_count = ball_count = getBallCount(bak_computer_input, player_input);

            /*결과값 (예 : 1볼 1스트라이크)*/
            result = getResult(ball_count, strike_count);

            if (strike_count == 3) {
                break;
            }

            System.out.println(result);

            /*3스트라이크가 나올때까지 result를 초기화 후 반복*/
            result = "";
        }
        return result;
    }



    /*
    *   1~9사이의 난수 3개를 리스트에 넣는다.
    *
    * @return 난수 리스트
    *   중복없는 3개의 난수가 있는 리스트
    * */
    public static List<Integer> getComputerInput() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3){

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }

        }

        return computer;
    }

    /*
    *   게임을 끝났을때 1을 입력하면 게임을 다시시작하고 2를 입력하면 종료한다.
    *
    * @throws java.long.IllegalArgumentException 사용자의 잘못된 입력
    *
    * @exception java.long.IllegalArgumentException 사용자의 잘못된 입력
    *   중복, 글자 수 초과, 설정한 아스키코드 내의 문자 아닐 시 발생
    * */
    public void play() throws IllegalArgumentException {

        boolean flag = true;

        while (flag) {

            List<Integer> computer = getComputerInput();
            String result;

            try{
                 result = startGame(computer);
            } catch (IllegalArgumentException e){
                throw e;
            }

            System.out.println(result);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");

            String input_flag = Console.readLine();

            try{
                /*
                * 1. 길이 검사
                * 2. 문자 검사
                * */
                CheckException.checkLength(input_flag, 1);
                CheckException.checkChar(input_flag, '1', '2');

            } catch (IllegalArgumentException e){
                throw e;
            }

            if (input_flag.charAt(0) == '2') {
                flag = false;
            }
        }
    }
}
