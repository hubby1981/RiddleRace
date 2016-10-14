package biitworx.games.race.riddle.riddlerace.levels.basic.bundle;

import java.util.HashMap;

/**
 * Created by marcel.weissgerber on 13.10.2016.
 */

public class Bundles {

    private static HashMap<String,LevelBundle> bundles = new HashMap<>();
    static{
        bundles.put("basic",new BasicBundle());
    }

    public static LevelBundle get(String name){
        return bundles.get(name);
    }


    public static Class getByName(String name){

        for(LevelBundle b : bundles.values()){
           Class result = b.getByName(name);
            if(result!=null)
                return result;
        }

        return null;
    }

    public static LevelBundle.InternalLevel getByNameLevel(String name){

        for(LevelBundle b : bundles.values()){
            LevelBundle.InternalLevel result = b.nextIndexOf(name);
            if(result!=null)
                return result;

        }

        return null;
    }


}
