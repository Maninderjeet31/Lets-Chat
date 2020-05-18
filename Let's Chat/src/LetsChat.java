import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class LetsChat extends JFrame implements ActionListener
{
    String userid;
    JDesktopPane jdp;
    JLabel title, lblfrborder, lblfrttl;
    static JButton lButton, rButton;
    JTextField tffrid;
    JButton btnSReq;
    JPanel lPanel, rPanel, mainPanel;
    //ImagePanel thumb;
    
    public void setTitle(String Title) 
    {
        title.setText(Title);
    }
    public LetsChat(String userid)
    {
        Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0, d1.width, d1.height);
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e){}
        this.userid = userid;
        jdp = new JDesktopPane();
        lPanel = new JPanel();
        rPanel = new JPanel();
        mainPanel = new JPanel();
        setContentPane(jdp);
        
        
        
        //Components of Left Panel
          lPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
          lPanel.setBounds(3, 50, getWidth()/4, getHeight()-180);
          lButton = new JButton("<<");
          lButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
          lButton.setOpaque(false);
          lButton.setBounds(3, getHeight()-127, 75, 40);
          lButton.addActionListener(this);
          lPanel.setOpaque(false);
        
        //Components of Right Panel
          rPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
          rPanel.setLayout(null);
          rPanel.setBounds(getWidth()-lPanel.getWidth()-3, 50, getWidth()/4, getHeight()-180);
          lblfrborder = new JLabel();
          rButton = new JButton(">>");
          rButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
          rButton.setOpaque(false);
          rButton.setBounds(d1.width-80, getHeight()-127, 75, 40);
          rButton.addActionListener(this);
          rPanel.setOpaque(false);
        
       // , lblfrttl tffrid btnSReq
        
        
        
        //Components of Main Panel
          mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
          mainPanel.setBounds(lPanel.getX()+lPanel.getWidth()+3, 50, getWidth()/2-12, getHeight()-180);
          mainPanel.setOpaque(false);
          mainPanel.setLayout(null);
                
        //Components of Messages Panel
        
        //Components of Friend Request Panel
        
        //Components of Avatar/Image Panel
        
        
        
        //other components of desktop
        title = new JLabel(" Let's Chat Messenger : " + userid);
        title.setBounds(3, 3, getWidth()-10, 40);
        jdp.setLayout(null);
        jdp.add(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        
       
      
        
        jdp.add(lButton);
        jdp.add(rButton);
        jdp.add(lPanel);
        jdp.add(rPanel);
        jdp.add(mainPanel);
        setVisible(true);
        
        
        //thumb = new ImagePanel("src/Images/abstract-brown-and-white-wave-powerpoint-backgrounds.jpg", 100, 100);
        //thumb.setBounds(50, 50, 100, 100);
        
        //rButton.setBounds(3, getHeight()-177, getWidth()/4, getHeight()-180);
       
        //mainPanel.add(thumb);
        
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        title.setForeground((Color.WHITE));
        title.setFont(new Font("Garamond", Font.PLAIN, getHeight()/29));
        title.setBackground(null);
        
    }
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            new LetsChat("lalitluckyjangra");
            }
        });
        
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==lButton)
            new Animate(lPanel, Animate.LEFT);
        if(e.getSource()==rButton)
            new Animate(rPanel, Animate.RIGHT);
    
    }
}
