package caio.systems.argontest;

public class FaqCardComponent {
    private int icon;
    private String questTitle;
    private String questAnswer;

    public FaqCardComponent(int icon, String questTitle, String questAnswer) {
        this.icon = icon;
        this.questTitle = questTitle;
        this.questAnswer = questAnswer;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getQuestTitle() {
        return questTitle;
    }

    public void setQuestTitle(String questTitle) {
        this.questTitle = questTitle;
    }

    public String getQuestAnswer() {
        return questAnswer;
    }

    public void setQuestAnswer(String questAnswer) {
        this.questAnswer = questAnswer;
    }

    @Override
    public String toString() {
        return this.questTitle;
    }
}
