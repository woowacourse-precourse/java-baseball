package baseball.viewer;

public class BaseballViewer {

    private void render(BaseballView view) {
        String textToDisplay = getMessage(view);

        System.out.print(textToDisplay);
    }

    public String getMessage(BaseballView view) {
        if (view.getAnnouncement() != null) {
            return view.getAnnouncement().getText();
        }

        StringBuilder sb = new StringBuilder();

        if (view.getBall() != 0) {
            sb.append(view.getBall());
            sb.append(BaseballTextType.BALL.getText());
        }

        if (view.getBall() != 0 && view.getStrike() != 0) {
            sb.append(" ");
        }

        if (view.getStrike() != 0) {
            sb.append(view.getStrike());
            sb.append(BaseballTextType.STRIKE.getText());
        }

        if (view.getBall() == 0 && view.getStrike() == 0) {
            sb.append(BaseballTextType.NOTHING.getText());
        }

        return sb.toString();
    }


    public void display(BaseballTextType announcement) {
        BaseballView message = BaseballView
                .messagebuilder()
                .announcement(announcement)
                .build();

        render(message);
    }

    public void display(int ball, int strike) {
        BaseballView message = BaseballView
                .messagebuilder()
                .ball(ball)
                .strike(strike)
                .build();

        render(message);
    }
}
