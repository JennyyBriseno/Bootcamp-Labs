package org.example;

import javax.sound.midi.Soundbank;
import javax.swing.*;

public class cellPhone {
    int serialNumber;
    String model;
    String carrier;
    String phoneNumber;
    String owner;

    //DIAL METHOD
    public void dial(String owner,String phoneNumber){
        System.out.println(owner + " phone is calling " + phoneNumber);
    }
    public void dial(cellPhone phone){
        System.out.println("You are calling " + phoneNumber);
    }

    //Parameterless Constructor
    public cellPhone(){
        this.serialNumber = 0;
        this.model =  "";
        this.carrier = "";
        this.phoneNumber = "";
        this.owner  = "";
    }
    public cellPhone(int serialNumber, String model, String carrier, String phoneNumber, String owner){
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}