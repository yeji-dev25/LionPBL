package week3.role;

import week3.policy.Policy;

public abstract  class Base {

    private String name;
    private String major;
    private int generation;
    private String part;

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public Base(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    abstract Policy getPolicy();

    public boolean canSubmit() {
        return getPolicy().submitPolicy();
    }

    abstract public String getInfo();

}
