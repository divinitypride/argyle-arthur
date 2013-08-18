 // @author Jarrod
package graphics;

import interfaces.IView;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import main.Main;
import main.TriggerEvent;

public class GWindow extends JFrame {

    private GraphicsHandle gh;

    public GWindow() {

        gh = new GraphicsHandle();
        this.add(gh);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Main.WORLD.getWindow().getX(), Main.WORLD.getWindow().getY());
        setLocationRelativeTo(null);
        setTitle("Project NewRTS");
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
            super.paintComponent(g);
            IView view = Main.getView();
            view.render(g);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Main.WORLD.update();
            repaint();
        }

        private class KAdapter extends KeyAdapter {

            @Override
            public void keyPressed(KeyEvent e) {
                Main.STORE.setKey(e, true);
                Main.WORLD.addTriggerToStack(new TriggerEvent(this, e));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Main.STORE.setKey(e, false);
            }
        }

        private class MAdapter extends MouseAdapter {

            @Override
            public void mouseClicked(MouseEvent e) {
                Main.WORLD.addTriggerToStack(new TriggerEvent(this, e));
            }
        }
    }
}
