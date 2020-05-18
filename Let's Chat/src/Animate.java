import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class Animate implements Runnable
{
    static int NAME;
    static final int LEFT=0;
    static final int RIGHT=1;
    static final int CENTER=2;
    JPanel parent;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    public Animate(JPanel parent, int NAME)
    {
        this.parent = parent;
        this.NAME = NAME;
        new Thread(this).start();
    }
    public void run()
    {
        if(NAME==LEFT)
        {
            if(parent.getWidth()==0)
            {
                while(parent.getWidth()<screen.width/4)
                {
                  parent.setSize(parent.getWidth()+2, parent.getHeight());
                  try{Thread.currentThread().sleep(5);}catch(Exception e){}
                }
                  LetsChat.lButton.setText("<<");
            }
            else
            {
                while(parent.getWidth()>0)
                {
                  parent.setSize(parent.getWidth()-2, parent.getHeight());
                  try{Thread.currentThread().sleep(5);}catch(Exception e){}
                }
                  LetsChat.lButton.setText(">>");
            }
        }
        else if(NAME==RIGHT)
        {
            if(parent.getWidth()>0)
            {
               while(parent.getWidth()>0)
                {
                  parent.setSize(parent.getWidth()-2, parent.getHeight());
                  parent.setLocation(parent.getX()+2, parent.getY());
                  try{Thread.currentThread().sleep(5);}catch(Exception e){}
                }
                  LetsChat.lButton.setText("<<");
            }
            else
            {
                 while(parent.getWidth()<screen.width/4)
                 {
                  parent.setSize(parent.getWidth()+2, parent.getHeight());
                  parent.setLocation(parent.getX()-2, parent.getY());
                  try{Thread.currentThread().sleep(5);}catch(Exception e){}
                }
                  LetsChat.lButton.setText(">>");
            }
        }
        if(NAME==CENTER)
        {
            
        }
        
    }
}
