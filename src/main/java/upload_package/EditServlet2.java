package upload_package;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String user=request.getParameter("user");  
        String videoLink=request.getParameter("videoLink");  
        String title=request.getParameter("title");  
        String category=request.getParameter("category");  
        String tags=request.getParameter("tags");  
        String videoLength=request.getParameter("videoLength");  
        String publishDate=request.getParameter("publishDate");  


          
        upload e=new upload();  
        e.setId(id);  
        e.setUser(user);  
        e.setVideoLink(videoLink);  
        e.setTitle(title);  
        e.setCategory(category);  
        e.setTags(tags);  
        e.setVideoLength(videoLength);  
        e.setPublishDate(publishDate);  
          
        int status=uploadDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}