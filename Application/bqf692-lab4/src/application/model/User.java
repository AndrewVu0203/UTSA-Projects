package application.model;

import application.Main;
import application.controller.LoginController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    String username;
    String password;
    ArrayList<User> users = new ArrayList<User>();
    String currentUser;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // read info from users.csv
    public void readInfo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/nguyenduyvu/eclipse-workspace/bqf692-lab4/src/application/data/users.csv"));
        scanner.useDelimiter(Pattern.compile("[\n|,]"));
        int i = 0;
        while (scanner.hasNext()){
            users.add(new User());
            users.get(i).setUsername(scanner.next());
            users.get(i).setPassword(scanner.next());
            i++;
        }
    }

    // check if username, password that users type have in our data
    public Boolean validate(String username, String password){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) return true;
            continue;
        }
        return false;
    }

    public void setCurrentUserName(String a){
        currentUser = a;
    }
    public String getCurrentUserName(){
        return currentUser;
    }

}
