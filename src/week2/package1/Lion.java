package week2.package1;

public class Lion {

    public String name;
    String specialty;
    private int corps;

    public Lion(String name, String specialty, int corps) {

        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비었습니다.");
        }
        else if(specialty.trim().isEmpty()) {
            throw new IllegalArgumentException("전공이 비어있습니다.");
        }
        else if(corps < 1) {
            throw new IllegalArgumentException("기수가 1 미만입니다.");
        }
        this.name = name;
        this.specialty = specialty;
        this.corps = corps;
    }
}
