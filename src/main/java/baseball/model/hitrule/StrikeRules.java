package baseball.model.hitrule;

public class StrikeRules implements HitsDiscriminatoryRules {
    @Override
    public boolean isType(String homeRun, String hits, int index) {
        return homeRun.charAt(index) == hits.charAt(index);
    }
}
