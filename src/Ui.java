
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Ui {

    private JFrame window;
    private File[] files;
    private UiDisplay display;
    private UiLogic uiLogic;

    public Ui() throws IOException, ParseException {
        this.window = new JFrame("Radar");
        this.files = new File("src/data").listFiles();
        this.uiLogic = new UiLogic();
        if (files != null)
        {
            this.uiLogic.loadImage(files[0]);
        }
        this.display = new UiDisplay(
                uiLogic.getParser().getBitmap().length,
                uiLogic.getParser().getBitmap()[0].length,
                ImageIO.read(files[0]),
                (ArrayList<Entity>) uiLogic.getEntityManager().getEntitiesList()
        );
    }

    public void init() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(display);
        window.pack();
        window.setResizable(false);
        window.setVisible(true);
    }

    public void run() throws IOException, ParseException
    {
        display.repaint();
        for (int i = 1; i < files.length; i++)
        {
            uiLogic.loadImage(files[i]);
            display.setImage(ImageIO.read(files[i]));
            display.repaint();
        }
    }

}
