/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;




public class FrameMvd implements KeyListener  {
    static boolean continueRun = true;
    int stop =0;
    KeyListenerFrame a = new KeyListenerFrame();
    JFrame fmvd = new JFrame("");
    JLabel lblImg;
    int N =24,j=-1;
    ImageIcon img[]=new ImageIcon[N];
    int ascissa=10,ordinata=150;



    FrameMvd (){
        fmvd.addKeyListener(this);
        fmvd.setBounds(ascissa,ordinata,160,260);
        fmvd.setDefaultCloseOperation(fmvd.EXIT_ON_CLOSE);

        for (int i = 0; i < 24; i++) {
            img[i]= new ImageIcon((i+1)+".png");
        }

        lblImg = new JLabel("start");

        fmvd.add(lblImg);
        lblImg.setIcon(img[0]);

        fmvd.setUndecorated(true);
        fmvd.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        fmvd.setVisible(true);
    }


    public Thread newThread() {
        Thread thread = new Thread() {
            public void run() {
                while (continueRun) {
                    if (j < 23) {
                        j++;
                        lblImg.setIcon(img[j]);
                        if (j == 23) {
                            j = 0;
                        }
                    }
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ascissa += Integer.parseInt(a.dX.getText());
                    a.xLbl.setText(Integer.toString(ascissa));
                    if (ascissa >= 1500) {
                        ascissa = -100;
                    }
                    fmvd.setLocation(ascissa, ordinata);

                }
            }
        };
        return thread;
    }
   //thread.start();

    Thread ne;





    public void moveForward(){
        if (j<23){
            j++;
            lblImg.setIcon(img[j]);
            if (j==23){
                j=0;
            }
        }
        ascissa += Integer.parseInt(a.dX.getText());
        a.xLbl.setText(Integer.toString(ascissa));
        if (ascissa>=1500){
            ascissa = -100;
        }
        fmvd.setLocation(ascissa,ordinata);

    }


    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    
    public void keyPressed(KeyEvent ke) {

        //INIZIO AUTOMATIC
        if (a.automatic.isSelected()) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if(stop==0) {
                    ne = newThread();
                    ne.start();
                    stop++;
                }else{
                    ne.stop();
                    stop--;
                }
            }
            /*if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                ne.stop();
            }*/
        }
        //INIZIO ANALOGUE
        
        if (a.analogue.isSelected()){
            if (ke.getKeyCode()==KeyEvent.VK_UP){
                if (ordinata>=0){
                    ordinata -= Integer.parseInt(a.dY.getText());
                    a.yLbl.setText(Integer.toString(ordinata));
                    fmvd.setLocation(ascissa,ordinata);
                }
            }
            if (ke.getKeyCode()==KeyEvent.VK_DOWN){
                ordinata += Integer.parseInt(a.dY.getText());
                a.yLbl.setText(Integer.toString(ordinata)); 
                fmvd.setLocation(ascissa,ordinata);
            }
            if (ke.getKeyCode()==KeyEvent.VK_LEFT){
                if (ascissa>=0){
                    if (j>0){
                        j--;
                        lblImg.setIcon(img[j]);
                        if (j==0){
                            j=23;
                        }
                    }
                    ascissa -= Integer.parseInt(a.dX.getText());
                    a.xLbl.setText(Integer.toString(ascissa));
                    if (ascissa<=-45){
                        ascissa = 1450;
                    }
                    fmvd.setLocation(ascissa,ordinata);

                }
            }
            if (ke.getKeyCode()==KeyEvent.VK_RIGHT){
                moveForward();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
    
    public static void main(String[] args)
    {
        new FrameMvd();
    }
    
}
