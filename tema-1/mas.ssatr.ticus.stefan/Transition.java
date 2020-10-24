import java.util.ArrayList;
import java.util.Random;

public class Transition {
    public Transition(String trasitionID,  int time, ArrayList<String> needPlaces, ArrayList<String> moveToPlaces) {
        this.trasitionID = trasitionID;
        this.time = time;
        this.needPlaces = needPlaces;
        this.moveToPlaces = moveToPlaces;
    }

    public String trasitionID;
    public int time;
    public ArrayList<String> needPlaces;
    public ArrayList<String> moveToPlaces;

    public boolean isValide(ArrayList<Place> placesList){
        boolean isValide=false;
        for (int counter = 0; counter < needPlaces.size(); counter++) {
            for (int counter1 = 0; counter1 < placesList.size(); counter1++) {

                if(placesList.get(counter1).id.equals(needPlaces.get(counter))){
                    isValide=placesList.get(counter1).token>0?true:false;
                    System.out.println("");
                    if(!isValide){break;}
                }
            }
            if(!isValide){break;}
        }
        return isValide;
    }

    public void exec(ArrayList<Place> placesList){

        for (int counter = 0; counter < needPlaces.size(); counter++) {
            for (int counter1 = 0; counter1 < placesList.size(); counter1++) {
                if(placesList.get(counter1).id.equals(needPlaces.get(counter))){
                    placesList.get(counter1).token--;
                }
            }
        }
        for (int counter2 = 0; counter2 < moveToPlaces.size(); counter2++) {
            for (int counter3 = 0; counter3 < placesList.size(); counter3++) {


                if(placesList.get(counter3).id.equals(moveToPlaces.get(counter2))) {
                    placesList.get(counter3).token++;
                }


            }

        }
    }

}
