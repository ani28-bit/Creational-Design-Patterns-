public class FakerQuestionSource implements QuestionSource {
    private String type;

    public FakerQuestionSource(String type) {
        this.type = type;
    }

    @Override
    public Question getQuestion() {
        switch (type) {
            case "MCQ":
                return new MCQQuestion("Auto Generated MCQ", 2, "Easy");
            case "Essay":
                return new EssayQuestion("Auto Generated Essay", 10, "Medium");
            case "Programming":
                return new ProgrammingQuestion("Auto Generated Coding Problem", 20, "Hard");
            case "TrueFalse":
                return new TrueFalseQuestion("Auto Generated True/False", 1, "Easy");
            default:
                return null;
        }
    }
}
