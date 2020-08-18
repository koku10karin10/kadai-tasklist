package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasklist;
import utils.DBUtil;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        //CSRF対策
        request.setAttribute("_token", request.getSession().getId());

        //index.jspから送られてくるパラメータの情報から該当データを１件取得する
        Tasklist tl = em.find(Tasklist.class, Integer.parseInt(request.getParameter("id")));

        em.close();
        //リクエストスコープに該当データを格納する
        if(tl != null){
            request.setAttribute("tl", tl);
        }


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/detailviews/show.jsp");
        rd.forward(request, response);



    }



}
