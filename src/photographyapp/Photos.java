package photographyapp;

import java.time.LocalDateTime;

/**
 *
 * @author Ethan
 */

public class Photos {
    private int id;
    private int album;
    private int location;
    private int member;
    private String title;
    private String description;
    private LocalDateTime uploadDate;
    private byte[] imagePath;
    
    public Photos(){}
    
    public Photos(int PhotoID, int AlbumID, int LocationID, int MemberID, String Title, 
            String Description, LocalDateTime UploadDate, byte[] ImagePath){
    
        this.id = PhotoID;
        this.album = AlbumID;
        this.location = LocationID;
        this.member = MemberID;
        this.title = Title;
        this.description = Description;
        this.uploadDate = UploadDate;
        this.imagePath = ImagePath;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int PhotoID){
        this.id = PhotoID;
    }
    
    public int getAlbum(){
        return album;
    }
    
    public void setAlbum(int AlbumID){
        this.album = AlbumID;
    }
    
    public int getLocation(){
        return location;
    }
    
    public void setLocation(int LocationID){
        this.location = LocationID;
    }
    
    public int getMember(){
        return member;
    }
    
    public void setMember(int MemberID){
        this.member = MemberID;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String TitleID){
        this.title = TitleID;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String Description){
        this.description = Description;
    }
    
    public LocalDateTime getUploadDate(){
        return uploadDate;
    }
    
    public void setUploadDate(LocalDateTime UploadDate){
        this.uploadDate = UploadDate;
    }
    
    public byte[] getImagePath(){
        return imagePath;
    }
}
