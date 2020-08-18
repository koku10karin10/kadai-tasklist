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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        //show.jspから送られてくるパラメータから該当データを１件取得
        Tasklist tl = em.find(Tasklist.class, Integer.parseInt(request.getParameter("id")));

        //CSRF対策
        request.setAttribute("_token", request.getSession().getId());

        //リクエストスコープに取得したデータを格納して、edit.jspへ
        request.setAttribute("task", tl);
        System.out.println("Setcomplete");



        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/detailviews/edit.jsp");
        rd.forward(request, response);

    }

}
