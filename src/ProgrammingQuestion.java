public class ProgrammingQuestion implements Question {

    private String text;
    private int points;
    private String difficulty;

    public ProgrammingQuestion(String text, int points, String difficulty) {

        this.text = text;
        this.points = points;
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getType() {
        return "Programming";
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

class ProgrammingRenderer extends BaseRenderer {

}

class ProgrammingEvaluator implements QuestionEvaluator {

    @Override
    public int evaluate(Question q, String answer) {

        if (answer.contains("class") || answer.contains("public")) {

             return q.getPoints();
        }

        return 0;
    }
}


 class ProgrammingFactory implements QuestionFactory {

    private QuestionSource source;

    public ProgrammingFactory(QuestionSource source) {
        this.source = source;
    }

    @Override
    public Question createQuestion() {
         return source.getQuestion();
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new ProgrammingRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new ProgrammingEvaluator();
    }
}