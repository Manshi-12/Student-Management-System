import java.sql.*;
import java.util.*;

public class StudentManagementSystem
{
    public static void main(String[] args) throws Exception 
    {
        //Step-1 Load and Register Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded Successfull.");

        //Step-2 Create Connectivity
        String dburl = "jdbc:mysql://localhost:3306/individual_project";
        String dbuser = "root";
        String dbpass = "";

        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
        if(con != null)
        {
            System.out.println("Connection Successfull.");
        }
        else
        {
            System.out.println("Not Connected!!");
        }

        boolean b = true;
        while (b)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nStudent Management System...");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student Data");
            System.out.println("3. Search Student Data");
            System.out.println("4. Update Student Data");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice1 = sc.nextInt(); 

            switch (choice1)
            {
                case 1:
                {
                    System.out.println("\nPlease enter the required information of the student.");
                    System.out.print("Enter Student Name: ");
                    String studentName = sc.next();

                    System.out.print("Enter Student Age: ");
                    int studentAge = sc.nextInt();

                    System.out.print("Enter Student Gender: ");
                    String studentGender = sc.next();
                    
                    long studentContact;
                    while (true) 
                    {
                        try 
                        {
                            System.out.print("Enter Student Contact No. (10 digits): ");
                            studentContact = sc.nextLong();
                            if (String.valueOf(studentContact).length() != 10) 
                            {
                                throw new InputMismatchException();
                            }
                            break; 
                        } 
                        catch (InputMismatchException e) 
                        {
                            sc.nextLine(); 
                            System.err.println("ERROR: Invalid contact number.\nPlease enter a 10-digit number.");
                        }
                    }
                    
                    System.out.print("Enter Student Course: ");
                    String studentCourse = sc.next();

                    System.out.print("Enter Student Overall Percentage: ");
                    int studentPercentage = sc.nextInt();
                    sc.nextLine();

                    String sql = "Insert into studentinfo (sname,sage,sgender,scontact,scourse,spercent) values (?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, studentName);
                    pst.setInt(2, studentAge);
                    pst.setString(3, studentGender);
                    pst.setLong(4, studentContact);
                    pst.setString(5, studentCourse);
                    pst.setInt(6, studentPercentage);

                    int i = pst.executeUpdate();
                    System.out.println("Student Added Successfully....");
                    break;
                }
                case 2:
                {
                    System.out.println("\nChoose your Convenience...");
                    System.out.println("1. By Student ID");
                    System.out.println("2. By Student Name");
                    System.out.print("Enter your choice: ");
                    int choice2 = sc.nextInt();

                    switch (choice2)
                    {
                        case 1: 
                        {
                            System.out.print("Enter Student ID you want to delete: ");
                            int id = sc.nextInt();
                            String sql = "Delete from studentinfo where sid = "+id+" ";
                            PreparedStatement pst = con.prepareStatement(sql);
                            int i = pst.executeUpdate(sql);
                            System.out.println("Student Data Removed Successfully....");
                            break;
                        }
                        case 2: 
                        {
                            System.out.print("Enter Student Name you want to delete: ");
                            String name = sc.next();
                            String sql = "Delete from studentinfo where sname = '"+name+"' ";
                            PreparedStatement pst = con.prepareStatement(sql);
                            int i = pst.executeUpdate(sql);
                            System.out.println("Student Data Removed Successfully....");
                            break;
                        }
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("\nChoose your Convenience...");
                    System.out.println("1. By Student ID");
                    System.out.println("2. By Student Name");
                    System.out.print("Enter your choice: ");
                    int choice3 = sc.nextInt();

                    switch (choice3)
                    {
                        case 1: 
                        {
                            System.out.print("Enter Student ID you want to search: ");
                            int id = sc.nextInt();
                            String sql = "Select * from studentinfo where sid = "+id+"";
                            PreparedStatement pst = con.prepareStatement(sql);
                            ResultSet rs = pst.executeQuery(sql);
                            System.out.println("\n*** Student Details ***");
                            while (rs.next())
                            {
                                System.out.println();
                                System.out.println("ID: "+rs.getInt("sid"));
                                System.out.println("Name: "+rs.getString("sname"));
                                System.out.println("Age: "+rs.getInt("sage"));
                                System.out.println("Gender: "+rs.getString("sgender"));
                                System.out.println("Contact No.: "+rs.getLong("scontact"));
                                System.out.println("Course: "+rs.getString("scourse"));
                                System.out.println("Percentage: "+rs.getInt("spercent"));                                
                            }
                            break;
                        }
                        case 2: 
                        {
                            System.out.print("Enter Student name you want to search: ");
                            String name = sc.next();
                            String sql = "Select * from studentinfo where sname = '"+name+"' ";
                            PreparedStatement pst = con.prepareStatement(sql);
                            ResultSet rs = pst.executeQuery(sql);
                            System.out.println("\n*** Student Details ***");
                            while (rs.next())
                            {
                                System.out.println();
                                System.out.println("ID: "+rs.getInt("sid"));
                                System.out.println("Name: "+rs.getString("sname"));
                                System.out.println("Age: "+rs.getInt("sage"));
                                System.out.println("Gender: "+rs.getString("sgender"));
                                System.out.println("Contact No.: "+rs.getLong("scontact"));
                                System.out.println("Course: "+rs.getString("scourse"));
                                System.out.println("Percentage: "+rs.getInt("spercent"));                                
                            }
                            break;
                        }
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("\nChoose the attribute you want to update with help of Student ID....");
                    System.out.println("1. Name");
                    System.out.println("2. Contact No.");
                    System.out.println("3. Course");
                    System.out.println("4. Percentage");

                    System.out.print("Enter your choice: ");
                    int choice4 = sc.nextInt();

                    switch (choice4)
                    {
                        case 1:
                        {
                            System.out.print("Enter Student ID you want to update: ");
                            int id = sc.nextInt();
                            String sql = "Select sname from studentinfo where sid = "+id+" ";
                            PreparedStatement pst = con.prepareStatement(sql);
                            ResultSet rs = pst.executeQuery(sql);
                            while (rs.next())
                            {
                                System.out.println("Old Name of student with ID "+id+": "+rs.getString("sname"));
                            }

                            System.out.print("Enter the updated name: ");
                            String newname = sc.next();
                            String sql1 = "Update studentinfo set sname = '"+newname+"' where sid = "+id+" ";
                            PreparedStatement pst1 = con.prepareStatement(sql1);
                            int i = pst1.executeUpdate(sql1);
                            System.out.println("Student Data Updated Successfull...");
                            break;
                        }
                        case 2:
                        {
                            System.out.print("Enter Student ID you want to update: ");
                            int id = sc.nextInt();
                            String sql = "Select scontact from studentinfo where sid = "+id+" ";
                            PreparedStatement pst = con.prepareStatement(sql);
                            ResultSet rs = pst.executeQuery(sql);
                            while (rs.next())
                            {
                                System.out.println("Old Contact No. of student with ID "+id+": "+rs.getLong("scontact"));
                            }

                            System.out.print("Enter the updated contact no.: ");
                            Long newnumber = sc.nextLong();
                            String sql1 = "Update studentinfo set scontact = "+newnumber+" where sid = "+id+" ";
                            PreparedStatement pst1 = con.prepareStatement(sql1);
                            int i = pst1.executeUpdate(sql1);
                            System.out.println("Student Data Updated Successfull...");
                            break;
                        }
                        case 3:
                        {
                            System.out.print("Enter Student ID you want to update: ");
                            int id = sc.nextInt();
                            String sql = "Select scourse from studentinfo where sid = "+id+" ";
                            PreparedStatement pst = con.prepareStatement(sql);
                            ResultSet rs = pst.executeQuery(sql);
                            while (rs.next())
                            {
                                System.out.println("Old Course of student with ID "+id+": "+rs.getString("scourse"));
                            }

                            System.out.print("Enter the updated course: ");
                            String newcourse = sc.next();
                            String sql1 = "Update studentinfo set scourse = '"+newcourse+"' where sid = "+id+" ";
                            PreparedStatement pst1 = con.prepareStatement(sql1);
                            int i = pst1.executeUpdate(sql1);
                            System.out.println("Student Data Updated Successfull...");
                            break;
                        }
                        case 4:
                        {
                            System.out.print("Enter Student ID you want to update: ");
                            int id = sc.nextInt();
                            String sql = "Select spercent from studentinfo where sid = "+id+" ";
                            PreparedStatement pst = con.prepareStatement(sql);
                            ResultSet rs = pst.executeQuery(sql);
                            while (rs.next())
                            {
                                System.out.println("Old Percentage of student with ID "+id+": "+rs.getInt("spercent"));
                            }

                            System.out.print("Enter the updated percentage: ");
                            int newpercent = sc.nextInt();
                            String sql1 = "Update studentinfo set spercent = '"+newpercent+"' where sid = "+id+" ";
                            PreparedStatement pst1 = con.prepareStatement(sql1);
                            int i = pst1.executeUpdate(sql1);
                            System.out.println("Student Data Updated Successfull...");
                            break;
                        }
                    }
                    break;
                }
                case 5:
                {
                    String sql = "Select * from studentinfo";
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);
                    System.out.println("\n*** Student Details ***");
                    while (rs.next())
                    {
                        System.out.println();
                        System.out.println("ID: "+rs.getInt("sid"));
                        System.out.println("Name: "+rs.getString("sname"));
                        System.out.println("Age: "+rs.getInt("sage"));
                        System.out.println("Gender: "+rs.getString("sgender"));
                        System.out.println("Contact No.: "+rs.getLong("scontact"));
                        System.out.println("Course: "+rs.getString("scourse"));
                        System.out.println("Percentage: "+rs.getInt("spercent"));  
                        System.out.println();                              
                    }
                    break;
                }
                case 6:
                {
                    System.out.println("Exiting...");
                    b = false;
                    break;
                }
                default:
                {
                    System.out.println("Enter Correct Choice.");
                }
            }
        }        
    }
}