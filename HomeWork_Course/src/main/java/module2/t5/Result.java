package module2.t5;

/**
 * Class for unique result for each combination of student-subject-rate.
 */
public class Result {
    private Student student;
    private Subject subject;
    private Number rate;

    public Result(Student student, Subject subject, Number rate) {
        this.student = student;
        this.subject = subject;
        this.rate = rate;
    }

    public Number getRate() {
        return rate;
    }

    public void setRate(Number rate) {
        this.rate = rate;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Result{" +
                "student=" + student.getName() +
                ", subject=" + subject.name() +
                ", rate=" + rate +
                "}";
    }
}
