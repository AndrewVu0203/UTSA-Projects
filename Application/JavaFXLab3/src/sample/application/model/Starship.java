package sample.application.model;
import javax.xml.namespace.QName;
import java.util.ArrayList;

public class Starship {
    // all getters, setters for Starship
    String name;
    String registry;
    String starshipClass;
    ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();

    public Starship(){
    }

    public String getName() {
        return name;
    }

    public String getRegistry() {
        return registry;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }
}
