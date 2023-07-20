package photographyapp;

/**
 *
 * @author Ethan
 */

public class Albums {
    private int id;
    private String title;
    
    public Albums(){}
    
    public Albums(int AlbumID, String Title){
    
        this.id = AlbumID;
        this.title = Title;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int AlbumID){
        this.id = AlbumID;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String Title){
        this.title = Title;
    }
}
