import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Atricle;
import com.neo.entity.Comment;
import com.neo.entity.Type;
import com.neo.entity.User;
import com.neo.service.articleService;
import com.neo.service.commentService;
import com.neo.service.typeService;
import com.neo.service.userService;

@WebServlet("/ArticleEdit")
public class artDisCtrl extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		if(userName != null){
			request.setAttribute("isAdmin", USER.getAdminUser());}
		
		
		typeService typeService = new typeService();
		List<Type> list = typeService.findAll(userName);
		
		request.setAttribute("typeList", list);
		request.getRequestDispatcher("/ArtEdit.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		if(userName != null){
			request.setAttribute("isAdmin", USER.getAdminUser());}
		
		
		Atricle art = new Atricle();
		
		art.setArtTitle(request.getParameter("artTitle"));
		art.setTypeId(Integer.parseInt(request.getParameter("typeId")));
		art.setContent(request.getParameter("content"));
		art.setUserName(userName);
		
		
		articleService artService = new articleService();
		
		art = artService.addA(art);
		System.out.println("setArtId"+art.getArtId());
		
		String type = artService.findType(Integer.parseInt(request.getParameter("typeId")));
		request.setAttribute("type", type);
		
		request.setAttribute("art", art);
		
		commentService comService = new commentService();
		List<Comment> list =  null;
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/ArtDisplay2.jsp").forward(request, response);
	}

}
