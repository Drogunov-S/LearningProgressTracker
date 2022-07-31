package tracker.enitity.courses;

import java.util.Locale;

public abstract class Course implements Academic {

    private int grade;
    private int countSolution = 0;

    private boolean isComplete = false;

    private boolean isMassageCompleteSend = false;

    protected final int ballsComplete;

    public Course(int grade, int ballsComplete) {
        this.ballsComplete = ballsComplete;
        setGrade(grade);
    }

    public int getCountSolution() {
        return countSolution;
    }

    public void setMassageCompleteSend(boolean massageCompleteSend) {
        isMassageCompleteSend = massageCompleteSend;
    }

    @Override
    public void setGrade(int grade) {
        if (grade > 0) {
            countSolution++;
            if (grade >= ballsComplete) {
                isComplete = true;
            }
        }

        this.grade = grade;
    }

    public boolean isMassageCompleteSend() {
        return isMassageCompleteSend;
    }

    public String getCourseName() {
        String simpleName = this.getClass().getSimpleName();
        if (simpleName.equalsIgnoreCase("dsa")) {
            return simpleName.toUpperCase(Locale.ROOT);
        }
        return simpleName;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public int getBallsComplete() {
        return ballsComplete;
    }

    @Override
    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "=" + this.getGrade();
    }
}
