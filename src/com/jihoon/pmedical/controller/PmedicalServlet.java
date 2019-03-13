package com.jihoon.pmedical.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihoon.pmedical.dao.PmedicalDao;
import com.jihoon.pmedical.vo.PmedicalVo;

@WebServlet("/pm")
public class PmedicalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	@Override
	public void init() throws ServletException {

		super.init();
		
		System.out.println("aa");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 한글깨짐 방지
		String action = request.getParameter("a");

		if ("add".equals(action)) {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String tel = request.getParameter("tel");
			String status = request.getParameter("status");

			PmedicalVo pv = new PmedicalVo();
			pv.setName(name);
			pv.setGender(gender);
			pv.setTel(tel);
			pv.setStatus(status);

			PmedicalDao pd = new PmedicalDao();
			pd.insert(pv);

			response.sendRedirect("/pmedical02-1/pm");

		} else if ("addform".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addform.jsp");
			rd.forward(request, response);
		} else if ("delete".equals(action)) {
			long no = Integer.parseInt(request.getParameter("no"));
			PmedicalVo pv = new PmedicalVo();
			pv.setNo(no);

			PmedicalDao pd = new PmedicalDao();
			pd.delete(pv);

			response.sendRedirect("/pmedical02-1/pm");
		} else if ("updateform".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/updateform.jsp");
			rd.forward(request, response);
		} else if ("update".equals(action)) {

			long no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String tel = request.getParameter("tel");
			String status = request.getParameter("status");

			PmedicalVo pv = new PmedicalVo();
			pv.setNo(no);
			pv.setName(name);
			pv.setGender(gender);
			pv.setTel(tel);
			pv.setStatus(status);
//			System.out.println(pv);

			PmedicalDao pd = new PmedicalDao();
			pd.update(pv);

			response.sendRedirect("/pmedical02-1/pm");
		} else {
			PmedicalDao pd = new PmedicalDao();
			List<PmedicalVo> list = pd.getList();

			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
