-- Create Database

CREATE DATABASE PhotographyDB
GO
USE PhotographyDB
GO

-- Create Tables

CREATE TABLE Member (
    MemberID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Name varchar(50) NOT NULL,
	Username varchar(30) NOT NULL,
	Password varchar(30) NOT NULL,
    PhoneNumber varchar(20) NOT NULL,
    Address varchar(255) NOT NULL,
    Email varchar(300) NOT NULL,
    MemberType int
);

CREATE TABLE Photo (
    PhotoID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    AlbumID int NOT NULL,
    LocationID int NOT NULL,
    MemberID int NOT NULL,
    Title varchar(220) NOT NULL,
    Description varchar(300) NOT NULL,
    UploadDate DateTime NOT NULL,
	ImagePath varbinary(max) NOT NULL,
    FOREIGN KEY (MemberID) REFERENCES Member(MemberID)
);

CREATE TABLE Album (
    AlbumID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Title varchar(120) NOT NULL
);

CREATE TABLE Location (
    LocationID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Name varchar(200) NOT NULL
);
GO


-- View Members
SELECT * FROM Member;

-- View Photos
SELECT * FROM Photo;

-- View Sessions
SELECT * FROM Session;
GO

CREATE PROCEDURE InsertPhoto
    @AlbumID INT, 
    @LocationID INT, 
    @MemberID INT, 
    @Title NVARCHAR(100), 
    @Description NVARCHAR(500), 
    @ImagePath VARBINARY(MAX) 
AS 
BEGIN 
    INSERT INTO Photo (AlbumID, LocationID, MemberID, Title, Description, UploadDate, ImagePath) 
    VALUES (@AlbumID, @LocationID, @MemberID, @Title, @Description, GETDATE(), @ImagePath); 
END
GO

CREATE PROCEDURE EditPhoto
    @AlbumID INT, 
    @LocationID INT, 
    @MemberID INT, 
    @Title NVARCHAR(100), 
	@EditedTitle NVARCHAR(100), 
    @Description NVARCHAR(500)
AS 
BEGIN 
    UPDATE Photo 
    SET AlbumID = @AlbumID, 
        LocationID = @LocationID, 
		Title = @EditedTitle,
        Description = @Description
    WHERE MemberID = @MemberID AND Title = @Title; 
END
GO

CREATE PROCEDURE CreateAlbumIfNotExists
    @Title NVARCHAR(100),
    @AlbumID INT OUTPUT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Album WHERE Title = @Title)
    BEGIN
        INSERT INTO Album (Title)
        VALUES (@Title);
        
        SET @AlbumID = SCOPE_IDENTITY();
    END
    ELSE
    BEGIN
        SET @AlbumID = (SELECT AlbumID FROM Album WHERE Title = @Title);
    END
END
GO

CREATE PROCEDURE CreateLocationIfNotExists
    @Name NVARCHAR(100),
    @LocationID INT OUTPUT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Location WHERE Name = @Name)
    BEGIN
        INSERT INTO Location (Name)
        VALUES (@Name);
        
        SET @LocationID = SCOPE_IDENTITY();
    END
    ELSE
    BEGIN
        SET @LocationID = (SELECT LocationID FROM Location WHERE Name = @Name);
    END
END
GO

CREATE PROCEDURE RemovePhoto
    @MemberID INT,
    @Title NVARCHAR(100)
AS
BEGIN
    DELETE FROM Photo
    WHERE MemberID = @MemberID AND Title = @Title;
END
GO

--Stored Procedure for booking that retreives the emails of users with member type 2 professionals 

CREATE PROCEDURE GetProfessionalEmails
AS
BEGIN
    SELECT Email
    FROM Member
    WHERE MemberType = 2;
END
GO