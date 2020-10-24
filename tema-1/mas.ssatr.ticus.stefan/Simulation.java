import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {
    int count=0;


    public Simulation() {
    }


    public void run(ArrayList<Place> placesList, ArrayList<Transition> transitionList){
        try {
            FileWriter write = new FileWriter("out.txt");
           BufferedWriter myWriter=new BufferedWriter(write);
        myWriter.write("t:"+0+" ");
        for (int counter = 0; counter < placesList.size(); counter++) {
           myWriter.write(placesList.get(counter).id+"="+placesList.get(counter).token+" ");
        }
        myWriter.newLine();
        boolean timeincrease;
        boolean change;
        boolean hasend=false;
       ArrayList<Place> lastPlaces;
        while (!hasend){
            timeincrease=false;
            change=false;

            for (int counter = 0; counter < transitionList.size(); counter++) {
                if(transitionList.get(counter).isValide(placesList)&&(transitionList.get(counter).time==0)) {
                    transitionList.get(counter).exec(placesList);

                    myWriter.write("t:" + count + " ");
                    for (int counter1 = 0; counter1 < placesList.size(); counter1++) {

                        myWriter.write(placesList.get(counter1).id + "=" + placesList.get(counter1).token + " ");
                    }
                    myWriter.newLine();
                    System.out.println("Successfully wrote to the file.");
                    change=true;

                    counter=0;



                }
            }
            for (int counter = 0; counter < transitionList.size(); counter++) {
            if(transitionList.get(counter).isValide(placesList)&&(transitionList.get(counter).time>0)) {
                transitionList.get(counter).time--;
                System.out.println(transitionList.get(counter).trasitionID);
                timeincrease=true;
            }}
            if(!change&!timeincrease){
hasend=true;
            }
            if(!change&timeincrease){
                myWriter.write("t:" + count + " ");
                for (int counter1 = 0; counter1 < placesList.size(); counter1++) {

                    myWriter.write(placesList.get(counter1).id + "=" + placesList.get(counter1).token + " ");
                }
                myWriter.newLine();
                System.out.println("Successfully wrote to the file.");
            }

                count++;

Thread.sleep(10);
    }
            myWriter.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

}}

