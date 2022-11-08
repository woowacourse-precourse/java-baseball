package baseball.controller;

import baseball.domain.Baseball;
import baseball.view.PrinterTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static baseball.view.Printer.showRequestInput;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private static int newGameCode = 1;
    private static int shutDownCode = 1;

    public static int getNewGameCode() {
        return newGameCode;
    }

    public static int getShutDownCode() {
        return shutDownCode;
    }

    @BeforeAll
    static void beforeAll() {
        Scanner sc = new Scanner(System.in);
    }

    /** 게임 라운드 시작 */
    public static void startRound(){
        showRequestInput();
        String input = readLine();
        // 체크

        // 결과 출력
    }


    @Test
    void 사용자_Input을_숫자배열_저장() {
        String str = "123";
        List<Integer> arr = Arrays.asList(1,2,3);
        assertThat(getNumsArr(str)).isEqualTo(arr);
    }

    private List<Integer> getNumsArr(String str) throws IllegalArgumentException {
        List<Integer> numsArr = Arrays.asList(0,0,0);
        int tempNum =0;
        boolean correctNums = false;
        while(!correctNums) {
            correctNums = true;
            try {
                tempNum = Integer.parseInt(str);
                ErrorTest.vaildNum(tempNum);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
                correctNums = false;
            }

        }
        for (int i=0; i<str.length(); i++){
            numsArr.set(2 - i, tempNum % 10);
            tempNum = tempNum/10;
        }
        return numsArr;
    }

    static Baseball testGame;

    @Test
    void input_수_정답과_비교() {
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> input1 = Arrays.asList(1,2,3);
        assertThat(checkAnswer(answer,input1).getStrike()).isEqualTo(3);
    }

    public static Baseball checkAnswer(List<Integer> answer, List<Integer> input) {
        Baseball result = new Baseball();
        // strike 판별
        for (int i=0; i<answer.size(); i++) {
            if(answer.get(i) == input.get(i)) {
                result.strike();
            } else if (answer.contains(input.get(i))) {
                result.ball();
            }
        }
        return result;
    }

    @Test
    void 모두맞춘경우() {
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> input1 = Arrays.asList(1,2,3);
        Baseball result = checkAnswer(answer,input1);
        clear(result);
    }

    // 모두 맞춘 경우
    public static void clear(Baseball game) {
        if (game.getStrike()==3) {
            PrinterTest.showClear();
            getShutDownCheck();
        }
    }

    @Test
    void 종료체크() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(getShutDownCheck()).isEqualTo(1);
    }

    private static int getShutDownCheck() {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean again;
        do {
            PrinterTest.showShutDownCheck();
            try {
                input = sc.nextInt();
                ErrorTest.vaildShutDownInput(input);
                again = false;
            } catch (NumberFormatException e) {
                again = true;
            }
        } while (again);
        sc.close();
        return input;
        }
    }