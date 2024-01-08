
public class Association implements Comparable<Association> {

    private Entity entity;
    private Ufo ufo;
    private double g;

    public Association(Entity entity, Ufo ufo) {
        this.entity = entity;
        this.ufo = ufo;
        this.g = entity.getPrediction(ufo.getTime()).calculateG(ufo);
    }

    public Entity getEntity() {
        return entity;
    }

    public Ufo getUfo() {
        return ufo;
    }

    public double getG() {
        return g;
    }

    public boolean hasEntity(Entity entity) {
        return this.entity.equals(entity);
    }

    public boolean hasUfo(Ufo ufo) {
        return this.ufo.equals(ufo);
    }

    @Override
    public int compareTo(Association o) {
        if(this.getG() == o.getG())
            return 0;
        return this.getG() > o.getG() ? -1 : 1;
    }
}
