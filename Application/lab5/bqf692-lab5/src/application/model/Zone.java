package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Zone {
    String name;
    String threatLevel;
    String zodeCode;
    ArrayList<Zone> zones = new ArrayList<Zone>();

    public Zone(){
    }

    public Zone(String zodeCode){
        this.zodeCode = zodeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZodeCode() {
        return zodeCode;
    }

    public void setZodeCode(String zodeCode) {
        this.zodeCode = zodeCode;
    }

    public String getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(String threatLevel) {
        this.threatLevel = threatLevel;
    }

    public String toString(){
        return zodeCode;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = this.getZodeCode().equals(obj);
        return result;
    }

    @Override
    public int hashCode() {
        return zodeCode.hashCode();
    }

    public ArrayList<Zone> readInfo() throws FileNotFoundException {
        URL url = getClass().getResource("../data/zones.csv");
        Scanner scanner = new Scanner(new File(url.getPath()));
        scanner.useDelimiter(Pattern.compile("[\n|,]"));
        int i = 0;
        while (scanner.hasNext()){
            zones.add(new Zone());
            zones.get(i).setName(scanner.next());
            zones.get(i).setThreatLevel(scanner.next());
            zones.get(i).setZodeCode(scanner.next());
            i++;
        }
        return zones;
    }

}
