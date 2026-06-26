import java.util.Random;

public class BankQuestionSource implements QuestionSource {
    private String type;
    private Random random = new Random();

    public BankQuestionSource(String type) {
        this.type = type;
    }

    @Override
    public Question getQuestion() {
        switch (type) {
            case "MCQ":
                return random.nextBoolean()
                        ? new MCQQuestion("What is Java?", 2, "Medium")
                        : new MCQQuestion("What is Inheritance?", 2, "Easy");
            case "Essay":
                return new EssayQuestion("Explain OOP.", 10, "Hard");
            case "Programming":
                return new ProgrammingQuestion("Write factorial program.", 20, "Hard");
            case "TrueFalse":
                return new TrueFalseQuestion("Java is platform independent.", 1, "Easy");
            case "MCQ_MEDIUM":
                return new MCQQuestion("What is Java?", 2, "Medium");

            case "MCQ_EASY":
                return new MCQQuestion("What is Inheritance?", 2, "Easy");
            default:
                return null;
        }
    }
}