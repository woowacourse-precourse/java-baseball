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

}
