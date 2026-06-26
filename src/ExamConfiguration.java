public class ExamConfiguration {

    private String title;
    private int duration;
    private int passingScore;

    private boolean negativeMarking;
    private boolean questionShuffle;
    private boolean autoSubmit;
    private boolean calculatorAllowed;

    public ExamConfiguration(String title, int duration, int passingScore,
                             boolean negativeMarking, boolean questionShuffle,
                             boolean autoSubmit, boolean calculatorAllowed) {

        this.title = title;
        this.duration = duration;
        this.passingScore = passingScore;
        this.negativeMarking = negativeMarking;
        this.questionShuffle = questionShuffle;
        this.autoSubmit = autoSubmit;
        this.calculatorAllowed = calculatorAllowed;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getPassingScore() {
        return passingScore;
    }

    public boolean isNegativeMarking() {
        return negativeMarking;
    }

    public boolean isQuestionShuffle() {
        return questionShuffle;
    }

    public boolean isAutoSubmit() {
        return autoSubmit;
    }

    public boolean isCalculatorAllowed() {
        return calculatorAllowed;
    }

    @Override
    public String toString() {
        return "ExamConfiguration{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", passingScore=" + passingScore +
                ", negativeMarking=" + negativeMarking +
                ", questionShuffle=" + questionShuffle +
                ", autoSubmit=" + autoSubmit +
                ", calculatorAllowed=" + calculatorAllowed +
                '}';
    }
}
 class ExamBuilder {

    private String title;
    private int duration;
    private int passingScore;

    private boolean negativeMarking;
    private boolean questionShuffle;
    private boolean autoSubmit;
    private boolean calculatorAllowed;

    public ExamBuilder setTitle(String title) {

        this.title = title;
        return this;
    }

    public ExamBuilder setDuration(int duration) {

        this.duration = duration;
        return this;
    }

    public ExamBuilder setPassingScore(int passingScore) {

        this.passingScore =
                passingScore;
        return this;
    }

    public ExamBuilder enableNegativeMarking() {
        negativeMarking = true;
        return this;
    }

    public ExamBuilder enableShuffle() {
        questionShuffle = true;
        return this;
    }

    public ExamBuilder enableAutoSubmit() {
        autoSubmit = true;
        return this;
    }

    public ExamBuilder allowCalculator() {
        calculatorAllowed = true;
        return this;
    }

    public ExamConfiguration build() {

        return new ExamConfiguration(title, duration, passingScore,
                                     negativeMarking, questionShuffle,
                                     autoSubmit, calculatorAllowed);
    }
}