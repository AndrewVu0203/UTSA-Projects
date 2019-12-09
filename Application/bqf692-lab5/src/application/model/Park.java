package application.model;

import application.controller.ZoneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Park {
    String name = "Jurassic";
    HashMap<Zone, ArrayList<Dinosaur>> hashMap = new HashMap<Zone, ArrayList<Dinosaur>>();
    ArrayList<Zone> zones = new ArrayList<Zone>();

    public Park(){}

    public HashMap<Zone, ArrayList<Dinosaur>> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Zone, ArrayList<Dinosaur>> hashMap) {
        this.hashMap = hashMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean relocate(String currentZone, String currentDinosaur, String targetZone, ObservableList<String> names) throws IOException {
            Dinosaur dinoTemp = new Dinosaur();
            Zone zoneTemp = new Zone();
            boolean currentDinosaurInput = false;
            boolean targetZoneInput = false;

            for (Zone zn : hashMap.keySet()) {
                for (Dinosaur dino : hashMap.get(zn)) {
                    if (dino.getNameDino().equals(currentDinosaur)) {
                        dinoTemp = dino;
                        zoneTemp = zn;
                        currentDinosaurInput = true;
                    }
                    if (zn.getZodeCode().equals(targetZone)) targetZoneInput = true;
                }
            }

            if(currentDinosaurInput == false || targetZoneInput == false){
                System.out.println("Inputs are either empty or not correct");
                return false;
            }

            hashMap.get(zoneTemp).remove(dinoTemp); // remove when iterating
            names.remove(dinoTemp.toString());

            for (Zone zn : hashMap.keySet()) {
                if (zn.zodeCode.equals(targetZone)) {
                    dinoTemp.setZone(targetZone);
                    hashMap.get(zn).add(dinoTemp);
                }
            }
            save();

        if(currentDinosaurInput == true && targetZoneInput == true){
            return true;
        }

        return false;
    }

    public void save() throws IOException {
        File file = new File("src/application/data/dinos.csv");
        try {
            FileWriter csvWriter = new FileWriter(file, false);
            for(Zone zn : hashMap.keySet()){
                for (Dinosaur dino : hashMap.get(zn)) {
                    csvWriter.append(dino.nameDino + ","
                                    + dino.getTypeDino() + ","
                                    + dino.isCarnivorous() + ","
                                    + dino.getZone() + "\n"
                    );
                }
            }

            csvWriter.flush();
            csvWriter.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Here Vu: " + e);
        }
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }

    public void setZones(ArrayList<Zone> zones) {
        this.zones = zones;
    }

    public String toString(){
        return null;
    }

    public void loadZones() throws FileNotFoundException {
        URL url = getClass().getResource("../data/zones.csv");
        Scanner scanner = new Scanner(new File(url.getPath()));
        scanner.useDelimiter(Pattern.compile("[\n|,]"));
        int i = 0;

        ArrayList<Zone> zones = new ArrayList<Zone>();
        while (scanner.hasNext()){
            zones.add(new Zone());
            zones.get(i).setName(scanner.next());
            zones.get(i).setThreatLevel(scanner.next());
            zones.get(i).setZodeCode(scanner.next());
            hashMap.put(zones.get(i), null);

            i++;
        }
        this.zones = zones;
    }

    public void loadDinosaurs() throws FileNotFoundException {
        // read files
        URL url = getClass().getResource("../data/dinos.csv");
        Scanner scanner = new Scanner(new File(url.getPath()));
        scanner.useDelimiter(Pattern.compile("[\n|,]"));
        int i = 0;


        ArrayList<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();
        while (scanner.hasNext()){
            dinosaurs.add(new Dinosaur());
            dinosaurs.get(i).setNameDino(scanner.next());
            dinosaurs.get(i).setTypeDino(scanner.next());
            dinosaurs.get(i).setCarnivorous(Boolean.parseBoolean(scanner.next()));
            dinosaurs.get(i).setZone(scanner.next());
            i++;
        }

        int j = 0;
        for(j = 0; j < zones.size(); j++){
            ArrayList<Dinosaur> dinosaursTemp = new ArrayList<Dinosaur>();
            for(i = 0; i < dinosaurs.size(); i++){
                if(dinosaurs.get(i).getZone().equals(zones.get(j).getZodeCode())) {
                    Dinosaur dinosaur = new Dinosaur(dinosaurs.get(i).getNameDino(),
                            dinosaurs.get(i).getTypeDino(),
                            dinosaurs.get(i).isCarnivorous(),
                            dinosaurs.get(i).getZone());

                    dinosaursTemp.add(dinosaur);
                }
                hashMap.put(zones.get(j), dinosaursTemp);
            }
        }

        for(Zone zn : hashMap.keySet()){
            for (Dinosaur dino : hashMap.get(zn)) {
                    System.out.println(dino.toString() + "-" + zn.toString());
            }
        }
        // this is where HashMap does not get updated even though we call it everytime

    }
}
