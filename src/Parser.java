import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class Parser {
    private int[][] bitmap;

    public int[][] getBitmap() {
        return bitmap;
    }

    public Parser(String path) {
        try
        {
            String mypath = "src\\data\\" + path;
            BufferedImage image = ImageIO.read(new File(mypath));

            if (image == null) {
                throw new IOException("Failed to read the image file.");
            }

            this.bitmap = convertToBinaryBitmap(image);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static int[][] convertToBinaryBitmap(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int[][] binaryBitmap = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Get the RGB value of the current pixel
                int rgb = image.getRGB(x, y);

                // Convert RGB to grayscale
                int gray = (int) (0.299 * ((rgb >> 16) & 0xFF) + 0.587 * ((rgb >> 8) & 0xFF) + 0.114 * (rgb & 0xFF));

                // Convert grayscale value to binary (thresholding)
                binaryBitmap[y][x] = (gray < 128) ? 1 : 0;
            }
        }

        return binaryBitmap;
    }

    public void printBinaryBitmap() {
        for (int[] row : this.bitmap) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public static Timestamp convertStringToTimestamp(String str_date) {
        try {
            int dotIndex = str_date.indexOf('.');
            if (dotIndex != -1) {
                str_date = str_date.substring(0, dotIndex);
            } else {
                System.out.println("String does not contain a dot.");
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
            Date date = formatter.parse(str_date);
            return new Timestamp(date.getTime());

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }

}
