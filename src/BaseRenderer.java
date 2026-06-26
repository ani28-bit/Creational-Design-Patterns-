abstract class BaseRenderer implements QuestionRenderer {

    @Override
    public void render(Question q) {

        System.out.println(
                "- [Type: "
                        + q.getType()
                        + "] Points: "
                        + q.getPoints()
                        + " Difficulty: "
                        + q.getDifficulty()
        );
    }
}