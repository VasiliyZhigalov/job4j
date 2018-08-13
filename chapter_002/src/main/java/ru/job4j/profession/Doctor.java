package ru.job4j.profession;

public class Doctor extends Profession {

    Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }

}
