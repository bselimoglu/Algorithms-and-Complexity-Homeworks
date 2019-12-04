package bilgin_selimoglu_hw1;

public class Student {

    int age;
    long ID;
    int admYear;
    String name;
    String surname;

    public Student(long ID, int age, int admYear, String name, String surname) {
        this.age = age;
        this.ID = ID;
        this.admYear = admYear;
        this.name = name;
        this.surname = surname;
    }

    public String toString() {
        return ID + " " + name + " " + surname + " " + age + " " + admYear;
    }
}
