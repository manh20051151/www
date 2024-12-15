package com.example.week01_lab_nguyenvietmanh_20051151.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "ControlServlet", urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet {

    private String jdbcUrl = "jdbc:mariadb://localhost:3307/week01";
    private String jdbcUser = "root";
    private String jdbcPassword = "sapassword";
    private String jdbcDriver = "org.mariadb.jdbc.Driver";

    @Override
    public void init() throws ServletException {
        try {
            // Tải driver JDBC
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
            switch (action) {
                case "login":
                    handleLogin(request, response, connection);
                    break;
                case "addAccount":
                    addAccount(request, connection);
                    break;
                case "updateAccount":
                    updateAccount(request, connection);
                    break;
                case "deleteAccount":
                    deleteAccount(request, connection);
                    break;
                case "assignRole":
                    assignRole(request, connection);
                    break;
                case "viewRoles":
                    viewRoles(request, response, connection);
                    break;
                case "viewAccountsByRole":
                    viewAccountsByRole(request, response, connection);
                    break;
                case "logLogin":
                    logLogin(request, connection);
                    break;
                case "logLogout":
                    logLogout(request, connection);
                    break;
                default:
                    response.getWriter().write("Unknown action");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM account WHERE email = ? AND password = ?");
        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String accountId = rs.getString("account_id");
            request.getSession().setAttribute("accountId", accountId);
            request.getSession().setAttribute("isAdmin", isAdmin(connection, accountId));

            logLogin(request, connection);

            if (isAdmin(connection, accountId)) {
                response.sendRedirect("dashboard.jsp");
            } else {
                response.getWriter().write("Hello: " +accountId);
            }
        } else {
            response.getWriter().write("Login failed.");
        }
    }

    private boolean isAdmin(Connection connection, String accountId) throws Exception {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM grant_access WHERE account_id = ? AND role_id = 'admin'");
        ps.setString(1, accountId);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    private void addAccount(HttpServletRequest request, Connection connection) throws Exception {
        String accountId = request.getParameter("account_id");
        String fullName = request.getParameter("full_name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int status = Integer.parseInt(request.getParameter("status"));

        PreparedStatement ps = connection.prepareStatement("INSERT INTO account (account_id, full_name, password, email, phone, status) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setString(1, accountId);
        ps.setString(2, fullName);
        ps.setString(3, password);
        ps.setString(4, email);
        ps.setString(5, phone);
        ps.setInt(6, status);
        ps.executeUpdate();
    }

    private void updateAccount(HttpServletRequest request, Connection connection) throws Exception {
        String accountId = request.getParameter("account_id");
        String fullName = request.getParameter("full_name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int status = Integer.parseInt(request.getParameter("status"));

        PreparedStatement ps = connection.prepareStatement("UPDATE account SET full_name = ?, password = ?, email = ?, phone = ?, status = ? WHERE account_id = ?");
        ps.setString(1, fullName);
        ps.setString(2, password);
        ps.setString(3, email);
        ps.setString(4, phone);
        ps.setInt(5, status);
        ps.setString(6, accountId);
        ps.executeUpdate();
    }

    private void deleteAccount(HttpServletRequest request, Connection connection) throws Exception {
        String accountId = request.getParameter("account_id");

        PreparedStatement ps = connection.prepareStatement("DELETE FROM account WHERE account_id = ?");
        ps.setString(1, accountId);
        ps.executeUpdate();
    }

    private void assignRole(HttpServletRequest request, Connection connection) throws Exception {
        String accountId = request.getParameter("account_id");
        String roleId = request.getParameter("role_id");

        PreparedStatement ps = connection.prepareStatement("INSERT INTO grant_access (role_id, account_id, is_grant) VALUES (?, ?, 1) ON DUPLICATE KEY UPDATE is_grant = 1");
        ps.setString(1, roleId);
        ps.setString(2, accountId);
        ps.executeUpdate();
    }

    private void viewRoles(HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
        String accountId = request.getParameter("account_id");

        PreparedStatement ps = connection.prepareStatement("SELECT r.role_name FROM role r JOIN grant_access g ON r.role_id = g.role_id WHERE g.account_id = ?");
        ps.setString(1, accountId);
        ResultSet rs = ps.executeQuery();

        StringBuilder result = new StringBuilder();
        while (rs.next()) {
            result.append(rs.getString("role_name")).append("<br>");
        }
        response.getWriter().write(result.toString());
    }

    private void viewAccountsByRole(HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
        String roleId = request.getParameter("role_id");

        PreparedStatement ps = connection.prepareStatement("SELECT a.full_name FROM account a JOIN grant_access g ON a.account_id = g.account_id WHERE g.role_id = ?");
        ps.setString(1, roleId);
        ResultSet rs = ps.executeQuery();

        StringBuilder result = new StringBuilder();
        while (rs.next()) {
            result.append(rs.getString("full_name")).append("<br>");
        }
        response.getWriter().write(result.toString());
    }

    private void logLogin(HttpServletRequest request, Connection connection) throws Exception {
        String accountId = (String) request.getSession().getAttribute("accountId");

        PreparedStatement ps = connection.prepareStatement("INSERT INTO log (account_id, login_time) VALUES (?, NOW())");
        ps.setString(1, accountId);
        ps.executeUpdate();
    }

    private void logLogout(HttpServletRequest request, Connection connection) throws Exception {
        String accountId = (String) request.getSession().getAttribute("accountId");

        PreparedStatement ps = connection.prepareStatement("UPDATE log SET logout_time = NOW() WHERE account_id = ? ORDER BY login_time DESC LIMIT 1");
        ps.setString(1, accountId);
        ps.executeUpdate();
    }
}
