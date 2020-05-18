import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener
{
    JLabel backImg, topLogo, lblUsername, lblPwd, lblTtl, lblTag;
    JTextField tfUsername;
    JPasswordField tfPassword;
    JButton btnLogin, btnCancel;
    public login()
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e){}
        setTitle("Login : Let's Chat (A Messenger for this generation! )");
        setSize(430, 300);              //WIDTH AND HEIGHT OF THE FRAME WINDOW
        setLocation(430, 230);          //left and top of the frame window as per screen
        setLayout(null);                //so that we could display the comps as per our  requirement
        setResizable(false);            //so that the user could not change the size of the window
        //backImg = new JLabel();         //initialized a label to display image
        //ImageIcon i1 = new ImageIcon(this.getClass().getResource("Images/Wallpaper-White-Brown-Wind.jpg"));      //To load an image
        //backImg.setIcon(i1);            //image set in label
        //backImg.setLocation(0, 0);
        //backImg.setSize(430, 300);              //WIDTH AND HEIGHT OF THE bg image
        //add(backImg);
        
        tfUsername = new JTextField();
        tfPassword = new JPasswordField();
        lblUsername = new JLabel("User ID : ");
        lblPwd = new JLabel("Password : ");
        lblTtl = new JLabel("|| USER LOGIN ||");
        btnLogin = new JButton(" LOGIN ");
        btnCancel = new JButton("CANCEL");
        lblTag = new JLabel("Not yet registered? Sign Up");
        backImg = new JLabel();         //initialized a label to display image
        ImageIcon i1 = new ImageIcon(this.getClass().getResource("Images/bkgd_1.jpg")); 
        topLogo = new JLabel();         //initialized a label to display image
        ImageIcon i2 = new ImageIcon(this.getClass().getResource("Images/logo title.jpg")); 
        topLogo.setIcon(i2);            //image set in label
        topLogo.setLocation(0, 0);
        topLogo.setSize(430, 100); 
        lblTtl.setBounds(115,110,190,30);
        lblTtl.setFont(new Font("Georgia", Font.BOLD, 20));
        lblUsername.setFont(new Font("Georgia", Font.BOLD, 14));
        lblUsername.setBounds(60,147,100,24);
        tfUsername.setBounds(170,147,190,24);
        lblTtl.setFont(new Font("Georgia", Font.BOLD, 20));
        lblTtl.setFont(new Font("Georgia", Font.BOLD, 20));
        lblPwd.setFont(new Font("Georgia", Font.BOLD, 14));
        lblPwd.setBounds(60,177,100,24);
        tfPassword.setBounds(170,177,190,24);
        btnLogin.setBounds(100,211,100,20);
        btnCancel.setBounds(210,211,100,20);
        lblTag.setFont(new Font("Georgia", Font.BOLD, 14));
        lblTag.setBounds(100,245,200,20);
        //x, y, w, h
        backImg.setIcon(i1);            //image set in label
        backImg.setLocation(0, 0);
        backImg.setSize(430, 300);              //WIDTH AND HEIGHT OF THE bg image
        //lblTag.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //tfPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(topLogo);
        add(tfUsername);
        add(tfPassword);
        add(lblUsername);
        add(lblPwd);
        add(lblTtl);
        add(btnLogin);
        add(btnCancel);
        add(lblTag);
        add(backImg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //what to do when the close button is pressed
        //JFrame.EXIT_ON_CLOSE          to exit
        //JFrame.DISPOSE_ON_CLOSE       to hide
        //JFrame.DO_NOTHING_ON_CLOSE    to do nothing
        setVisible(true);               // to display the frame window
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    public static void main(String args[])
    {
        new login();//initialized an object so that the constructor of the class may be called
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btnCancel)
        {
            int i = JOptionPane.showConfirmDialog(this, "Are You sure?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(i==JOptionPane.YES_OPTION)
                System.exit(1);
        }
        if(e.getSource()==btnLogin)
        {
            try
                {
                    Socket sc = new Socket(properties.ServerIP, 1000);
                    System.out.println("Server Connected");
                    DataInputStream dis = new DataInputStream(sc.getInputStream());
                    DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
                    dos.writeUTF(tfUsername.getText());
                    dos.writeUTF(tfPassword.getText());
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
                        new LetsChat(tfUsername.getText());
                    }
                    dis.close();
                    dos.close();
                    sc.close();
                }
                catch(Exception e1){e1.printStackTrace();}
        }
    }
}
