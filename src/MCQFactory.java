public class MCQFactory implements QuestionFactory {

    private QuestionSource source;

    public MCQFactory(QuestionSource source) {
         this.source = source;
    }

    @Override
    public Question createQuestion() {
        return source.getQuestion();
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new MCQRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new MCQEvaluator();
    }
}