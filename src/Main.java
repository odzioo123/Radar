import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        String path = "202401061709.png";
        Parser parser = new Parser(path);
//        parser.printBinaryBitmap();
        Clasterer clasterer = new Clasterer(parser.getBitmap());
        clasterer.swapXY();
//        clasterer.printClusters();
        UfoList ufoList = new UfoList(clasterer, Parser.convertStringToTimestamp(path));

        for (Ufo ufo: ufoList.getUfoList()) {
            ufo.printUfo();
        };


//        String path2 = "202401061702.png";
//        Parser parser2 = new Parser(path2);
////        parser.printBinaryBitmap();
//        Clasterer clasterer2 = new Clasterer(parser2.getBitmap());
////        clasterer.printClusters();
//        UfoList ufoList2 = new UfoList(clasterer2, Parser.convertStringToTimestamp(path2));
//
//
//        EntityManager manager = new EntityManager();
//        manager.firstPhoto(ufoList);
//        manager.secondPhoto(ufoList2);
//        manager.printEntities();


























//        int[][] exampleBitmap = {
//                {1, 0, 1, 0, 0},
//                {1, 1, 0, 1, 0},
//                {0, 0, 1, 0, 0},
//                {0, 1, 0, 1, 1},
//                {1, 1, 1, 0, 0}
//        };
//
//
//        Clasterer clasterer = new Clasterer(exampleBitmap);
//        clasterer.printClusters();


    }

}