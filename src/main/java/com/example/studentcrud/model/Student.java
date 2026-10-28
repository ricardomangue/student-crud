package com.example.studentcrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private String rollNo;

    // PROBLEMA 7: sem @NotBlank / @Size
    private String name;

    // PROBLEMA 8: sem @Min / @Max (aceita semestre negativo ou 999)
    private int semester;

    // PROBLEMA 9: double para CGPA (precisão)
    private double cgpa;

    // PROBLEMA 10: sem validação de formato de telefone
    private String phoneNumber;

    // PROBLEMA 11: getters/setters manuais (sugestão: Lombok/record)
    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
