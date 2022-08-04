package com.udemy.app;

import com.udemy.db.DB;
import com.udemy.db.DbIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramaDeletar {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;

        String deleteQuery = "delete from department where id = ?";

        try{
            conn = DB.getConnection();
            ps = conn.prepareStatement(deleteQuery);

            ps.setInt(1, 4);

            int rowsAffected = ps.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
