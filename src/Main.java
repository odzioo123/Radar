import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Ui ui = new Ui();
        ui.init();
        ui.run();

//        Parser parser = new Parser("202401071335.png");
//        Clasterer clasterer = new Clasterer(parser.getBitmap());
//        clasterer.swapXY();
////        clasterer.printClusters();
//        UfoList ufoList = new UfoList(clasterer, Parser.convertStringToTimestamp("202401071335.png"));
//
////        for( Ufo ufo : ufoList.getUfoList())
////        {
////            ufo.printUfo();
////        }
//
//        Parser parser2 = new Parser("202401071340.png");
//        Clasterer clasterer2 = new Clasterer(parser2.getBitmap());
//        clasterer2.swapXY();
////        clasterer2.printClusters();
//        UfoList ufoList2 = new UfoList(clasterer2, Parser.convertStringToTimestamp("202401071340.png"));
//
//
//        EntityManager entityManager = new EntityManager();
//        entityManager.firstPhase(ufoList);
//        entityManager.secondPhase(ufoList2);
//        entityManager.printEntities();





    }
}