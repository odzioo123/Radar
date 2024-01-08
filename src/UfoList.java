import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
public class UfoList {
    private List<Ufo> ufoList;
    public UfoList(Clasterer clasterer, Timestamp time) {
        this.ufoList = new ArrayList<>();

        List<List<int[]>> clusters = clasterer.getClusters();
        for (List<int[]> cluster : clusters) {
            double[] average = new double[2];
            average[0] = getAverageX(cluster);
            average[1] = getAverageY(cluster);
            double[] deviation = new double[2];
            deviation[0] = getDeviationX(cluster, average[0]);
            deviation[1] = getDeviationY(cluster, average[1]);
            Ufo ufo = new Ufo(average, deviation, time);
            ufoList.add(ufo);
        }
    }

    public static double getAverageX(List<int[]> cluster)
    {
        double sum = 0;
        int i = 0;
        for(int[] point : cluster)
        {
            i++;
            sum = sum + point[0];
        }
        return sum/i;
    }
    public static double getAverageY(List<int[]> cluster)
    {
        double sum = 0;
        int i = 0;
        for(int[] point : cluster)
        {
            i++;
            sum = sum + point[1];
        }
        return sum/i;
    }

    public static double getDeviationX(List<int[]> cluster, double average)
    {
        double sum = 0;
        int i = 0;
        for(int[] point : cluster)
        {
            i++;
            sum = sum + Math.pow((point[0] - average), 2);
        }
        return Math.pow(sum/i, 1./2);
    }
    public static double getDeviationY(List<int[]> cluster, double average)
    {
        double sum = 0;
        int i = 0;
        for(int[] point : cluster)
        {
            i++;
            sum = sum + Math.pow((point[1] - average), 2);
        }
        return Math.pow(sum/i, 1./2);
    }

    public List<Ufo> getUfoList() {
        return ufoList;
    }

    public void setUfoList(List<Ufo> ufoList) {
        this.ufoList = ufoList;
    }
}
