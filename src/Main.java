import java.io.*;
import java.util.ArrayList;

public class Main {
    BufferedReader csvFile = null;
    BufferedWriter jsonFile = null;
    public static String line="";
    public static ArrayList<ChicagoBullsInformation> CBI;


    public static void ParseCSV(){
        CBI= new ArrayList<ChicagoBullsInformation>();
        try {
            BufferedReader csvFile= new BufferedReader(new FileReader("src/chicago-bulls.csv"));
            BufferedWriter jsonFile=new BufferedWriter(new FileWriter("src/chicago-bulls.json"));

            String fileContent = csvFile.readLine();


            String jsonScript="constant header of json content";

            while ((line = csvFile.readLine()) != null) {

                String[] tab =new String[100];
                tab = line.split(",");
                ChicagoBullsInformation a= new ChicagoBullsInformation(Integer.parseInt(tab[0]),tab[1],Integer.parseInt(tab[2]),tab[3],tab[4]+","+tab[5],tab[6],tab[7],tab[8],Double.parseDouble(tab[9]));
                CBI.add(a);

            }
            csvFile.close();
            jsonFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        ParseCSV();

        for(int i=0;i<CBI.size();i++){
            System.out.println(CBI.get(i).getName());
        }



}
}

