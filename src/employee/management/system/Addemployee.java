package employee.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class Addemployee extends JFrame implements ActionListener{
 
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname, tfadd, tfsalary, tfphone, tfemail, tfaa, tfdes;
    JDateChooser dcdob;
    JComboBox tfhed;
    JLabel tfeid;
    JButton add, back;
    
    Addemployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serit", Font.PLAIN, 25));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
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
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
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
        
        String courses[] = {"BBA", "BCA", "B.COM", "B.SC", "BTech", "MBA", "MTech", "M.SC", "MCA"};
        tfhed = new JComboBox(courses);
        labelhed.setBackground(Color.WHITE);
        tfhed.setBounds(600, 300, 150, 30);
        add(tfhed);
        
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
        
        tfaa = new JTextField();
        tfaa.setBounds(600, 350, 150, 30);
        add(tfaa);
        
        JLabel labeleid = new JLabel("Employee ID");
        labeleid.setBounds(50, 400, 150, 30);
        labeleid.setFont(new Font("serit", Font.PLAIN, 25));
        add(labeleid);
        
        tfeid = new JLabel("" + number);
        tfeid.setBounds(200, 400, 150, 30);
        tfeid.setFont(new Font("serit", Font.PLAIN, 20));
        add(tfeid);
        
        add = new JButton("Add Details");
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfadd.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) tfhed.getSelectedItem();
            String aadhar = tfaa.getText();
            String designation = tfdes.getText();
            String empid = tfeid.getText();
            
            try{
                Conn cnn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empid+"')";
                cnn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added succesfully");
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
        new Addemployee();
    }
}
