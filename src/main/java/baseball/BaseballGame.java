package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int checkStrikes(List<Integer> computer, List<Integer> proposal) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(proposal.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public int checkBalls(List<Integer> computer, List<Integer> proposal) {
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            Integer comNum = computer.get(i);
            if (comNum.equals(proposal.get((i + 1) % 3)) ||
                    comNum.equals(proposal.get((i + 2) % 3))) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public List<Integer> checkNumber(List<Integer> computer, List<Integer> proposal) {
        List<Integer> checkList = new ArrayList<>();

        int strikeCount = checkStrikes(computer, proposal);
        int ballCount = checkBalls(computer, proposal);

        checkList.add(strikeCount);
        checkList.add(ballCount);

        return checkList;
    }

    public void run() {
        List<Integer> computer = this.getRandomNumbers();

        User user = new User();
        try {
            user.setProposal();
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            System.out.println(" 게임 종료");
            return;
        }
        List<Integer> proposal = user.getProposal();

        List<Integer> result = this.checkNumber(computer, proposal);
        if (user.confirm(result)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }
}
