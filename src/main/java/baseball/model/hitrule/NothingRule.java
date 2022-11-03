package baseball.model.hitrule;

public class NothingRule implements HitsDiscriminatoryRules{
    @Override
    public boolean isType(String homeRun, String hits, int index) {
        return hits.indexOf(homeRun.charAt(index)) < 0;
    }
}
