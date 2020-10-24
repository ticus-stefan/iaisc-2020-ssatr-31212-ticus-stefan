import org.json.simple.JSONObject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Place> placesList;
        ArrayList<Transition> transitionsList;
        Loader loader=new Loader();
        JSONObject jsonObject=loader.readJson("petrinet.json");
        placesList=loader.readPlaces(jsonObject);
        transitionsList=loader.readTransitions(jsonObject);
        Simulation s= new Simulation();
        s.run(placesList,transitionsList);
    }
}
