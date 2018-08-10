package ru.job4j.profession;

public class Ruble {
    public float ruble;
    private Ruble(float ruble){
        this.ruble=Math.round(ruble*100)/100;
    }
}
