package com.udemy.app;

import com.udemy.db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramaAtualizar {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String updateQuery = "update seller " +
                "set BaseSalary = BaseSalary+? " +
                "where DepartmentId = ?";

        try{
            conn = DB.getConnection();
            ps = conn.prepareStatement(updateQuery);

            ps.setDouble(1, 200.00);
            ps.setInt(2, 2);

            int rowsAffected = ps.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
