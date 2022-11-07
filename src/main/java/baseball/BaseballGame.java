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

    public List<Integer> checkNumber(List<Integer> computer, List<Integer> proposal) {
        List<Integer> checkList = new ArrayList<>();
        int strikeCount = checkStrikes(computer, proposal);

        return checkList;
    }

    public void run() {
        List<Integer> computer = this.getRandomNumbers();

        User user = new User();
        user.setProposal();
        List<Integer> proposal = user.getProposal();

        List<Integer> result = this.checkNumber(computer, proposal);

    }
}
