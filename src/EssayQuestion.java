public class EssayQuestion
        implements Question {

    private String text;
    private int points;
    private String difficulty;

    public EssayQuestion(String text, int points,String difficulty) {

        this.text = text;
        this.points = points;
        this.difficulty = difficulty;
    }

    public String getText() {
         return text;
    }

    @Override
    public String getType() {
        return "Essay";
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

 class EssayEvaluator implements QuestionEvaluator {

    @Override
    public int evaluate(Question q, String answer) {

        if (answer.length() >= 50) {
            return q.getPoints();
        }

        return q.getPoints() / 2;
    }
}

 class EssayFactory implements QuestionFactory {

    private QuestionSource source;

    public EssayFactory(QuestionSource source) {
        this.source = source;
    }

    @Override
    public Question createQuestion() {
        return source.getQuestion();
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new EssayRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new EssayEvaluator();
    }
}

class EssayRenderer
        extends BaseRenderer {
}