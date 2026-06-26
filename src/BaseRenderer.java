public abstract class BaseRenderer implements QuestionRenderer {

    @Override
    public void render(Question q) {
        System.out.printf("  - [Type: %-15s Points: %-4d Difficulty: %s%n",
                q.getType() + "]",
                q.getPoints(),
                q.getDifficulty());
    }
}