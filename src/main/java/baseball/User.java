package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> proposal;

    public void setProposal() {
        System.out.print("숫자를 입력해주세요 : ");
        proposal = new ArrayList<>();
        for (char ch : Console.readLine().toCharArray()) {
            proposal.add(Integer.valueOf(String.valueOf(ch)));
        }

        System.out.println("proposal: "+proposal);
    }

    public List<Integer> getProposal() {
        return this.proposal;
    }

    public boolean confirm(List<Integer> result) {
        int strikeCount = result.get(0);
        int ballCount = result.get(1);

        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            return true;
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.printf("%d스트라이크\n", strikeCount);
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.printf("%d볼\n", ballCount);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
        }

        return false;

    }
}
