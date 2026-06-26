public class MCQQuestion implements Question {

    private String text;
    private int points;
    private String difficulty;

    public MCQQuestion(String text, int points, String difficulty) {

        this.text = text;
        this.points = points;
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getType() {
        return "MCQ";
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }
}