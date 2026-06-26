public interface Question {
    String getType();
    int getPoints();
    String getDifficulty();
}

interface QuestionRenderer {
    void render(Question q);
}

interface QuestionEvaluator {
    int evaluate(Question q, String answer);
}