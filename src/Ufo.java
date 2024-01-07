import java.util.List;
import java.sql.Timestamp;


public class Ufo {
    private List<int[]> area;
    private double[] center;
    private double[] deviation;
    private Timestamp time;

    public Ufo(List<int[]> area, double[] center, double[] deviation, Timestamp time) {
        this.area = area;
        this.center = center;
        this.deviation = deviation;
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public List<int[]> getArea() {
        return area;
    }

    public void setArea(List<int[]> area) {
        this.area = area;
    }

    public double[] getCenter() {
        return center;
    }

    public void setCenter(double[] center) {
        this.center = center;
    }

    public double[] getDeviation() {
        return deviation;
    }

    public void setDeviation(double[] deviation) {
        this.deviation = deviation;
    }

    public void printUfo()
    {
        System.out.print("Area: ");
        for (var point : this.area)
        {
            System.out.print("x:" + point[0] + " y:" + point[1] + "  ");
        }
        System.out.println();
        System.out.println("Time: " + this.time);
        System.out.println("Center: " + this.center[0] + " " + this.center[1]);
        System.out.println("Deviation: " + this.deviation[0] + " " + this.deviation[1]);
    }
}
