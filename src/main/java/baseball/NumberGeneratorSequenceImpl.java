package baseball;

import java.util.List;

public class NumberGeneratorSequenceImpl implements NumberGenerator{
    private List<Integer> sequence;
    private Integer cursor = 0;

    NumberGeneratorSequenceImpl(List<Integer> sequence){
        this.sequence = sequence;
    }

    @Override
    public Integer generate() {
        return this.sequence.get(cursor++);
    }
}
