package baseball.participants;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class SportsCaster {
    private final String PLAY_AGAIN = "1";
    private final String TERMINATE = "2";
    public boolean willPlay;

    public SportsCaster() {
        willPlay = true;
    }

    public static void guideGameProcess() {
        List<String> guideList = new ArrayList<>();
        guideList.add("< 숫자 야구 게임 가이드 >");
        guideList.add("1. 컴퓨터는 타자, 유저는 투수입니다.");
        guideList.add("2. 한번의 타석에서 3번 공을 던지고 3스트라이크를 잡아야 게임에서 승리합니다.");
        guideList.add("3. 스트라이크 존은 1부터 9까지 9개 영역으로 나뉩니다." + "\n\t│1│2│3│" + "\n\t│4│5│6│" + "\n\t│7│8│9│");
        guideList.add("4. 타자는 배트를 휘두를 영역을 미리 정해놓습니다. ex) \'123\'");
        guideList.add("5. 투수는 타자가 미리 정한 영역을 순서까지 정확히 예측해야 스트라이크를 잡을 수 있습니다.");
        guideList.add("\tex1) 투수가 \"123\"을 입력했을 때 3스트라이크");
        guideList.add("\tex2) 투수가 \"125\"를 입력했을 때 2스트라이크");
        guideList.add("6. 숫자는 예측했지만, 순서가 다른 경우에는 볼입니다.");
        guideList.add("\tex1) 투수가 \"345\"를 입력했을 때 1볼");
        guideList.add("\tex2) 투수가 \"134\"를 입력했을 때 1볼 1스트라이크");
        guideList.add("7. 타자의 스윙을 전혀 예측하지 못한 경우에는 \"낫싱\"입니다.");
        guideList.add("\tex) 투수가 \"456\"를 입력했을 때 낫싱");
        guideList.add("8. 3스트라이크를 잡을 때까지 숫자 입력을 반복할 수 있습니다.");
        guideList.add("** 주의사항 : 세자리 숫자가 아닌 값을 입력했을 경우에는 게임이 완전히 종료됩니다.");
        System.out.println(String.join("\n", guideList));
    }

    public static void terminateProgram() {
        System.out.println("게임 종료");
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void askToPlayAgain() {
        System.out.println("게임을 다시 시작하시겠습니까? 다시시작[1] 게임종료[2]");
        String againOrTerminate = readLine();
        while (!validatePlayAgain(againOrTerminate)) {
            System.out.println(PLAY_AGAIN + " 혹은 " + TERMINATE + "만 입력해주세요.");
            againOrTerminate = readLine();
        }
        if (againOrTerminate.equals(PLAY_AGAIN)) {
            System.out.println("게임을 다시 시작합니다.");
        }
        if (againOrTerminate.equals(TERMINATE)) {
            System.out.println("게임을 완전히 종료합니다.");
        }
        willPlay = againOrTerminate.equals(PLAY_AGAIN);
    }

    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
    }

    private boolean validatePlayAgain(String againOrTerminate) {
        return againOrTerminate.equals(PLAY_AGAIN) || againOrTerminate.equals(TERMINATE);
    }
}
