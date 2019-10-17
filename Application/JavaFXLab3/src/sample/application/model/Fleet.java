package sample.application.model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Fleet {
    // have all the getter, setter
    // method ReadDataFromFile() is most important
    String name;
    ArrayList<Starship> starships = new ArrayList<Starship>();
    CrewMember crewMember = new CrewMember();
    String paragraph;

    public Fleet(){
    }

    public String getVarStarshipName(int i){
        return starships.get(i).getName();
    }

    public int getVarNumberOfStarships(){
        return starships.size();
    }
    public String getStarshipName(int i){
        paragraph = "" + starships.get(i).getName() + " ";
        return paragraph;
    }

    public String getRegisry(int i){
        paragraph = "[" + starships.get(i).getRegistry() + "], ";
        return paragraph;
    }

    public String getStarshipClass(int i){
        paragraph = "Class: " + starships.get(i).getStarshipClass() + ", ";
        return paragraph;
    }

    public String getCrewNumber(int i){
        paragraph = "Crew: " + this.starships.get(i).crewMembers.size();
        return paragraph;
    }

    public String getAllCrews(int i){
        paragraph = "\n";

        for(int j = 0; j < this.starships.get(i).crewMembers.size(); j++){
            paragraph +=
                    " - " +
                            starships.get(i).crewMembers.get(j).getRank() + " " +
                            starships.get(i).crewMembers.get(j).getName() + ", " +
                            starships.get(i).crewMembers.get(j).getPosition() + " (" +
                            starships.get(i).crewMembers.get(j).getSpecies() + ") " +
                            "\n"
            ;
        }
        return paragraph;
    }


    ArrayList<Starship> getStarshipByName(String name){
        return starships;
    }

    public void readDataFromFile() throws FileNotFoundException {
        ArrayList<String> arrayList = new ArrayList<String>();

        // read everything from fleet.csv to scnr
        Scanner scnr = new Scanner(new File("/Users/nguyenduyvu/eclipse-workspace/JavaFXLab3/src/sample/fleet.csv"));
        scnr.useDelimiter(Pattern.compile(" [\n|,] "));

        int i = 0;
        while(scnr.hasNext()) {
            starships.add(new Starship());
            starships.get(1).setName(scnr.next());
            starships.get(1).setRegistry(scnr.next());
            starships.get(1).setStarshipClass(scnr.next());
//            System.out.println(scnr.next());

            i++;
        }

        // read everything from personnel.csv to scnr1
        Scanner scnr1 = new Scanner(new File("/Users/nguyenduyvu/eclipse-workspace/JavaFXLab3/src/sample/personnel.csv"));
        scnr1.useDelimiter(Pattern.compile("[\n|,]"));
        i = 0;
        ArrayList<CrewMember> crewMembersTemp = new ArrayList<CrewMember>();
        while(scnr1.hasNext()) {
            crewMembersTemp.add(new CrewMember());
            crewMembersTemp.get(i).setName(scnr1.next());
            crewMembersTemp.get(i).setRank(scnr1.next());
            crewMembersTemp.get(i).setPosition(scnr1.next());
            crewMembersTemp.get(i).setRegistry(scnr1.next());
            crewMembersTemp.get(i).setSpecies(scnr1.next());

            i++;
        }

        // run 2 for-loops, if it is matched registry
        // then add it that crew member to starship
         for(int a = 0; a < starships.size(); a++){
            for(int b = 0; b < crewMembersTemp.size(); b++ ){
                if(starships.get(a).getRegistry().equals( crewMembersTemp.get(b).getRegistry() )){
                    starships.get(a).crewMembers.add(crewMembersTemp.get(b));
                }
            }
         }

        this.starships = starships;
    }
}
