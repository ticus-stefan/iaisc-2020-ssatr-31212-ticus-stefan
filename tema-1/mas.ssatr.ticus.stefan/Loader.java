import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Loader {
    public Loader() {
    }

    public JSONObject readJson(String filename){
        JSONParser parser= new JSONParser();

        JSONObject jsonObject=null;
        try {
            Object obj=parser.parse(new FileReader(filename));
            jsonObject=(JSONObject) obj;

        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
    public ArrayList<Place> readPlaces(JSONObject jsonObject){
        ArrayList<Place> placesList=new ArrayList<Place>();
        JSONArray places=(JSONArray) jsonObject.get("places");
        Iterator<JSONObject> iterator=places.iterator();
        while (iterator.hasNext()) {
            JSONObject placeJson = iterator.next();
            // System.out.println(placeJson);
            String id = (String) placeJson.get("placeId");
            int tokens=Integer.parseInt((String) placeJson.get("token"));
            placesList.add(new Place(id,tokens));
        }
        return placesList;
    }
    public ArrayList<Transition> readTransitions(JSONObject jsonObject){
        ArrayList<Transition> transitionsList=new ArrayList<Transition>();
        JSONArray transitions=(JSONArray) jsonObject.get("transitions");
        Iterator<JSONObject> iterator1=transitions.iterator();
        while (iterator1.hasNext()) {
            JSONObject transitionJson = iterator1.next();
            // System.out.println(placeJson);
            String id = (String) transitionJson.get("transitionId");
            ArrayList<Integer> time = new ArrayList<Integer>();
            try {
                JSONArray timeJSON = (JSONArray) transitionJson.get("time");
                Iterator<String> iterator4 = timeJSON.iterator();
                while (iterator4.hasNext()) {
                    Integer t = Integer.parseInt(iterator4.next());
                    time.add(t);
                }
            } catch (Exception e) {
            }
            try {
                Integer t = Integer.parseInt((String) transitionJson.get("time"));
                time.add(t);
            } catch (Exception e) {
            }
            Random r = new Random();
            int finaltime = time.size() == 1 ? time.get(0) : r.nextInt(time.get(1) - time.get(0)) + time.get(0);
            ArrayList<String> need = new ArrayList<String>();
            try {
                JSONArray needPlace = (JSONArray) transitionJson.get("need");
                Iterator<String> iterator2 = needPlace.iterator();
                while (iterator2.hasNext()) {
                    String needP = (String) iterator2.next();
                    need.add(needP);
                }
            } catch (Exception e) {
            }
            try {
                String needP = (String) transitionJson.get("need");
                need.add(needP);
            } catch (Exception e) {
            }
            ArrayList<String> to = new ArrayList<String>();
            try {
                JSONArray toPlace = (JSONArray) transitionJson.get("to");
                Iterator<String> iterator3 = toPlace.iterator();
                while (iterator3.hasNext()) {
                    String toP = (String) iterator3.next();
                    to.add(toP);
                }
            } catch (Exception e) {
            }
            try {
                String toP = (String) transitionJson.get("to");
                to.add(toP);
            } catch (Exception e) {
            }

            transitionsList.add(new Transition(id, finaltime, need, to));

        }
        return transitionsList;
    }
}
