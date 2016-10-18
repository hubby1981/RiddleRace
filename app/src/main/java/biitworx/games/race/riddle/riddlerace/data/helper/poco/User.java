package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import biitworx.games.race.riddle.riddlerace.R;
import biitworx.games.race.riddle.riddlerace.TE;
import biitworx.games.race.riddle.riddlerace.data.helper.BaseDataObject;
import biitworx.games.race.riddle.riddlerace.data.helper.DbField;
import biitworx.games.race.riddle.riddlerace.data.helper.DbTable;

/**
 * Created by marcel.weissgerber on 18.10.2016.
 */
@DbTable(name = "user")
public class User extends BaseDataObject {

    @DbField(name = "name")
    private String name;

    @DbField(name = "mail")
    private String mail;

    @DbField(name = "editor")
    private boolean editor = false;

    @DbField(name="tutorial")
    public boolean tutorial = true;

    @DbField(name="level")
    public String level = TE.get(R.string.bundle_basic);

    @Override
    protected void imported() {

    }

    public User() {

    }

    public User(String name,String mail){
        this.name=name;
        this.mail=mail;
    }


    public String getLevel(){
        return level;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public boolean isEditor() {
        return editor;
    }

    public boolean isTutorial() {
        return tutorial;
    }
}
