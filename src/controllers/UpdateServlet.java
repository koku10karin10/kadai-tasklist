package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasklist;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //CSRF対策
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            //セッションスコープからタスクのIDを取得して
            //IDが該当するタスクを１件取得する
            Tasklist tl = em.find(Tasklist.class, (Integer)(request.getSession().getAttribute("task_id")));


            //formの内容でデータベースの内容を上書き
            String content = request.getParameter("content");
            tl.setContent(content);

            //更新日時のみ更新
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            tl.setUpdated_at(currentTime);

            //データベースを更新
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            //セッションスコープのデータを削除
            request.getSession().removeAttribute("task_id");

            //indexへ
            response.sendRedirect(request.getContextPath() + "/index");


        }






    }

}
