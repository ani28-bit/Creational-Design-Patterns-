import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        ExamFactory examFactory = new MidtermExamFactory();
        Exam exam = examFactory.createExam();

        QuestionFactory mcqFactory1  = new MCQFactory(new BankQuestionSource("MCQ_MEDIUM"));
        QuestionFactory mcqFactory2  = new MCQFactory(new BankQuestionSource("MCQ_EASY"));
        QuestionFactory essayFactory = new EssayFactory(new BankQuestionSource("Essay"));
        QuestionFactory tfFactory    = new TrueFalseFactory(new BankQuestionSource("TrueFalse"));
        QuestionFactory progFactory  = new ProgrammingFactory(new BankQuestionSource("Programming"));


        ExamConfiguration config = new ExamBuilder()
                        .setTitle("OOP Midterm Exam")
                        .setDuration(60)
                        .setPassingScore(50)
                        .enableNegativeMarking()
                        .enableShuffle()
                        .enableAutoSubmit()
                        .build();


        System.out.println("=====================================================================");
        System.out.println("EXAM CREATED SUCCESSFULLY");
        System.out.println("=====================================================================");
        System.out.println("Type: " + exam.getType());
        System.out.println("Title: " + config.getTitle());
        System.out.println("Duration: " + config.getDuration() + " minutes");
        System.out.println("Passing Score: " + config.getPassingScore() + " Marks");

        System.out.println();
        System.out.println("Configuration Profiles:");
        System.out.println(config.isNegativeMarking()
                ? "✓ Negative Marking Enabled"
                : "✗ Negative Marking Disabled");
        System.out.println(config.isQuestionShuffle()
                ? "✓ Question Shuffle Activated"
                : "✗ Question Shuffle Disabled");
        System.out.println(config.isCalculatorAllowed()
                ? "✓ Embedded Calculator Allowed"
                : "✗ Embedded Calculator Allowed");
        System.out.println(config.isAutoSubmit()
                ? "✓ Auto-Submit On Timeout"
                : "✗ Auto-Submit Disabled");

        System.out.println();
        System.out.println("Question Sourcing Strategy: Question Bank Mode");
        System.out.println();
        System.out.println("Compiled Structural Components:");

        List<QuestionFactory> factories = new ArrayList<>();
        factories.add(mcqFactory1);
        factories.add(mcqFactory2);
        factories.add(essayFactory);
        factories.add(progFactory);
        factories.add(tfFactory);

        for (QuestionFactory factory : factories) {
            Question q = factory.createQuestion();
            factory.createRenderer().render(q);
        }

        System.out.println("=====================================================================");
    }
}