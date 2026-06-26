public class TrueFalseQuestion implements Question {

    private String text;
    private int points;
    private String difficulty;

    public TrueFalseQuestion(String text, int points, String difficulty) {

        this.text = text;
        this.points = points;
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getType() {
        return "True/False";
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

class TrueFalseRenderer extends BaseRenderer {

}

 class TrueFalseEvaluator implements QuestionEvaluator {

    @Override
    public int evaluate(Question q, String answer) {

        if (answer.equalsIgnoreCase("true") || answer.equalsIgnoreCase("false")) {
               return q.getPoints();
        }

        return 0;
    }
}

 class TrueFalseFactory implements QuestionFactory {

    private QuestionSource source;

    public TrueFalseFactory(QuestionSource source) {
         this.source = source;
    }

    @Override
    public Question createQuestion() {
        return source.getQuestion();
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new TrueFalseRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new TrueFalseEvaluator();
    }
}