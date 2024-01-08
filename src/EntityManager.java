import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EntityManager {
    List<Entity> entitiesList;

    public EntityManager() {
        this.entitiesList = new ArrayList<Entity>();
    }

    public void firstPhase(UfoList ufoList)
    {
        for(var ufo : ufoList.getUfoList())
        {
            Entity entity = new Entity();
            entity.addToList(ufo);
            entitiesList.add(entity);
        }
    }

    public void secondPhase(UfoList ufoList)
    {
        List<Association> associations = new ArrayList<>();

        for(var entity : entitiesList)
        {
            for(Ufo ufo : ufoList.getUfoList())
            {
                associations.add(new Association(entity, ufo));
            }
        }

        associations.removeIf(object -> object.getG() < 0.5e-8);
        Collections.sort(associations);

        List<Entity> usedEntity = new ArrayList<>();
        List<Ufo> usedUfo = new ArrayList<>();

        Iterator<Association> iterator = associations.iterator();
        while (iterator.hasNext())
        {
            Association association = iterator.next();

            if(usedEntity.contains(association.getEntity()))
            {
                iterator.remove();
                continue;
            }

            if(usedUfo.contains(association.getUfo()))
            {
                iterator.remove();
                continue;
            }

            association.getEntity().addToList(association.getUfo());
            usedEntity.add(association.getEntity());
            usedUfo.add(association.getUfo());
            ufoList.getUfoList().remove(association.getUfo());
        }

        this.entitiesList = usedEntity;

        for(Ufo ufo : ufoList.getUfoList())
        {
            this.entitiesList.add(new Entity(ufo));
        }

    }

    public void printEntities()
    {
        int i = 0;
        for(Entity entity : entitiesList)
        {
            System.out.println("\nEntity " + ++i + ": ");
            for (var ufo: entity.getEntityList())
            {
                ufo.printUfo();
            }
        }
    }

    public List<Entity> getEntitiesList() {
        return entitiesList;
    }
}
