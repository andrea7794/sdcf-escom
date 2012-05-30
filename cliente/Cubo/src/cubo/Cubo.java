/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cubo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author PRETXEL
 */

    /**
     * @param args the command line arguments
     */       
public class Cubo extends Canvas implements ActionListener, ChangeListener, MouseListener, MouseMotionListener {
    Graphics g;
    Objeto obj;// = new Objeto();
    JFrame f;
    int centerX;
    int centerY;
    int despX;
    int despY;
    int profundidad;
    float eX;
    float eY;
    float eZ;
    float eX1;
    float eY1;
    JPanel contiene1;
    JPanel contiene2;
    JPanel sur;
    JPanel oeste;
    JPanel este;
    JPanel X;
    JPanel Y;
    JPanel Z;
    JButton cubo;
    JButton piramide;
    JButton prisma;
    JSlider Sgx;
    JSlider Sgx1;
    JSlider Sgy;
    JSlider Sgy1;
    JSlider Sgz;
    JSlider Sgz1;
    
    public Cubo(){
        obj = new Objeto();
        obj.cubo();
        
        f = new JFrame("Cubito");
        
        eX = 0F;
        eY = 0F;
        profundidad = 0;
        
        contiene1 = new JPanel (new BorderLayout ());
        contiene2 = new JPanel (new BorderLayout ());
        sur = new JPanel (new GridLayout (1, 3, 5, 5));
        oeste = new JPanel (new GridLayout (3, 1, 5, 5));
        este = new JPanel (new GridLayout (3, 1, 5, 5));
        X = new JPanel (new GridLayout (2, 1, 5, 5));
        Y = new JPanel (new GridLayout (1, 2, 5, 5));
        Z = new JPanel ();
        
        cubo = new JButton ("Cubo");
        piramide = new JButton ("Piramide");
        prisma = new JButton ("Prisma");
        
        Sgx = new JSlider (JSlider.HORIZONTAL, 0, 1000, 0);
        Sgx.setBorder(BorderFactory.createTitledBorder(" Girar en el eje X"));
        Sgx1 = new JSlider (JSlider.HORIZONTAL, -500, 500, 0);
        Sgx1.setBorder(BorderFactory.createTitledBorder("Desplazar en X"));
        X.add(Sgx);
        X.add(Sgx1);
        
        Sgy = new JSlider (JSlider.VERTICAL, 0, 1000, 0);
        Sgy.setBorder(BorderFactory.createTitledBorder(" Girar en el eje "));
        Sgy1 = new JSlider (JSlider.VERTICAL, -500, 500, 0);
        Sgy1.setBorder(BorderFactory.createTitledBorder(" Desplazar "));
        Y.add(Sgy); 
        Y.add(Sgy1);
        
        Sgz = new JSlider (JSlider.VERTICAL, 0, 1000, 0);
        Sgz.setBorder(BorderFactory.createTitledBorder(" Girar Z "));
        Sgz1 = new JSlider (JSlider.VERTICAL, 0, 1000, 0);
        Sgz1.setBorder(BorderFactory.createTitledBorder(" Girar Z "));
        Z.add(Sgz);
        Z.add(Sgz1);
        
        cubo.addActionListener(this);
        piramide.addActionListener(this);
        prisma.addActionListener(this);
        
        Sgx.addChangeListener (this);
        Sgx1.addChangeListener (this);
        Sgy.addChangeListener (this);
        Sgy1.addChangeListener (this);
        Sgz.addChangeListener (this);
        Sgz1.addChangeListener (this);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        X.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Movimientos en el eje X", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BELOW_TOP,new Font("Century Gothic", 1, 12), new Color(255, 255, 0)), BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        Y.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Movimientos en el eje Y", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BELOW_TOP,new Font("Century Gothic", 1, 12), new Color(255, 255, 0)), BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        Z.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Movimientos en el eje Z", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BELOW_TOP,new Font("Century Gothic", 1, 12), new Color(255, 255, 0)), BorderFactory.createBevelBorder(BevelBorder.RAISED)));
//        X.setBackground(Color.BLACK);
  //    Y.setBackground(Color.BLACK);
   //     Z.setBackground(Color.BLACK);
        
        oeste.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Figura:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BELOW_TOP,new Font("Century Gothic", 1, 12), new Color(255, 255, 0)), BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        //oeste.setBackground(new Color(0, 0, 255));
        oeste.add(cubo);
        oeste.add(piramide);
        oeste.add(prisma);
        
        este.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Figura:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BELOW_TOP,new Font("Century Gothic", 1, 12), new Color(255, 255, 0)), BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        //este.setBackground(new Color(0, 0, 255));
        este.add(new Button("Cubo"));
        este.add(new Button("Piramide"));
        este.add(new Button(" "));
        
        //sur.setBorder(new TitledBorder(" MOVIMIENTOS en el EJE "));
        //sur.setBorder(BorderFactory.createCompoundBorder());
        //sur.setBorder(BorderFactory.createTitledBorder(null, "MOVIMIENTOS", TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Century Gothic", 1, 10), new Color(255, 255, 0)));
        sur.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Movimientos", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BELOW_TOP,new Font("Century Gothic", 1, 12), new Color(255, 255, 0)), BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        //sur.setBackground(Color.BLUE);
        sur.add(X);
        sur.add(Y);
        sur.add(Z);
        
        contiene2.setBorder(BorderFactory.createMatteBorder(3, 7, 7, 3, new Color(255, 0, 0)));
        contiene2.add("Center", this);
        contiene2.add("West", oeste);
        //contiene2.add("East", este);
        contiene2.add("South", sur);
        
        //contiene1.setBackground(Color.BLACK);
        contiene1.add(contiene2);
        contiene1.add ("North", new Label (""));
        contiene1.add ("West", new Label (""));
        //contiene1.add ("East", new Label (""));
        contiene1.add ("South", new Label (""));
        f.add("Center", contiene1); //new Apariencia());
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        f.setSize(1100, 700);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    
    public void relleno(Graphics g, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8 ){
        this.g = g;
        Point2D p1 = obj.vScr[i1]; //0
        Point2D q1 = obj.vScr[i2]; //1
        Point2D p2 = obj.vScr[i3];
        Point2D q2 = obj.vScr[i4]; //2
        Point2D p3 = obj.vScr[i5]; 
        Point2D q3 = obj.vScr[i6]; //3
        Point2D p4 = obj.vScr[i7];
        Point2D q4 = obj.vScr[i8];
        g.setColor(Color.RED);
       
        int x[]=new int[4];
        int y[]=new int[4];
        
        x[0]=iX(p1.x);
        x[1]=iX(q1.x);
        x[2]=iX(q2.x);
        x[3]=iX(q3.x);
        
        x[0]=iY(p1.y);
        x[1]=iY(q1.y);
        x[2]=iY(q2.y);
        x[3]=iY(q3.y);
        g.setColor(Color.BLUE);
        g.fillPolygon(x, y, 4);
      System.out.println(x[0]);
    }
    
    
    
    
    public void line(Graphics g, int i, int j){
        this.g = g;
        Point2D p = obj.vScr[i];
        Point2D q = obj.vScr[j];
        g.setColor(Color.RED);
        g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
       
        int x[] = new int[4];
        int y[] = new int[4];
        x[0]=50;
        x[1]=100;
        x[2]=100;
        x[3]=50;
        y[0]=100;
        y[1]=100;
        y[2]=300;
        y[3]=300;
        g.fillPolygon(x,y,4);
    }
    
    public void paint(Graphics g){
        this.g = g;
        Dimension dim = getSize();
        int maxX = dim.width - 1;
        int maxY = dim.height - 1;
        int minMaxXY = Math.min(maxX, maxY);
        
        centerX = maxX/2;
        centerY = maxY/2;
        obj.d = obj.rho * minMaxXY / obj.objSize;//profundidad;
        //obj.perspectiva();
        obj.perspectiva(eX, eY);
        
        line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); //aristas horizontales inferiores
        relleno(g, 0, 1, 1, 2, 2 ,3, 3, 0); 
        line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); //aristas horizontales superiores
        line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); //aristas verticales

    }
    int iX(float x){
        return Math.round(centerX + despX + x);
    }
    
    int iY(float y){
        return Math.round(centerY + despY - y);
    }
    
    void formato (Container c, String tipo, Color color) {
        c.setFont(new Font(tipo, 1, 12)); // NOI18N
        c.setForeground(color);
    }
    
    public static void main(String [] args){
        new Cubo();
    }

    public void actionPerformed (ActionEvent e) {
        JButton b = (JButton) e.getSource();        
        if (b == cubo) {
            obj.cubo();
            repaint ();
        }
        if (b == piramide) {
            obj.piramide();
            repaint ();
        }
        if (b == prisma) {
            obj.prisma();
            repaint ();
        }
    }
    
    public void stateChanged(ChangeEvent e) {
        JSlider s = (JSlider)e.getSource();
        
        if (Sgx == s) {
            eX1 = (float) ((Sgx.getValue() / 10));
        }
        if (Sgx1 == s) {
            despX = getX() + Sgx1.getValue();
        }
        if (Sgy == s) {
            eY1 = (float) ((Sgy.getValue() / 10));
        }
        if (Sgy1 == s) {
            despY = getY() - Sgy1.getValue();
        }
        if (Sgz == s) {
            eX1 = eY1 = (float) ((Sgz.getValue() / 10));
        }
        if (Sgz1 == s) {
            profundidad = Sgz1.getValue();
        }
        
        eX = eX1 / 10;
        eY = eY1 / 10;
		
        paint(g);
        repaint();
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {        
        despX = e.getX() - centerX;
        despY = e.getY() - centerY;
		
        Sgx1.setValue(despX);
        Sgy1.setValue(-despY);
		
        repaint ();
    }
    public void mouseMoved(MouseEvent e) {}
}

class Objeto{	// Posee los datos del objeto 3D
    //theta .. movimiento en x
    //phi .... movimiento en y.
    float d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; //Elementos de la matriz V
    float rho;
    float theta;// = 0.3F;
    float phi;// = 1.3F;
    Point3D [] w;	//Coordenadas universales 
    Point2D [] vScr;	//Coordenadas de la pantalla
    
    Objeto(){        
        w =  new Point3D[8];
        vScr = new Point2D[8];
        /*w[0] = new Point3D( 1, -1, -1);	// Desde la base: x, y, z.
        w[1] = new Point3D( 1,  1, -1);
        w[2] = new Point3D(-1,  1, -1);
        w[3] = new Point3D(-1, -1, -1);
        w[4] = new Point3D( 1, -1,  1);	// Desde la tapa
        w[5] = new Point3D( 1,  1,  1);
        w[6] = new Point3D(-1,  1,  1);
        w[7] = new Point3D(-1, -1,  1);*/
        
        objSize = (float) Math.sqrt(12F);	//= sqrt(2*2 + 2*2 + 2*2) es la distancia entre dos vertices opuestos
        rho = 2 * objSize;			//Asigna una perspectiva de fuga
    }
    public void cubo () {
        w[0] = new Point3D( 1, -1, -1);	// Desde la base: x, y, z.
        w[1] = new Point3D( 1,  1, -1);
        w[2] = new Point3D(-1,  1, -1);
        w[3] = new Point3D(-1, -1, -1);
        w[4] = new Point3D( 1, -1, 1);	// Desde la tapa
        w[5] = new Point3D( 1,  1, 1);
        w[6] = new Point3D(-1,  1, 1);
        w[7] = new Point3D(-1, -1, 1);
    }
    public void piramide () {
        w[0] = new Point3D( 1, -1, -1);	// Desde la base: x, y, z.
        w[1] = new Point3D( 1,  1, -1);
        w[2] = new Point3D(-1,  1, -1);
        w[3] = new Point3D(-1, -1, -1);
        w[4] = new Point3D( 0, 0, 1);	// Desde la tapa
        w[5] = new Point3D( 0, 0, 1);
        w[6] = new Point3D( 0, 0, 1);
        w[7] = new Point3D( 0, 0, 1);
    }
    public void prisma () {
        w[0] = new Point3D( 1, -1, -1);	// Desde la base: x, y, z.
        w[1] = new Point3D( 1,  1, -1);
        w[2] = new Point3D(-1,  0, -1);
        w[3] = new Point3D(-1, -0, -1);
        w[4] = new Point3D( 1, -1, 1);	// Desde la tapa
        w[5] = new Point3D( 1,  1, 1);
        w[6] = new Point3D(-1,  0, 1);
        w[7] = new Point3D(-1, -0, 1);
    }
    
    public void initPersp(float theta1, float phi1){
        theta = theta1;
        phi = phi1;
        
        float costh = (float) Math.cos(theta);
        float sinth = (float) Math.sin(theta);
        float cosph = (float) Math.cos(phi);
        float sinph = (float) Math.sin(phi);
        
        v11 = -sinth;   v12 = -cosph*costh; v13 = sinph*costh;
        v21 = costh;    v22 = -cosph*sinth; v23 = sinph*sinth;
        v43 = -rho;     v32 = sinph;        v33 = cosph;
        
        /*System.out.println("Costh = " + costh);
        System.out.println("sinth = " + sinth);
        System.out.println("cosph = " + cosph);
        System.out.println("sinph = " + sinph);
        System.out.println("v11 = " + v11);
        System.out.println("v12 = " + v12);
        System.out.println("v13 = " + v13);
        System.out.println("v21 = " + v21);
        System.out.println("v22 = " + v22);
        System.out.println("v23 = " + v23);
        System.out.println("v32 = " + v32);
        System.out.println("v33 = " + v33);
        System.out.println("v43 = " + v43);*/
    }
    public void perspectiva(float theta1, float phi1){
        initPersp(theta1, phi1);
        
        for(int i = 0; i < 8; i++){
            Point3D p = w[i];
            float x = v11*p.x + v21*p.y;
            float y = v12*p.x + v22*p.y + v32*p.z;
            float z = v13*p.x + v23*p.y + v33*p.z + v43;
            
            vScr[i] = new Point2D(-d*x/z, -d*y/z);           
        }
    }
}
class Point2D{
    float x, y;
    Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }
}
class Point3D{
    float x, y, z;
    Point3D(double x, double y, double z){
        this.x = (float)x; 
        this.y = (float)y; 
        this.z = (float)z;
    }
}
    

