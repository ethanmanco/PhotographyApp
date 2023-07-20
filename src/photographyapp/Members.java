package photographyapp;

/**
 *
 * @author Ethan
 */

public class Members {
    private int id;
    private String name;
    private String phonenumber;
    private String address;
    private String email;
    private int membertype;
    
    public Members(){}
    
    public Members(int MemberID, String Name, String PhoneNumber, String Address, 
            String Email, int MemberType){
    
        this.id = MemberID;
        this.name = Name;
        this.phonenumber = PhoneNumber;
        this.address = Address;
        this.email = Email;
        this.membertype = MemberType;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int MemberID){
        this.id = MemberID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String Name){
        this.name = Name;
    }
    
    public String getPhoneNumber(){
        return phonenumber;
    }
    
    public void setPhoneNumber(String PhoneNumber){
        this.phonenumber = PhoneNumber;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String Address){
        this.address = Address;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String Email){
        this.email = Email;
    }
    
    public int getMemberType(){
        return membertype;
    }
    
    public void setMemberType(int MemberType){
        this.membertype = MemberType;
    }
}
