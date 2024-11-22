package upload_package;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='default.html'>Add New Videos</a>");  
        out.println("<h1>Videos List</h1>");  
          
        List<upload> list=uploadDao.getAllUpload();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>User</th><th>videoLink</th><th>Title</th><th>Category</th><th>Tags</th><th>videoLength</th><th>PublishDate</th><th>Delete</th></tr>");  
        for(upload e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getUser()+"</td><td>"+e.getVideoLink()+"</td><td>"+e.getTitle()+"</td><td>"+e.getCategory()+"</td><td>"+e.getTags()+"</td><td>"+e.getVideoLength()+"</td><td>"+e.getPublishDate()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}