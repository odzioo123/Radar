
import javax.swing.*;
import java.awt.*;


public class UiDisplay extends JPanel{
    private EntityManager entityManager;
    private Image image;

    public UiDisplay(int width, int height, Image image, EntityManager entityManager) {
        setPreferredSize(new Dimension(width, height));
        this.entityManager = entityManager;
        this.image = image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(image, 0, 0, null);
        graphics.setColor(Color.BLUE);

        Graphics2D graphics2 = (Graphics2D) graphics;
        graphics2.setStroke(new BasicStroke(3));

        for (Entity entity: entityManager.getEntitiesList())
        {
//            System.out.println(entityManager.getEntitiesList().size());
            Ufo previousUfo = null;
            for (Ufo ufo: entity.getEntityList())
            {
                graphics.setColor(Color.BLUE);
                if (previousUfo != null)
                {
                    graphics2.drawLine((int) previousUfo.getCenter()[0], (int) previousUfo.getCenter()[1], (int) ufo.getCenter()[0], (int) ufo.getCenter()[1]);
                }
                previousUfo = ufo;
            }
        }
    }
}
