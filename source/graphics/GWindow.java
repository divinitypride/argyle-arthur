 // @author Jarrod
package graphics;

import entity.Entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Math.*;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import main.TriggerEvent;
import main.World;

public class GWindow extends JFrame {

    private World world;
    private GraphicsHandle gh;

    public GWindow(World world) {

        this.world = world;
        gh = new GraphicsHandle(world);
        this.add(gh);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(world.getFocusWidth(), world.getFocusHeight());
        setLocationRelativeTo(null);
        setTitle("ArgyleArthur");
        setResizable(false);
    }

    private class GraphicsHandle extends JPanel implements ActionListener {

        private Timer timer;
        private World world;

        public GraphicsHandle(World world) {
            this.world = world;
            this.initComponents();
        }

        private void initComponents() {
            addKeyListener(new KAdapter());
            addMouseListener(new MAdapter());
            setFocusable(true);
            setOpaque(true);
            setBackground(Color.BLACK);
            setDoubleBuffered(true);

            timer = new Timer(5, this);
            timer.start();
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            super.paintComponent(g2d);
            for(Iterator<Entity> ir = world.getEntities().iterator(); ir.hasNext();) {
                Entity entity = ir.next();
                if (entity.getX() >= world.getFocusX()
                  || entity.getX() <= world.getFocusX() + world.getFocusWidth()
                  || entity.getY() >= world.getFocusY()
                  || entity.getY() <= world.getFocusY() + world.getFocusHeight()) {
                    g2d.drawImage(entity.getImage(), round(entity.getX() - entity.getOriginX()),
                      round(entity.getY() - entity.getOriginY()), this);
                }
            }
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.world.update();
            repaint();
        }


        private class KAdapter extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                world.addTriggerToStack(new TriggerEvent(this, e));
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(e.paramString());
            }
        }

        private class MAdapter extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                world.addTriggerToStack(new TriggerEvent(this, e));
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(e.paramString());
            }
        }
    }
}