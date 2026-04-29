package week3.role;

import week3.policy.Policy;
import week3.policy.StaffPolicy;

public class Staff extends Base {

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    Policy getPolicy() {
        return new StaffPolicy();
    }

    @Override
    public String getInfo() {
        return "역할: 운영진 \n 이름: " + getName() + "\n 전공: " + getMajor() + "\n 기수: "
                + getGeneration() + "\n 파트: " + getPart() + "\n 직책: " + getPosition();
    }
}
