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

    public List<Ufo> getEntityList() {
        return entityList;
    }
    public void addToList(Ufo ufo)
    {
        entityList.add(ufo);
    }
    public Ufo getFirst()
    {
        return entityList.getFirst();
    }

}
