import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Step 1: ExamFactory subclass instantiate
        ExamFactory examFactory = new MidtermExamFactory();
        Exam exam = examFactory.createExam();

        // Step 2: QuestionSource strategy declare
        QuestionSource mcqMediumSource = new BankQuestionSource("MCQ_MEDIUM");
        QuestionSource mcqEasySource   = new BankQuestionSource("MCQ_EASY");
        QuestionSource essaySource     = new BankQuestionSource("Essay");
        QuestionSource progSource      = new BankQuestionSource("Programming");
        QuestionSource tfSource        = new BankQuestionSource("TrueFalse");

        // Step 3: Abstract Factories initialize with source
        QuestionFactory mcqFactory1  = new MCQFactory(mcqMediumSource);
        QuestionFactory mcqFactory2  = new MCQFactory(mcqEasySource);
        QuestionFactory essayFactory = new EssayFactory(essaySource);
        QuestionFactory progFactory  = new ProgrammingFactory(progSource);
        QuestionFactory tfFactory    = new TrueFalseFactory(tfSource);

        // Step 4: ExamBuilder fluid API chain
        ExamConfiguration config = new ExamBuilder()
                .setTitle("OOP Midterm Exam")
                .setDuration(60)
                .setPassingScore(50)
                .enableNegativeMarking()
                .enableShuffle()
                .enableAutoSubmit()
                .build();

        // Step 5: Dashboard summary
        System.out.println("=====================================================================");
        System.out.println("                      EXAM CREATED SUCCESSFULLY");
        System.out.println("=====================================================================");
        System.out.println();
        System.out.printf("Type:           %s%n", exam.getType());
        System.out.printf("Title:          %s%n", config.getTitle());
        System.out.println();
        System.out.printf("Duration:       %d minutes%n", config.getDuration());
        System.out.printf("Passing Score:  %d Marks%n", config.getPassingScore());
        System.out.println();
        System.out.println("Configuration Profiles:");
        System.out.println(config.isNegativeMarking()
                ? "  ✓ Negative Marking Enabled"
                : "  ✗ Negative Marking Disabled");
        System.out.println(config.isQuestionShuffle()
                ? "  ✓ Question Shuffle Activated"
                : "  ✗ Question Shuffle Disabled");
        System.out.println(config.isCalculatorAllowed()
                ? "  ✓ Embedded Calculator Allowed"
                : "  ✗ Embedded Calculator Allowed");
        System.out.println(config.isAutoSubmit()
                ? "  ✓ Auto-Submit On Timeout"
                : "  ✗ Auto-Submit Disabled");
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