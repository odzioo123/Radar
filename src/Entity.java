import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Entity {
    private List<Ufo> entityList;

    public Entity(List<Ufo> entityList) {
        this.entityList = entityList;
    }
    public Entity() {
        this.entityList = new ArrayList<>();
    }
    public Entity(Ufo ufo) {
        this.entityList = new ArrayList<>();
        entityList.add(ufo);
    }

    public List<Ufo> getEntityList() {
        return entityList;
    }
    public void addToList(Ufo ufo)
    {
        entityList.add(ufo);
    }
    public Ufo getPrediction(Timestamp timestamp)
    {
        double[] deviation = !entityList.isEmpty() ? entityList.get(entityList.size()-1).getDeviation() : new double[2];
        double[] center = new double[2];

        if(entityList.size() == 1)
        {
            return entityList.get(0);
        }
        else if(entityList.size() < 3)
        {
            center[0] = entityList.get(entityList.size()-1).getCenter()[0] - entityList.get(0).getCenter()[0];
            center[1] = entityList.get(entityList.size()-1).getCenter()[1] - entityList.get(0).getCenter()[1];
            long dt = entityList.get(entityList.size()-1).getTime().getTime() - entityList.get(0).getTime().getTime();
            double[] vector = new double[2];
            vector[0] = center[0]/dt;
            vector[1] = center[1]/dt;
            center[0] = entityList.get(entityList.size()-1).getCenter()[0] + vector[0];
            center[1] = entityList.get(entityList.size()-1).getCenter()[1] + vector[1];
            return new Ufo(center, deviation, timestamp);
        }
        else
        {
            int i = 0;
            long[] time = new long[2];
            for (Ufo ufo : entityList.reversed())
            {
                center[0] = center[0] + ufo.getCenter()[0] * Math.pow(-1,i);
                center[1] = center[1] + ufo.getCenter()[1] * Math.pow(-1,i);
                time[i] = ufo.getTime().getTime();
                i++;
                if(i>1)
                    break;
            }
            entityList.reversed();

            long dt = time[0] - time[1];
            double[] vector = new double[2];
            vector[0] = center[0]/dt;
            vector[1] = center[1]/dt;
            center[0] = entityList.reversed().get(0).getCenter()[0] + vector[0];
            entityList.reversed();
            center[1] = entityList.reversed().get(0).getCenter()[1] + vector[1];
            return new Ufo(center, deviation, timestamp);
        }
    }

}
