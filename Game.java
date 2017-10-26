/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Administrator
 */
public class Game implements Runnable {
         private Display display;
         public int width , height;
         public String title ;

         public Thread thread;
         public boolean running = false;
         private Graphics g;
         private BufferStrategy bs;

         public Game(String title,int width,int height){
             this.width=width;
             this.height=height;
             this.title=title;
         }
         
         public void init(){
             display = new Display(title,width,height);
         }
         public void tick(){
                   
         } 
         public void render(){
               bs = display.getcanvas().getBufferStrategy();
               if(bs== null){
                   display.getcanvas().createBufferStrategy(3);
                   return;
               }
               g = bs.getDrawGraphics();
               g.fillRect(0,0, width, height);
               bs.show();
               g.dispose();
         }
         public void run(){
             init();
             while(running){
                 tick();
                 render();
             }
             stop();
         }

         public synchronized void start(){
             if(running)
                 return;
             running=true;
             thread = new Thread(this);
             thread.start();

         }
         public synchronized void stop(){
             if(!running)
                 return;
             try{
                 thread.join();
             }
             catch(InterruptedException e){
                 e.printStackTrace();
             }
         }
}
