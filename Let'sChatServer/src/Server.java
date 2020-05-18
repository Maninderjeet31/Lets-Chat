
import java.net.*;
import java.io.*;
import java.sql.*;


public class Server{
    public static void main(String args[]){
        int ports[] = {1000, 1001, 1002};
        ServerListener lstnrObj[] = new ServerListener[ports.length];
        for(int i = 0;i<ports.length;i++)
            lstnrObj[i] = new ServerListener(ports[i]);
    }
}
class ServerListener extends Thread{
    int port;
    public ServerListener(int port){
        this.port = port;
        start();
    }
    public void run(){
        if(port==1000)//Login Port Work by Server
        {
            while(true)
            {
                System.out.println("Server waiting for client's login at port no. 1000");
                try
                {
                    ServerSocket ss = new ServerSocket(port);
                    Socket sc = ss.accept();
                    System.out.println("Request of client received for login");
                    DataInputStream dis = new DataInputStream(sc.getInputStream());
                    DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
                    String emailid = dis.readUTF();
                    String upwd = dis.readUTF();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/letschat", properties.dbUsername, properties.dbPassword);
                    Statement st = cn.createStatement();
                    String query = "Select * from user_info where emailid='"+emailid+"'";
                    ResultSet rs = st.executeQuery(query);
                    String msg="";
                    if(rs.next())
                        if(rs.getString("password").equals(upwd))
                            msg="scs";
                        else
                            msg="ipwd";
                    else
                        msg="iuser";
                    dos.writeUTF(msg);
                    dis.close();
                    dos.close();
                    sc.close();
                    ss.close();
                }
                catch(Exception e){e.printStackTrace();}
            }
        }
        if(port==1001)//Sign up Port Work by Server
        {
                try
                {
                    ServerSocket ss = new ServerSocket(port);
                    Socket sc = ss.accept();
                    System.out.println("Request of client received for signup");
                    DataInputStream dis = new DataInputStream(sc.getInputStream());
                    DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
                    String Name = dis.readUTF();
                    String Emailid= dis.readUTF();
                    String Password= dis.readUTF();
                    String Address= dis.readUTF();
                    String City= dis.readUTF();
                    String State= dis.readUTF();
                    String Country= dis.readUTF();
                    String Contact= dis.readUTF();
                    String dat= dis.readUTF();
                    String Gender = dis.readUTF();
            
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/letschat", properties.dbUsername, properties.dbPassword);
                    Statement st = cn.createStatement();
                    String query = "Select * from user_info where emailid='"+Emailid+"'";
                    ResultSet rs = st.executeQuery(query);
                    
                    String msg="";
                    if(rs.next())
                        msg="uae";
                    else
                        msg="ipwd";
                    dos.writeUTF(msg);
                    dis.close();
                    dos.close();
                    sc.close();
                    ss.close();
                }
                catch(Exception e){e.printStackTrace();}
        }
        if(port==1002)
        {
            System.out.println("This is Frgt pwd thread!");            
        }
    }
}