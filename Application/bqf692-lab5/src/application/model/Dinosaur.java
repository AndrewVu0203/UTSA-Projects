package application.model;

import jdk.jshell.execution.JdiInitiator;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Dinosaur {
    String nameDino;
    String typeDino;
    boolean carnivorous;
    String zone;
    ArrayList<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();

    public Dinosaur(){}

    public Dinosaur(String nameDino, String typeDino, boolean carnivorous, String zone){
        this.nameDino = nameDino;
        this.typeDino = typeDino;
        this.carnivorous = carnivorous;
        this.zone = zone;
    }

    public String getNameDino() {
        return nameDino;
    }

    public void setNameDino(String nameDino) {
        this.nameDino = nameDino;
    }

    public String getTypeDino() {
        return typeDino;
    }

    public void setTypeDino(String typeDino) {
        this.typeDino = typeDino;
    }

    public boolean isCarnivorous() {
        return carnivorous;
    }

    public void setCarnivorous(boolean carnivorous) {
        this.carnivorous = carnivorous;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String toString(){
        return getNameDino() + "-" + getTypeDino() + "-" + (isCarnivorous()? "carnivore" : "no carnivore");
    }
}
