import java.util.List;
import java.sql.Timestamp;


public class Ufo {
    private double[] center;
    private double[] deviation;
    private Timestamp time;

    public Ufo(double[] center, double[] deviation, Timestamp time) {
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
        System.out.println();
        System.out.println("Time: " + this.time);
        System.out.println("Center: " + this.center[0] + " " + this.center[1]);
        System.out.println("Deviation: " + this.deviation[0] + " " + this.deviation[1]);
    }

    public double calculateG(Ufo ufo)
    {
        return Math.exp(-Math.pow(ufo.getCenter()[0] - this.center[0], 2) / (10 * Math.pow(this.getDeviation()[0], 2))) * Math.exp(-Math.pow(ufo.getCenter()[1] - this.center[1], 2) / (10 * Math.pow(this.getDeviation()[1], 2)));
    }


}
