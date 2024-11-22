package upload_package;

import java.util.*;  

import java.sql.*;  
  
public class uploadDao{  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/video", "root", "20020529");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(upload e){  
        int status=0;  
        try{  
            Connection con=uploadDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into upload(user,videoLink,title,category,tags,videoLength,publishDate) values (?,?,?,?,?,?,?)");  
            ps.setString(1,e.getUser());  
            ps.setString(2,e.getVideoLink());  
            ps.setString(3,e.getTitle());  
            ps.setString(4,e.getCategory());
            ps.setString(5,e.getTags());
            ps.setString(6,e.getVideoLength());
            ps.setString(7,e.getPublishDate());
            
            
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(upload e){  
        int status=0;  
        try{  
            Connection con=uploadDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update upload set user=?,videoLink=?,title=?,category=?,tags=?,videoLength=?,publishDate=? where id=?");  
            ps.setString(1,e.getUser());  
            ps.setString(2,e.getVideoLink());  
            ps.setString(3,e.getTitle());  
            ps.setString(4,e.getCategory());
            ps.setString(5,e.getTags());
            ps.setString(6,e.getVideoLength());
            ps.setString(7,e.getPublishDate());
            ps.setInt(8,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=uploadDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from upload where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static upload getUploadById(int id){  
        upload e=new upload();  
          
        try{  
            Connection con=uploadDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from upload where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setUser(rs.getString(2)); 
                e.setVideoLink(rs.getString(3));  
                e.setTitle(rs.getString(4));  
                e.setCategory(rs.getString(5));  
                e.setTags(rs.getString(6));  
                e.setVideoLength(rs.getString(7));  
                e.setPublishDate(rs.getString(8));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<upload> getAllUpload(){  
        List<upload> list=new ArrayList<upload>();  
          
        try{  
            Connection con=uploadDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from upload");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                upload e=new upload();  
                e.setId(rs.getInt(1));  
                e.setUser(rs.getString(2));  
                e.setVideoLink(rs.getString(3));  
                e.setTitle(rs.getString(4));  
                e.setCategory(rs.getString(5));
                e.setTags(rs.getString(6)); 
                e.setVideoLength(rs.getString(7)); 
                e.setPublishDate(rs.getString(8)); 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}