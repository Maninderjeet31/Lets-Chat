import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Date;
import javax.imageio.*;
import javax.swing.*;

public class signup extends JFrame implements ActionListener
{
    JLabel backImg, topLogo, lblName, lblPassword, lblEmailid, lblDOB, lblAddress, lblCity, lblState, lblCountry, lblGender, lblContact;
    JButton btnNext, btnNext1, btnOK;
    JTextField tfName,tfEmailid,tfPassword, tfAddress, tfCity, tfState, tfCountry, tfContact;
    JComboBox<String> dt, mt, yr, jcbGender;
    JPanel mainpanel;
    public signup()
    {
        try
            {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }
            catch(Exception e){}
            setTitle("Login : Let's Chat : Sign Up");
            setSize(430, 300);              //WIDTH AND HEIGHT OF THE FRAME WINDOW
            setLocation(130, 230);          //left and top of the frame window as per screen
            setLayout(null);                //so that we could display the comps as per our  requirement
            //setResizable(false);
            mainpanel = new JPanel();
            tfName = new JTextField();
            tfPassword = new JTextField();
            tfEmailid = new JTextField();
            lblName = new JLabel("Name : ");
            lblPassword = new JLabel("Password : ");
            lblEmailid = new JLabel("Email-ID : ");
            btnNext = new JButton(" NEXT ");
            
            jcbGender = new JComboBox<String>(new String[]{"Not Specified", "Male", "Female"});
            tfContact = new JTextField();
            lblDOB = new JLabel("D.O.B. : ");
            lblGender = new JLabel("Sex : ");
            lblContact = new JLabel("Contact No : ");
            btnNext1 = new JButton(" NEXT ");
            
            tfAddress = new JTextField();
            tfCity = new JTextField();
            tfState = new JTextField();
            tfCountry = new JTextField();
            lblAddress = new JLabel("Address : ");
            lblCity = new JLabel("City : ");
            lblState = new JLabel("State : ");
            lblCountry = new JLabel("Country : ");
            btnOK = new JButton(" OK ");
        
            backImg = new JLabel();         //initialized a label to display image
            ImageIcon i3 = new ImageIcon(this.getClass().getResource("Images/bkgd_2.jpg")); 
            topLogo = new JLabel();         //initialized a label to display image
            ImageIcon i4 = new ImageIcon(this.getClass().getResource("Images/logo title.jpg")); 
            topLogo.setIcon(i4);            //image set in label
            topLogo.setLocation(0, 0);
            topLogo.setSize(430, 100); 
            mainpanel.setBounds(0, 100, getWidth()*3, getHeight()-100);
            
        add(mainpanel);
        lblName.setFont(new Font("Georgia", Font.BOLD, 14));
        lblName.setBounds(60,17,100,24);
        tfName.setBounds(170,17,190,24);
        lblPassword.setFont(new Font("Georgia", Font.BOLD, 14));
        lblPassword.setBounds(60,47,100,24);
        tfPassword.setBounds(170,47,190,24);
        lblEmailid.setFont(new Font("Georgia", Font.BOLD, 14));
        lblEmailid.setBounds(60,77,100,24);
        tfEmailid.setBounds(170,77,190,24);
        btnNext.setBounds(140,137,150,20);
        mainpanel.setOpaque(false);
        lblDOB.setFont(new Font("Georgia", Font.BOLD, 14));
        lblDOB.setBounds(490,17,100,24);
        dt = new JComboBox<String>();
        mt = new JComboBox<String>();
        yr = new JComboBox<String>();
        
        dt.setBounds(590,17,60,24);
        mt.setBounds(649,17,70,24);
        yr.setBounds(717,17,62,24);
        dt.addItem("Date");
        mt.addItem("Month");
        yr.addItem("Year");
        for(int i = 1;i<=31;i++)
            dt.addItem(String.valueOf(i));
        for(int i = 1;i<=12;i++)
            mt.addItem(String.valueOf(i));
        int i = new Date(System.currentTimeMillis()).getYear()+1900;
        for(int j=0;j<70;j++)
            yr.addItem(String.valueOf(i-j));
        mainpanel.add(dt);
        mainpanel.add(mt);
        mainpanel.add(yr);
        //      tfName.setBounds(170,117,190,24);
        lblGender.setFont(new Font("Georgia", Font.BOLD, 14));
        lblGender.setBounds(490,47,100,24);
        jcbGender.setBounds(590,47,190,24);
        lblContact.setFont(new Font("Georgia", Font.BOLD, 14));       
        lblContact.setBounds(490,77,100,24);
        tfContact.setBounds(590,77,190,24);
        btnNext1.setBounds(570,137,150,20);
        
        lblAddress.setFont(new Font("Georgia", Font.BOLD, 14));
        lblAddress.setBounds(920,17,100,24);
        tfAddress.setBounds(1020,17,190,24);
        lblCity.setFont(new Font("Georgia", Font.BOLD, 14));
        lblCity.setBounds(920,47,100,24);
        tfCity.setBounds(1020,47,190,24);
        lblState.setFont(new Font("Georgia", Font.BOLD, 14));
        lblState.setBounds(920,77,100,24);
        tfState.setBounds(1020,77,190,24);
        lblCountry.setFont(new Font("Georgia", Font.BOLD, 14));
        lblCountry.setBounds(920,107,100,24);
        tfCountry.setBounds(1020,107,190,24);
        btnOK.setBounds(1000,137,150,20);
//      x, y, w, h
        mainpanel.setLayout(null);
        backImg.setIcon(i3);            //image set in label
        backImg.setLocation(0, 0);
        backImg.setSize(430, 300);     
        
        mainpanel.add(lblName);
        mainpanel.add(tfName);
        mainpanel.add(tfPassword);
        mainpanel.add(lblPassword);
        mainpanel.add(tfEmailid);
        mainpanel.add(lblEmailid);
        mainpanel.add(btnNext);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        mainpanel.add(lblDOB);
        mainpanel.add(jcbGender);
        mainpanel.add(lblGender);
        mainpanel.add(tfContact);
        mainpanel.add(lblContact);
        mainpanel.add(btnNext1);
        mainpanel.add(lblAddress);
        mainpanel.add(tfAddress);
        mainpanel.add(tfCity);
        mainpanel.add(lblCity);
        mainpanel.add(tfState);
        mainpanel.add(lblState);
        mainpanel.add(tfCountry);
        mainpanel.add(lblCountry);
        mainpanel.add(btnOK);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //what to do when the close button is pressed
//        //JFrame.EXIT_ON_CLOSE          to exit
        //JFrame.DISPOSE_ON_CLOSE       to hide
        //JFrame.DO_NOTHING_ON_CLOSE    to do nothing
        add(topLogo);
        add(backImg);
        setVisible(true);               // to display the frame window
        btnNext.addActionListener(this);
        btnNext1.addActionListener(this);
        btnOK.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().contains("NEXT"))
            new Thread(new ani("for")).start();
        else
            doSignup();
    }
    public boolean validateCtrls()
    {
        String em = tfEmailid.getText();
        int atpos = em.indexOf("@"), dotpos = em.lastIndexOf(".");
        if(dotpos<atpos||atpos<4)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid Email-id");
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            return false;
        }
        if(tfName.getText().length()<3)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid name");
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            return false;
        }
        
        if(dt.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select a date for Date of Birth");
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            return false;
        }
        
        if(mt.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select a month for Date of Birth");
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            return false;
        }
        
        if(yr.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select a year for Date of Birth");
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            return false;
        }
        
        if(jcbGender.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select a Gender Type");
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            return false;
        }
        if(tfPassword.getText().length()<6)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid password");
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            return false;
        }
        if(tfAddress.getText().length()<5)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid Address");
            return false;
        }
        
        if(tfCity.getText().length()<3)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid City");
            return false;
        }
        
        if(tfState.getText().length()<3)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid City");
            return false;
        }
        
        if(tfCountry.getText().length()<5)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid Country");
            return false;
        }
        
        if(tfContact.getText().length()<6)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid Contact Number");
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            mainpanel.setLocation(mainpanel.getX()+430, mainpanel.getY());
            return false;
        }
        return true;
    }
    public void doSignup()
    {
     try
        {
            if(validateCtrls()==true)
            {
            Socket sc = new Socket(properties.ServerIP, 1001);
            System.out.println("Server Connected");
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            int i=1;
            System.out.println(i++);
            dos.writeUTF(tfName.getText());
            System.out.println(i++);
            dos.writeUTF(tfEmailid.getText());
            System.out.println(i++);
            dos.writeUTF(tfPassword.getText());
            System.out.println(i++);
            dos.writeUTF(tfAddress.getText());
            System.out.println(i++);
            dos.writeUTF(tfCity.getText());
            System.out.println(i++);
            dos.writeUTF(tfState.getText());
            System.out.println(i++);
            dos.writeUTF(tfCountry.getText());
            System.out.println(i++);
            dos.writeUTF(tfContact.getText());
            System.out.println(i++);
            String dat = dt.getSelectedItem().toString()+"/"+mt.getSelectedItem().toString()+"/"+yr.getSelectedItem().toString();
            System.out.println(i++);
            dos.writeUTF(dat);
            System.out.println(i++);
            dos.writeUTF(jcbGender.getSelectedItem().toString());
            System.out.println(i++);
            String msg = dis.readUTF();
            if(msg.equals("ipwd"))
            {
                JOptionPane.showMessageDialog(rootPane, "Password entered by you is invalid! \nPlease check and retry again!", "Login Error !", JOptionPane.ERROR_MESSAGE);
            }
            else if(msg.equals("iuser"))
            {
                JOptionPane.showMessageDialog(rootPane, "User ID entered by you is invalid! \nPlease check and retry again!", "Login Error !", JOptionPane.ERROR_MESSAGE);
            }
            else if(msg.equals("scs"))
            {
                JOptionPane.showMessageDialog(rootPane, "Login Succeeded!", "Login", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new LetsChat(tfEmailid.getText());
            }
            dis.close();
            dos.close();
            sc.close();
            }
        }
        catch(Exception e1){e1.printStackTrace();}   
    }
    public static void main(String args[])
    {
        new signup();//initialized an object so that the constructor of the class may be called
    }
    class ani implements Runnable
    {
        int dif;
        String move;
        public ani(String move)
        {
            this.move=move;
            if(move.equals("for"))
                dif = -10;
        }
        public void run() {
            if(move.equals("for"))
                for(int i = 1;i<=430;i+=10)
                {
                    mainpanel.setLocation(mainpanel.getX()+dif, mainpanel.getY());
                    try{
                    Thread.currentThread().sleep(1);
                    }catch(Exception e){}
                }
        }
    }
}
    
