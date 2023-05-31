package com.bobak.people;

public class Man extends Person {
    private Woman partner;

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public Woman getPartner() {
        return partner;
    }

    public void setPartner(Woman partner) {
        this.partner = partner;
    }

    public void registerPartnership(Woman woman) {
        if (partner != null) {
            partner.deregisterPartnership(true);
        }
        partner = woman;
        woman.setLastName(getLastName());
    }

    public void deregisterPartnership(boolean returnToPreviousLastName) {
        if (partner != null) {
            if (returnToPreviousLastName) {
                setLastName(partner.getLastName());
            }
            partner.setPartner(null);
            partner = null;
        }
    }

}
