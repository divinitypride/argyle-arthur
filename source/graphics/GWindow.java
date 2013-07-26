 // @author Jarrod
package graphics;

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
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import main.Main;
import main.TriggerEvent;
import main.World;
import map.Map;
import tile.Tile;
import unit.Unit;
import unit.part.Part;

public class GWindow extends JFrame {

    private GraphicsHandle gh;

    public GWindow() {

        gh = new GraphicsHandle();
        this.add(gh);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Main.WORLD.getWindow().getX(), Main.WORLD.getWindow().getY());
        setLocationRelativeTo(null);
        setTitle("ArgyleArthur");
        setResizable(false);
    }

    private class GraphicsHandle extends JPanel implements ActionListener {

        private Timer timer;

        public GraphicsHandle() {
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
            requestFocusInWindow();
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            super.paintComponent(g2d);
            AffineTransform transform = new AffineTransform();
            Map map = Main.WORLD.getMap();
            Tile[][][] tileMap = map.getTileMap();
            Unit[][][] unitMap = map.getUnitMap();
            for(int j = 0; j < map.getDimensions().getX(); j += 1) {
                for(int k = 0; k < map.getDimensions().getY(); k += 1) {
                    for(int l = 0; l < map.getDimensions().getZ(); l += 1) {
                        try {
                            g2d.drawImage(Map.TILE_DEBUG.getImage(), main.Transform.transform(0, j * 16, k * 16, l * 16, Main.WORLD.getFocus().getX() * 16, Main.WORLD.getWindow().getY(), Main.WORLD.getFocus().getZ() * 16, Main.WORLD.getZoom()), this);
                            g2d.drawImage(Map.TILE_DEBUG.getImage(), main.Transform.transform(1, j * 16, k * 16, l * 16, Main.WORLD.getFocus().getX() * 16, Main.WORLD.getWindow().getY(), Main.WORLD.getFocus().getZ() * 16, Main.WORLD.getZoom()), this);
                            g2d.drawImage(Map.TILE_DEBUG.getImage(), main.Transform.transform(2, j * 16, k * 16, l * 16, Main.WORLD.getFocus().getX() * 16, Main.WORLD.getWindow().getY(), Main.WORLD.getFocus().getZ() * 16, Main.WORLD.getZoom()), this);
                            if (!unitMap[j][k][l].equals(Map.UNIT_NULL)) {
                                Part[] parts = unitMap[j][k][l].getParts();
                                for(int i = 0; i < parts.length; i += 1) {
                                    Part part = parts[i];
                                    g2d.drawImage(Main.STORE.getSprite(unitMap[j][k][l], i),
                                      main.Transform.transform(part.getAxis(), part.getLocation().getX(), part.getLocation().getY(), part.getLocation().getZ(),
                                      Main.WORLD.getFocus().getX() * 16, Main.WORLD.getFocus().getY() * 16, Main.WORLD.getFocus().getZ() * 16, Main.WORLD.getZoom()), this);
                                }
                            }
                        } catch (IOException ex) {
                        Logger.getLogger(GWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Main.WORLD.update();
            repaint();
        }

        private class KAdapter extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                Main.WORLD.addTriggerToStack(new TriggerEvent(this, e));
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(e.paramString());

                if (e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET) {
                    Main.WORLD.setZoom(Main.WORLD.getZoom()/2);
                }
                if (e.getKeyCode() == KeyEvent.VK_CLOSE_BRACKET) {
                    Main.WORLD.setZoom(Main.WORLD.getZoom()*2);
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Main.WORLD.getFocus().setX(getX() + 1);
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Main.WORLD.getFocus().setX(getX() - 1);
                }

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    Main.WORLD.getFocus().setX(getY() + 1);
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    Main.WORLD.getFocus().setX(getY() - 1);
                }
            }
        }

        private class MAdapter extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main.WORLD.addTriggerToStack(new TriggerEvent(this, e));
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(e.paramString());
            }
        }
    }
}
