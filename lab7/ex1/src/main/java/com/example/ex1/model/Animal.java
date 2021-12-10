package com.example.ex1.model;

public class Animal {
    private Integer id;
    private String nume;
    private String culoare;

    public Animal() {
    }

    public Animal(String nume, String culoare) {
        this.nume = nume;
        this.culoare = culoare;
    }

    public Animal(Integer id, String nume, String culoare) {
        this.id = id;
        this.nume = nume;
        this.culoare = culoare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
}
