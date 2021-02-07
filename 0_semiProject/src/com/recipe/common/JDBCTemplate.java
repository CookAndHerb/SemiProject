package com.recipe.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
   public static Connection getConnection() {
      Connection conn= null;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COOK","COOK");
         conn.setAutoCommit(false);
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
      
      return conn;
   }
   
   public static void close(Connection conn) {
      try {
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void close(Statement stmt) {
      try {
         stmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void close(ResultSet rset) {
      try {
         rset.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void commit(Connection conn) {
      try {
         conn.commit();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void rollback(Connection conn) {
      try {
         conn.rollback();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}