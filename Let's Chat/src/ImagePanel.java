import javax.swing.*; 
 import java.io.*; 
 import java.awt.*; 
 import java.awt.image.*; 
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;

 public class ImagePanel extends JPanel 
 { 
   public static BufferedImage image; 
   int extra;
   public ImagePanel (String path, int width, int height)
  {
    super();
      setBorder(BorderFactory.createLineBorder(Color.WHITE));
    try{        
       image = Thumbnails.of(new File(path))
            .size(width, height).asBufferedImage();
    }catch (IOException e){}
  }
  public void paintComponent(Graphics g){
    if(extra>0)
      g.drawImage(image, extra, 0, null);
    else
      g.drawImage(image, 0-extra, 0, null);    
    repaint();
  }
 }