package com.mealgo.servlets;

import java.io.IOException;
import java.util.List;

import com.mealgo.DAPImple.MenuDAOImple;
import com.mealgo.Model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callMenuServlet")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MenuDAOImple mdo = new MenuDAOImple();

        List<Menu> menuList = mdo.getAllMenus();

        req.setAttribute("menuList", menuList);

        RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
        rd.forward(req, resp);
    }
}