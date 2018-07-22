import java.io.*;

public class Main {
    BufferedReader csvFile = null;
    BufferedWriter jsonFile = null;
    public static void main(String[] args) {

        try {
        BufferedReader csvFile= new BufferedReader(new FileReader("src/chicago-bulls.csv"));
        BufferedWriter jsonFile=new BufferedWriter(new FileWriter("src/chicago-bulls.json"));

        String fileContent = csvFile.readLine();

// set the constant header
        String jsonScript="constant header of json content";

        while (fileContent !=null) {
            fileContent = csvFile.readLine();
            String[] tab = fileContent.split(",");
            // variable content from csv file
            jsonScript += "\"" + tab[0] + "\" :";
            jsonScript += tab[1] + "," + "\n";

            // End of json content construction
            jsonScript = jsonScript.substring(0, jsonScript.length() - 2);
            jsonScript += "}";

            String[] tabWrite = jsonScript.split("\n");
            for (String item : tabWrite) {
                jsonFile.write(item);
                jsonFile.newLine();
            }

        }
            csvFile.close();
            jsonFile.close();
    } catch (FileNotFoundException ex) {
      System.out.println(ex);
    } catch (IOException ex) {
            System.out.println(ex);
    }

}
}

