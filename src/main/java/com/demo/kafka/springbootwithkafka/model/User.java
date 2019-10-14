package com.demo.kafka.springbootwithkafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "usettst12")
@Table(name = "usertst")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
//    @SequenceGenerator(name = "seq-gen", allocationSize = 1, initialValue = 50, sequenceName = "sequencegenerator")
    private String id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
