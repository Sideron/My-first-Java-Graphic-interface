package window2;
import java.awt.Color;
import java.awt.Graphics;
public class Pixel extends Object{
    public float size;
    public float intensity;
    private Color color;
    private boolean on = true;
    private float mint = 0.6f;
    public Pixel(){
        super(0,0);
        size = 20;
        intensity = (float)(Math.random()*mint);
        color = new Color(255, 255, 255, (int)(this.intensity*255));
    }
    public Pixel(float x, float y, float size, float intensity){
        super(x,y);
        this.size = size;
        this.intensity = intensity;
        this.color = new Color(255, 255, 255, (int)(this.intensity*255));
        if(intensity >= mint){
            this.on = false;
        }
    }
    public void update(){
        super.update();
        if(intensity >= mint){
            on = false;
        }else if(intensity-0.003 <= 0){ on = true;}
        if(on){
            intensity += 0.005;
        }else{
            intensity -= 0.003;
        }
        color = new Color(255, 255, 255, (int)(this.intensity*255));
    }
    public void display(Graphics g){
        super.display(g);
        g.setColor(color);
        g.fillRect((int)x, (int)y, (int)size, (int)size);
    }
}
