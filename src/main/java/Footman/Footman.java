package Footman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class Footman {

        private static final String url = "jdbc:mysql://localhost:3306/football";
        private static final String user = "root";
        private static final String password = "1111";

        // JDBC variables for opening and managing connection
        private static Connection con;
        private static Statement stmt;
        private static ResultSet rs;

        public static void main(String args[]) {
            int n = 1;
            while (n == 1) {
                System.out.println("Выберите, что хотите просмотреть:\n1)список футболистов\n2)список клубов\n3)список стран\n4)список чемпионатов\n5)игрок/позиция\n6)добавить страну\n7)удалить страну\n8)update");
                int a;
                Scanner in = new Scanner(System.in);
                a = in.nextInt();

                switch (a) {
                    case 1: {
                        String query = "select * from player";
                        try {
                            // opening database connection to MySQL server
                            con = DriverManager.getConnection(url, user, password);

                            // getting Statement object to execute query
                            stmt = con.createStatement();

                            // executing SELECT query
                            rs = stmt.executeQuery(query);

                            while (rs.next()) {
                                int idp = rs.getInt("idplayer");
                                String surname = rs.getString("surname");
                                int id_club = rs.getInt("idclub");
                                int id_country = rs.getInt("idcountry");
                                System.out.println(idp + "\t" + surname + "\t" + id_club + "\t" + id_country);
                            }

                        } catch (SQLException sqlEx) {
                            sqlEx.printStackTrace();
                        } finally {
                            //close connection ,stmt and resultset here
                            try {
                                con.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                stmt.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                rs.close();
                            } catch (SQLException se) { /*can't do anything */ }
                        }
                        System.out.println("Хотите продолжить? 1 - да, 2 - нет");
                        n = in.nextInt();
                        break;
                    }
                    case 2: {
                        String query = "select * from club";
                        try {
                            // opening database connection to MySQL server
                            con = DriverManager.getConnection(url, user, password);

                            // getting Statement object to execute query
                            stmt = con.createStatement();

                            // executing SELECT query
                            rs = stmt.executeQuery(query);

                            while (rs.next()) {
                                int idclub = rs.getInt("idclub");
                                String name = rs.getString("name_club");
                                int id_coach = rs.getInt("idcoach");
                                int id_champ = rs.getInt("id_champioship");
                                System.out.println(idclub + "\t" + name + "\t" + id_coach + "\t" + id_champ);
                            }

                        } catch (SQLException sqlEx) {
                            sqlEx.printStackTrace();
                        } finally {
                            //close connection ,stmt and resultset here
                            try {
                                con.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                stmt.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                rs.close();
                            } catch (SQLException se) { /*can't do anything */ }
                        }
                        System.out.println("Хотите продолжить? 1 - да, 2 - нет");
                        n = in.nextInt();
                        break;
                    }
                    case 3: {
                        String query = "select * from country";
                        try {
                            // opening database connection to MySQL server
                            con = DriverManager.getConnection(url, user, password);

                            // getting Statement object to execute query
                            stmt = con.createStatement();

                            // executing SELECT query
                            rs = stmt.executeQuery(query);

                            while (rs.next()) {
                                int id_country = rs.getInt("idcountry");
                                String name = rs.getString("name_coun");
                                System.out.println(id_country + "\t" + name + "\t");
                            }

                        } catch (SQLException sqlEx) {
                            sqlEx.printStackTrace();
                        } finally {
                            //close connection ,stmt and resultset here
                            try {
                                con.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                stmt.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                rs.close();
                            } catch (SQLException se) { /*can't do anything */ }
                        }
                        System.out.println("Хотите продолжить? 1 - да, 2 - нет");
                        n = in.nextInt();
                        break;
                    }
                    case 4: {
                        String query = "select * from country";
                        try {
                            // opening database connection to MySQL server
                            con = DriverManager.getConnection(url, user, password);

                            // getting Statement object to execute query
                            stmt = con.createStatement();

                            // executing SELECT query
                            rs = stmt.executeQuery(query);

                            while (rs.next()) {
                                int idp = rs.getInt("idchampionship");
                                String name = rs.getString("name_champ");
                                System.out.println(idp + "\t" + name);
                            }

                        } catch (SQLException sqlEx) {
                            sqlEx.printStackTrace();
                        } finally {
                            //close connection ,stmt and resultset here
                            try {
                                con.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                stmt.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                rs.close();
                            } catch (SQLException se) { /*can't do anything */ }
                        }
                        System.out.println("Хотите продолжить? 1 - да, 2 - нет");
                        n = in.nextInt();
                        break;
                    }
                    case 8: {
                        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/football", "root", "1111")){
                            Statement statement = connection.createStatement();
                            String updSql = "update country set idcountry='" +10+ "' WHERE name_coun = 'Belarus';";
                            statement.executeUpdate(updSql);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                            break;
                    }
                    case 7:
                    {

                        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/football", "root", "1111")){
                            Statement statement = connection.createStatement();
                            String updSql = "delete from country WHERE name_coun = 'Belarus'";
                            statement.executeUpdate(updSql);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();

                    }break;}

                    case 6: {
                        String query = "select * from country";
                        try {
                            // opening database connection to MySQL server
                            con = DriverManager.getConnection(url, user, password);

                            // getting Statement object to execute query
                            stmt = con.createStatement();

                            // executing SELECT query
                            rs = stmt.executeQuery(query);

                            //System.out.println("Введите фамилию:");
                            //String surname = in.nextLine();
                            //String surname_coach = in.nextLine();
                            //System.out.println("Введите id клуба:");
                           // String idclub = in.nextLine();
                           // System.out.println("Введите id страны:");
                            //String idcountry = in.nextLine();
                            //System.out.println(surname+" "+idclub+" "+idcountry);
                            int rows = stmt.executeUpdate("INSERT country(name_coun) VALUES ('Belarus')");
                        } catch (SQLException sqlEx) {
                            sqlEx.printStackTrace();
                        }
                        System.out.println("Хотите продолжить? 1 - да, 2 - нет");
                        n = in.nextInt();
                        break;
                    }

                    case 5:
                        String query = "select * from player_pos";
                        try {
                            // opening database connection to MySQL server
                            con = DriverManager.getConnection(url, user, password);

                            // getting Statement object to execute query
                            stmt = con.createStatement();

                            // executing SELECT query
                            rs = stmt.executeQuery(query);
                            System.out.println("");
                            while (rs.next()) {
                                int idplayer = rs.getInt("idplayer");
                                int id_pos = rs.getInt("idposition");
                                System.out.println(idplayer + "\t" + id_pos);
                            }

                        } catch (SQLException sqlEx) {
                            sqlEx.printStackTrace();
                        } finally {
                            //close connection ,stmt and resultset here
                            try {
                                con.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                stmt.close();
                            } catch (SQLException se) { /*can't do anything */ }
                            try {
                                rs.close();
                            } catch (SQLException se) { /*can't do anything */ }
                        }
                        System.out.println("Хотите продолжить? 1 - да, 2 - нет");
                        n = in.nextInt();
                        break;


                }
            }
        }}
