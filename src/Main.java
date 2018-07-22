import javax.print.DocFlavor;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
        List<String> positions=new ArrayList<String>();
        double averagepointofteam =0;
        double sumpointofteam=0;
        for(int i=0;i<CBI.size();i++){
          sumpointofteam+=CBI.get(i).getPPG();
          positions.add(CBI.get(i).getPosition());
        }
        averagepointofteam=sumpointofteam/CBI.size();
        Collections.sort(CBI, new Comparator<ChicagoBullsInformation>() {
            @Override
            public int compare(ChicagoBullsInformation o1, ChicagoBullsInformation o2) {
                return Double.compare(o1.PPG,o2.PPG);
            }
        });
        String goldPlayer=CBI.get(0).getName();
        String silverPlayer=CBI.get(1).getName();
        String bronzePlayer=CBI.get(2).getName();
      Set<String> uniquePositions=new HashSet<String>(positions);
      System.out.print(uniquePositions.size());
      int counter=0;
      double sumheights=0;
      int occurence=0;
      for (int i=0; i<uniquePositions.size();i++){
          for(int a=0; a<CBI.size();a++){
              if(uniquePositions.iterator().next().equalsIgnoreCase(CBI.get(i).position)){
                  counter++;
                  String str = (CBI.get(i).height);
                  char[] crs = str.toCharArray();
                  for (int c = 0; c < crs.length; c++) {
                      if (Character.isDigit(crs[c])) {
                          occurence++;
                          if(occurence==1){
                              sumheights+=(double)crs[c];
                          }else if(occurence>1){
                              sumheights+=(double)crs[c]/10;
                          }
                      }
                      sumheights=sumheights/counter;
                  }

              }

          }
          System.out.println("Position:" + uniquePositions.iterator().next() + "Has this number of palyers" +counter + "and the average height is:"+ sumheights);
      }

}}

