package upload_package;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Videos</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        upload e=uploadDao.getUploadById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>User:</td><td><input type='text' name='user' value='"+e.getUser()+"'/></td></tr>");  
        out.print("<tr><td>Video Link:</td><td><input type='text' name='videoLink' value='"+e.getVideoLink()+"'/>  </td></tr>");  
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='"+e.getTitle()+"'/></td></tr>");  
        out.print("<tr><td>Category:</td><td>");  
        out.print("<select name='category' style='width:150px'>");  
        out.print("<option>Travel</option>");  
        out.print("<option>Comedy</option>");  
        out.print("<option>Music</option>");  
        out.print("<option>Educational</option>");
        out.print("<option>News</option>"); 
        out.print("<option>Politics</option>");
        out.print("<option>Nature</option>");  
        out.print("<option>Sports</option>");  
        out.print("</select>"); 
        out.print("<tr><td>Tags:</td><td><input type='text' name='tags' value='"+e.getTags()+"'/></td></tr>"); 
        out.print("<tr><td>VideoLength:</td><td><input type='text' name='videoLength' value='"+e.getVideoLength()+"'/></td></tr>");  
        out.print("<tr><td>PublishDate:</td><td><input type='text' name='publishDate' value='"+e.getPublishDate()+"'/></td></tr>");  


        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}
