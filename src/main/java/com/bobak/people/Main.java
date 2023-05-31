package com.bobak.people;

public class Main {


    public static void main(String[] args) {
        Man john = new Man("John", "Smith", 23);
        Woman lily = new Woman("Lily", "Potter", 25);

        System.out.println(john.getFirstName() + " " + john.getLastName());
        System.out.println(lily.getFirstName() + " " + lily.getLastName());

        john.registerPartnership(lily);
        lily.registerPartnership(john);



        System.out.println("John's partner is " + john.getPartner().getFirstName() + " " + john.getPartner().getLastName());
        System.out.println("Lily's partner is " + lily.getPartner().getFirstName() + " " + lily.getPartner().getLastName());

        john.deregisterPartnership(true);
        System.out.println("John's partner name after deregistration is " + lily.getFirstName() + " " + lily.getLastName());
        System.out.println("Lily's partner name after deregistration is " + john.getFirstName() + " " + john.getLastName());
    }
}
