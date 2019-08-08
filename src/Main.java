import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JPanel {
    
    public static void main(String agrs[]) {
//              Name: Marcus J Cameron (mc17)
//              Date: 2019-08-04 14:24
//              Project Name: Pathfinding Algorithm
//              Course: ISC3U1
//              About:

    Main application = new Main();

    }

    int mapScale = 20;
    int mapHeight = 30;
    int mapWidth = mapHeight;
    int[][] mapArray = new int[mapHeight][mapWidth];
    Point[] path = new Point[3];
    Point[] unusalbePoints =  new Point[2];

    Point startPosition = new Point(0, 0);
    Point destinationPosition = new Point(mapHeight - 1, mapWidth - 1);
    int numPoints;
            
    Main(){
        path[0] = new Point(0,0);
        path[1] = new Point(9,9);
        path[2] = new Point(5,9);

        JFrame window = new JFrame();
        window.add(this);
        window.setTitle("Pathfinding Algorithm");
        window.setSize(625, 705);
        window.setLocation(400,100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        JButton startBtn = new JButton();
        startBtn.setText("Start Pathfinder");
        startBtn.setFocusable(false);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("finding path now");
            }
        });
        startBtn.setLocation(-5, -70);
        startBtn.setBorderPainted(true);
        startBtn.setSize(220, 50);
        startBtn.setOpaque(false);
        startBtn.setFont(new Font("serif", 0, 20));
        this.add(startBtn, null);

        path[0] = new Point(0, 0);
        numPoints = path.length;

        createMap();
        repaint();

    }

    void createMap(){

        for (int x = 0; x < mapWidth; x++){
            for(int y = 0; y < mapHeight; y++){
                mapArray[x][y] = new Random().nextInt(2);
            }
        }

        mapArray[0][0] = 0;
        mapArray[destinationPosition.x][destinationPosition.y] = 0;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(20, 80);

        for (int x = 0; x < mapWidth; x++){
            for(int y = 0; y < mapHeight; y++){

                if (mapArray[x][y] == 1){
                    g.setColor(Color.BLACK);
                    drawPoint(g, x, y);
                }
            }
        }

        g.setColor(Color.red);
        drawPoint(g, destinationPosition.x, destinationPosition.y);

        drawPathLines(g);

    }

    void drawPoint(Graphics g, int x, int y){
        g.fillOval((x * mapScale) - (mapScale / 5), (y * mapScale) - (mapScale / 5), (mapScale / 5) * 3, (mapScale / 5) * 3 );
    }

    void drawPathLines(Graphics g){

        numPoints = path.length;

        Color lineColor = Color.getHSBColor((float)0.81, (float)1.0, (float)0.81);
        g.setColor(lineColor);

        drawPoint(g ,startPosition.x ,startPosition.y);

        if (numPoints > 1) {

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(6));

            for (int i = 0; i < numPoints - 1; i++){
                g2.drawLine(path[i].x * mapScale, path[i].y * mapScale, path[i + 1].x * mapScale, path[i + 1].y * mapScale);
                drawPoint(g2,path[i + 1].x, path[i + 1].y );
            }
        }

    }



    void findPath(Point currentPoint, Point destinationPoint){




    }
}