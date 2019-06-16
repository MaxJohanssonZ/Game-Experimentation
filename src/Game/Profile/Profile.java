package Game.Profile;

import java.util.List;
import java.util.Stack;

public class Profile {
    int profileID;
    String username;
    String firstName;
    String lastName;
    int point;
    List<Character> characterList;
    Stack<Integer> prevPoints;

    public Profile(String username, String firstName, String lastName, int point) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.point = point;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public Stack<Integer> getPrevPoints() {
        return prevPoints;
    }
}
