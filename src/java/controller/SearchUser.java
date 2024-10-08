/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Country;
import model.HibernateUtil;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author chand
 */
@WebServlet(name = "SearchUser", urlPatterns = {"/SearchUser"})
public class SearchUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

//        Criteria criteria = session.createCriteria(User.class);
//        ArrayList<User> userList = (ArrayList<User>) criteria.list();
//
//        for (User user : userList) {
//            System.out.println(user.getId());
//            System.out.println(user.getName());
//            System.out.println(user.getMobile());
//            System.out.println(user.getCountry().getName());

            Country country = (Country) session.load(Country.class,1);
            
            ArrayList<User> userList = country.getUserList();
            
            for (User user : userList) {
                System.out.println(user.getName());
            
            }

            session.close();

        }

    } 
