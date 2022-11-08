package baseball;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.List;

import static baseball.Computer.getComputer;
import static baseball.Player.getPlayer;
import static baseball.Constant.OVER;
import static baseball.Constant.STRIKE;

public class GameManager {
    private List<Integer> answer;
    private List<Integer> userInput;
    private boolean continuation = true;

    public void startGame() {
        answer = getComputer().createRandomNumber();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = getPlayer().inputNumber();

            String result = getComputer().judgeNumber(answer, userInput);

            System.out.println(result);

            if (result.equals(STRIKE)) {
                break;
            }
        }
    }

    public void continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int continueInput = getPlayer().inputContinuation();

        if(continueInput == OVER) {
            this.continuation = false;
            System.out.println("게임 종료");
        }
    }

    public boolean getContinuation() {
        return continuation;
    }

    // Illegal Reflective Access Warning 출력 안되도록 하는 것
    public static void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            /*
            지정된 Java 변수에 참조값을 저장
            저장되는 x 가 null 이거나 필드 유형과 불일치할 경우 정의되지 X
             */
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException e) {
            // ignore
        }
    }

    /*
    Field : getDeclaredField ?
    Java Reflection 을 사용하면 특정 인스턴스의 멤버 변수, 메소드 등에 접근할 수 있다.
    멤버변수에 접근할 수 있는 방법으로 getFields 메소드를 사용하는데, 이는 public 멤버변수에만 접근이 가능하다
    private 을 포함한 모든 멤버변수에 접근하기 위해선 getDeclaredField 메소드를 사용한다.
     */
}
