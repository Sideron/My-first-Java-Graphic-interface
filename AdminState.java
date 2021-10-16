package window2;
import java.awt.Color;
import java.awt.Graphics;
public class AdminState {
    public Object[] instances = new Object[10000];
    public int count = 0;
    public int WIDTH = 750;
    public int HEIGHT = 750;
    public AdminState(){}
    public void start(){
        int ran = 50;
        Point lst = null;
        for(int i = 0; i <= 5; i++){
            Point nPnt = new Point((float)Math.random()*(WIDTH-(ran*2))+ran,(float)Math.random()*(HEIGHT-(ran*2))+ran,lst);
            newObject(nPnt);
            lst = nPnt;
        }
        int gScl = 20;
        for(int x = 0; x < WIDTH/gScl; x++){
            for(int y = 0; y < HEIGHT/gScl; y++){
                newObject(new Pixel(x*gScl, y*gScl, gScl, (float)(Math.random()*0.7)));
            }
        }
    }
    public void update(){
        for(int i = 0; i < instances.length; i++){
            if(instances[i] != null){
                instances[i].update();
            }
        }
    }
    public void draw(Graphics g){
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.white);
        for(int i = 0; i < instances.length; i++){
            if(instances[i] != null){
                instances[i].display(g);
            }
        }
    }
    public void newObject(Object obj){
        if(count < instances.length){
            instances[count] = obj;
            count += 1;
        }else{
            System.out.println("No more objects allowed :(");
        }
    }
}
