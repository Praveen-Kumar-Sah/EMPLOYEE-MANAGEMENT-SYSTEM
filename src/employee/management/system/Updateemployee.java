package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Updateemployee extends JFrame implements ActionListener{
 
      
    JTextField tfeducation, tffname, tfadd, tfsalary, tfphone, tfemail, tfaa, tfdes;
    JLabel tfeid;
    JButton add, back;
    String empId;
    
    Updateemployee(String empId){
        
        this.empId = empId;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serit", Font.PLAIN, 25));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serit", Font.PLAIN, 25));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serit", Font.PLAIN, 25));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serit", Font.PLAIN, 25));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labeladd = new JLabel("Address");
        labeladd.setBounds(50, 250, 150, 30);
        labeladd.setFont(new Font("serit", Font.PLAIN, 25));
        add(labeladd);
        
        tfadd = new JTextField();
        tfadd.setBounds(200, 250, 150, 30);
        add(tfadd);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serit", Font.PLAIN, 25));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serit", Font.PLAIN, 25));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labelhed = new JLabel("Highest Education");
        labelhed.setBounds(400, 300, 150, 30);
        labelhed.setFont(new Font("serit", Font.PLAIN, 25));
        add(labelhed);
        
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        JLabel labeldes = new JLabel("Designation");
        labeldes.setBounds(50, 350, 150, 30);
        labeldes.setFont(new Font("serit", Font.PLAIN, 25));
        add(labeldes);
        
        tfdes = new JTextField();
        tfdes.setBounds(200, 350, 150, 30);
        add(tfdes);
        
        JLabel labelaa = new JLabel("Aadhar Number");
        labelaa.setBounds(400, 350, 150, 30);
        labelaa.setFont(new Font("serit", Font.PLAIN, 25));
        add(labelaa);
        
        JLabel lblaa = new JLabel();
        lblaa.setBounds(600, 350, 150, 30);
        add(lblaa);
        
        JLabel labeleid = new JLabel("Employee ID");
        labeleid.setBounds(50, 400, 150, 30);
        labeleid.setFont(new Font("serit", Font.PLAIN, 25));
        add(labeleid);
        
        tfeid = new JLabel();
        tfeid.setBounds(200, 400, 150, 30);
        tfeid.setFont(new Font("serit", Font.PLAIN, 20));
        add(tfeid);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where EID = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfadd.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdes.setText(rs.getString("designation"));
                lblaa.setText(rs.getString("aadhar"));
                tfeid.setText(rs.getString("EID"));
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfadd.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdes.getText();
            
            try{
                Conn cnn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where EID = '"+tfeid+"'";
                cnn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated succesfully");
                setVisible(false);
                new Home();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }   
    
    public static void main(String[] args) {
        new Updateemployee("");
    }
}
