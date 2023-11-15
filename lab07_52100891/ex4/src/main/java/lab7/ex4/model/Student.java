package lab7.ex4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter @Getter
@Entity
public class Student {
    @Id
    private long id;
    private String name;
    private int age;
    private String email;

    private double score;
    public Student(long id, String name, int age, String email, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", score=" + score +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
