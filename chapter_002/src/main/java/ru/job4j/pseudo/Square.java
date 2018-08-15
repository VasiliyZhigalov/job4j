package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        String ln = System.lineSeparator();
        pic.append("++++");
        pic.append(ln);
        pic.append("+  +");
        pic.append(ln);
        pic.append("+  +");
        pic.append(ln);
        pic.append("++++");
        return pic.toString();
    }

}
