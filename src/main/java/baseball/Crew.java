package baseball;

import java.util.ArrayList;
import java.util.List;

public class Crew {

    public final List<Member> members;

    public Crew(int[] numbers){
        this.members = new ArrayList<>();

        for (int n : numbers){
            if (!Validator.isValidLength(n)){
                continue;
            }
            if (!Validator.isDupilicated(n)){
                continue;
            }if (!Validator.isNumeric(n)){
                continue;
            }

            Member member = new Member(n);
            this.members.add(member);
        }
    }
}
