package week3.role;

import week3.policy.LionPolicy;
import week3.policy.Policy;

public class Lion extends Base {

    private String studentID;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Lion(String name, String major, int generation, String part, String studentID) {
        super(name, major, generation, part);
        this.studentID = studentID;
    }

    @Override
    Policy getPolicy() {
        return new LionPolicy();
    }

    @Override
    public String getInfo() {
        return "역할: 아기사자 \n 이름: " + getName() + "\n 전공: " + getMajor() + "\n 기수: "
                + getGeneration() + "\n 파트: " + getPart() + "\n 학번: " + getStudentID();
    }
}
