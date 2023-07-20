package photographyapp;

/**
 *
 * @author Ethan
 */

public class Locations {
    private int id;
    private String name;
    
    public Locations(){}
    
    public Locations(int LocationID, String Name){
    
        this.id = LocationID;
        this.name = Name;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int LocationID){
        this.id = LocationID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String Name){
        this.name = Name;
    }
}