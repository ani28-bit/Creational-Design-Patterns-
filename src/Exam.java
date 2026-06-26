public interface Exam {
    String getType();
    void displayInfo();
}

abstract class ExamFactory {
    public abstract Exam createExam();
    public void renderExam() {
        Exam exam = createExam();
        exam.displayInfo();
    }
}

class PracticeQuiz implements Exam {
    public String getType() {
        return "Practice Quiz";
    }

    public void displayInfo() {
        System.out.println("Practice Quiz Created");
    }
}

 class PracticeQuizFactory extends ExamFactory {
    public Exam createExam() {
        return new PracticeQuiz();
    }
}

class MidtermExam implements Exam {
    public String getType() {
        return "Midterm Exam";
    }

    public void displayInfo() {
        System.out.println("Midterm Exam Created");
    }
}

class MidtermExamFactory extends ExamFactory {
    public Exam createExam() {
        return new MidtermExam();
    }
}


class FinalExam implements Exam {
    public String getType() {
        return "Final Exam";
    }

    public void displayInfo() {
        System.out.println("Final Exam Created");
    }
}
 class FinalExamFactory extends ExamFactory {
    public Exam createExam() {
        return new FinalExam();
    }
}