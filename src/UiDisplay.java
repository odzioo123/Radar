
import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;



public class UiDisplay extends JPanel{
    private ArrayList<Entity> entitiesList;
    private Image image;

    public UiDisplay(int width, int height, Image image, ArrayList<Entity> entitiesList) {
        setPreferredSize(new Dimension(width, height));
        this.entitiesList = entitiesList;
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

        for (Entity entity: entitiesList)
        {
            Ufo previousUfo = null;
            for (Ufo ufo: entity.getEntityList())
            {
                graphics.setColor(Color.BLUE);
                if (previousUfo != null)
                {
                    graphics.drawLine((int) previousUfo.getCenter()[0], (int) previousUfo.getCenter()[1], (int) ufo.getCenter()[0], (int) ufo.getCenter()[1]);
                }
                previousUfo = ufo;
            }
        }
    }
}
