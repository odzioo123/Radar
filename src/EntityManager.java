import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    List<Entity> entitiesList;

    public EntityManager() {
        this.entitiesList = new ArrayList<Entity>();
    }

    public void firstPhoto(UfoList ufoList)
    {
        for(var ufo : ufoList.getUfoList())
        {
            Entity entity = new Entity();
            entity.addToList(ufo);
            entitiesList.add(entity);
        }
    }

    public void secondPhoto(UfoList ufoList)
    {
        List<Ufo> ufoListCopy = new ArrayList<Ufo>(ufoList.getUfoList());

        for(var entity : entitiesList)
        {
            double[] densityArray = new double[ufoListCopy.size()];
            int i = 0;
            for(var ufo : ufoListCopy)
            {
                double toExpX = (- Math.pow(ufo.getCenter()[0] - entity.getFirst().getCenter()[0], 2)) / ( 2 * entity.getFirst().getDeviation()[0]);
                double densityX = (1./(entity.getFirst().getDeviation()[0] * Math.sqrt(2*Math.PI)) ) * toExpX;

                double toExpY = (- Math.pow(ufo.getCenter()[1] - entity.getFirst().getCenter()[1], 2)) / ( 2 * entity.getFirst().getDeviation()[1]);
                double densityY = (1./(entity.getFirst().getDeviation()[1] * Math.sqrt(2*Math.PI)) ) * toExpY;

                double density = densityX*densityY;
                densityArray[i] = density;
                i++;
            }

            if(densityArray.length == 0)
                break;

            if(densityArray.length == 1)
            {
                entity.addToList(ufoListCopy.getFirst());
                ufoListCopy.remove(ufoListCopy.getFirst());
                continue;
            }

            double max = densityArray[0];
            for (int j = 1; j < densityArray.length; j++)
            {
                if (densityArray[j] > max)
                {
                    max = densityArray[j];
                }
            }

            int k = 0;
            boolean done = false;
            for(var ufo : ufoListCopy)
            {
                k++;
                if(densityArray[k] == max)
                {
                    entity.addToList(ufo);
                    ufoListCopy.remove(ufo);
                    done = true;
                    break;
                }
            }

            if(!done)
            {
                entity.addToList(null);
                System.out.println("nie ma dopasowania do entity");
            }
        }

        if(ufoListCopy.size() > 0)
        {
            for(var ufo : ufoListCopy)
            {
                Entity en = new Entity();
                en.addToList(ufo);
                entitiesList.add(en);
            }
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


}
