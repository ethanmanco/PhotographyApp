/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package photographyapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ethan
 */

public class MyQuery {
    public Connection getConnection() throws ClassNotFoundException{
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER01:1433;databaseName=PhotographyDB;encrypt=true;trustServerCertificate=true", "sa", "zelda");
        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Photos> BindPhotos() throws ClassNotFoundException{
        
        ArrayList<Photos> photoList = new ArrayList<>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT PhotoID, AlbumID, LocationID, MemberID, Title, Description, UploadDate, ImagePath FROM Photo ORDER BY PhotoID DESC");

            Photos p;
            while(rs.next()){
                p = new Photos(
                    rs.getInt("PhotoID"),
                    rs.getInt("AlbumID"),
                    rs.getInt("LocationID"),
                    rs.getInt("MemberID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getTimestamp("UploadDate").toLocalDateTime(),
                    rs.getBytes("ImagePath")
                );
                photoList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return photoList;
    }
    
    public ArrayList<Photos> BindProfilePhotos(int member) throws ClassNotFoundException{
        
        ArrayList<Photos> photoList = new ArrayList<>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT PhotoID, AlbumID, LocationID, MemberID, Title, Description, UploadDate, ImagePath FROM Photo WHERE MemberID = " + member + " ORDER BY PhotoID DESC");

            Photos p;
            while(rs.next()){
                p = new Photos(
                    rs.getInt("PhotoID"),
                    rs.getInt("AlbumID"),
                    rs.getInt("LocationID"),
                    rs.getInt("MemberID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getTimestamp("UploadDate").toLocalDateTime(),
                    rs.getBytes("ImagePath")
                );
                photoList.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return photoList;
    }
    
    public ArrayList<Members> BindMembers() throws ClassNotFoundException{
        
        ArrayList<Members> memberList = new ArrayList<>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT MemberID, Name, PhoneNumber, Address, Email, MemberType FROM Member");

            Members m;
            while(rs.next()){
                m = new Members(
                    rs.getInt("MemberID"),
                    rs.getString("Name"),
                    rs.getString("PhoneNumber"),
                    rs.getString("Address"),
                    rs.getString("Email"),
                    rs.getInt("MemberType")
                );
                memberList.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return memberList;
    }
    
    public ArrayList<Albums> BindAlbums() throws ClassNotFoundException{
        
        ArrayList<Albums> albumList = new ArrayList<>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT AlbumID, Title FROM Album");

            Albums a;
            while(rs.next()){
                a = new Albums(
                    rs.getInt("AlbumID"),
                    rs.getString("Title")
                );
                albumList.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albumList;
    }
    
    public ArrayList<Locations> BindLocations() throws ClassNotFoundException{
        
        ArrayList<Locations> locationList = new ArrayList<>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT LocationID, Name FROM Location");

            Locations l;
            while(rs.next()){
                l = new Locations(
                    rs.getInt("LocationID"),
                    rs.getString("Name")
                );
                locationList.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locationList;
    }
}
