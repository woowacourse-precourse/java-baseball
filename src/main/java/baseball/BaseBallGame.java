package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame implements GameInterface {

    /**
     * 임의의 세 자리 수를 반환합니다.
     */
    public String getComputerNum() {
        List<Integer> computerNumList = new ArrayList<>();
        return getNumByDigit(computerNumList, 3);
    }

    /**
     * 9 이하 숫자, 빈 리스트를 받습니다. 중복되지 않은 3가지의 숫자로 이루어진 문자열을 반환합니다.
     */
    public String getNumByDigit(List<Integer> emptyList, Integer digit) {
        while (emptyList.size() < digit) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!emptyList.contains(randomNumber)) {
                emptyList.add(randomNumber);
            }
        }
        return emptyList.toString();
    }

    /**
     * 게임의 시작 메시지를 출력합니다.
     */
    @Override
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 유저로부터 숫자를 입력받습니다.
     */
    @Override
    public String getUserInput() {
        System.out.print("숫자를 입력하세요 : ");
        return readLine();
    }

    /**
     * 게임의 재시작 여부에 따라, True 혹은 false 를 반환합니다.
     */
    @Override
    public boolean end() {
        boolean flag = askRestart();
        return flag;
    }

    /**
     * 게임 재시작 여부를 물어보고, 그렇다면 true, 아니면 false 를 반환합니다.
     */
    @Override
    public boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        return false;
    }

    /**
     * 데이터를 검증합니다. 들어온 자릿수가 3자릿수가 맞는지를 검사합니다.
     */
    @Override
    public boolean validateInput(String input) {
        return input.length() == 3;
    }

    /**
     * 데이터 검증 결과에 따라서, 게임을 계속 진행할지 혹은 예외를 발생시킬지를 처리합니다.
     */
    @Override
    public void exceptionHandler(boolean flag) {
        if (!flag) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 게임을 반복해서 수행합니다.
     */
    @Override
    public void run() {
        while (true) {
            start();
            String input = getUserInput();
            exceptionHandler(validateInput(input));

        }

    }
}
