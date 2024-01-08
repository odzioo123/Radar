
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class UiLogic {
    private Parser parser;
    private Clasterer clasterer;
    private UfoList ufoList;
    private EntityManager entityManager;

    public void loadImage(File file) throws IOException, ParseException {

        parser = new Parser(file.getName());
        clasterer =  new Clasterer(parser.getBitmap());
        clasterer.swapXY();
        ufoList = new UfoList(clasterer, Parser.convertStringToTimestamp(file.getName()));
        if (entityManager == null)
        {
            entityManager = new EntityManager();
            entityManager.firstPhase(ufoList);
        }
        else
        {
            entityManager.secondPhase(ufoList);
        }
    }

    public Parser getParser() {
        return parser;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
