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
//        List<Ufo> ufoListCopy = new ArrayList<Ufo>(ufoList.getUfoList());
        List<Association> associations = new ArrayList<>();

        for(var entity : entitiesList)
        {
            for(Ufo ufo : ufoList.getUfoList())
            {
                associations.add(new Association(entity, ufo));
            }
        }

        associations.removeIf(object -> object.getG() < 0.5e-6);
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







//        for(var entity : entitiesList)
//        {
//            double[] densityArray = new double[ufoListCopy.size()];
//            int i = 0;
//            for(var ufo : ufoListCopy)
//            {
//                double toExpX = (- Math.pow(ufo.getCenter()[0] - entity.getFirst().getCenter()[0], 2)) / ( 2 * Math.pow(Math.PI,5));
//                double densityX = Math.exp(toExpX);
//
//                double toExpY = (- Math.pow(ufo.getCenter()[1] - entity.getFirst().getCenter()[1], 2)) / ( 2 * Math.pow(Math.PI,5));
//                double densityY = Math.exp(toExpY);
//
//                double density = densityX*densityY;
//
//                densityArray[i] = density;
//                i++;
//            }
//
//            if(densityArray.length == 0)
//                break;
//
//            if(densityArray.length == 1)
//            {
//                entity.addToList(ufoListCopy.getFirst());
//                ufoListCopy.remove(ufoListCopy.getFirst());
//                continue;
//            }
//
//            double max = densityArray[0];
//            for (int j = 1; j < densityArray.length; j++)
//            {
//                if (densityArray[j] > max)
//                {
//                    max = densityArray[j];
//                }
//            }
//
//            int k = 0;
//            boolean done = false;
//            for(var ufo : ufoListCopy)
//            {
//                k++;
//                if(densityArray[k] == max)
//                {
//                    entity.addToList(ufo);
//                    ufoListCopy.remove(ufo);
//                    done = true;
//                    break;
//                }
//            }
//
//            if(!done)
//            {
//                entity.addToList(null);
//                System.out.println("nie ma dopasowania do entity");
//            }
//        }
//
//        if(ufoListCopy.size() > 0)
//        {
//            for(var ufo : ufoListCopy)
//            {
//                Entity en = new Entity();
//                en.addToList(ufo);
//                entitiesList.add(en);
//            }
//        }
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
