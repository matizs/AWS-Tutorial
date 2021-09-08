package com.example.Tutorial.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TestTable")
@Getter
@Setter
public class TestModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
