package biitworx.games.race.riddle.riddlerace.levels.basic;


import android.os.Bundle;

import biitworx.games.race.riddle.riddlerace.CircleView;
import biitworx.games.race.riddle.riddlerace.LevelChooser;
import biitworx.games.race.riddle.riddlerace.MainView;
import biitworx.games.race.riddle.riddlerace.PlacementCircleView;
import biitworx.games.race.riddle.riddlerace.R;
import biitworx.games.race.riddle.riddlerace.TE;

public class LevelPlay extends MainView {


    @Override
    protected void initViews() {

        getPlacementCircleView(LevelChooser.levelItem.getName());



    }


}
