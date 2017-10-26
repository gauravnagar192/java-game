package game;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author Administrator
 */
public class Display {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width , height;
    public Display(String title,int width,int height){
        this.title=title;
        this.width=width;
        this.height=height;
        createdisplay();
    }
     public void createdisplay(){
         frame = new JFrame(title);
         frame.setSize(width, height);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
         frame.setResizable(false);
         canvas = new Canvas();
         canvas.setPreferredSize(new Dimension(width,height));
         canvas.setMaximumSize(new Dimension(width,height));
         canvas.setMinimumSize(new Dimension(width,height));
         frame.add(canvas);
         frame.pack();
         }
      public Canvas getcanvas(){
          return canvas;
      }

}
