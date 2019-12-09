package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CrewMember {
    String name;
    String position;
    String rank;
    String registry;
    String species;
    String lastName;
    String urlImage;
    ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public ArrayList<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(ArrayList<CrewMember> crewMembers) {
        this.crewMembers = crewMembers;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    // read all info from personnel.csv
    public ArrayList<CrewMember> readInfo() throws FileNotFoundException {
        URL url = getClass().getResource("../data/personnel.csv");
        Scanner scanner = new Scanner(new File(url.getPath()));

        scanner.useDelimiter(Pattern.compile("[\n|,]"));
        int i = 0;
        while (scanner.hasNext()){
            crewMembers.add(new CrewMember());
            crewMembers.get(i).setName(scanner.next());
            crewMembers.get(i).setPosition(scanner.next());
            crewMembers.get(i).setRank(scanner.next());
            crewMembers.get(i).setRegistry(scanner.next());
            crewMembers.get(i).setSpecies(scanner.next());
            crewMembers.get(i).setLastName(crewMembers.get(i).getName().substring(crewMembers.get(i).getName().lastIndexOf(" ")+ 1));
            crewMembers.get(i).setUrlImage("application/images/" + crewMembers.get(i).getLastName().toLowerCase() + ".jpg");

            if(crewMembers.get(i).getUrlImage().equals("application/images/forge.jpg")){
                crewMembers.get(i).setUrlImage("application/images/la forge.jpg");
            }
            if(crewMembers.get(i).getUrlImage().equals("application/images/sulu.jpg")){
                crewMembers.get(i).setUrlImage("application/images/sulu.jpeg");
            }

            i++;
        }
        return crewMembers;

    }
}
