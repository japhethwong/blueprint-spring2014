package reddit;

// import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//  CSV Parse library: http://opencsv.sourceforge.net/
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class Website {
    public Website () {

    }

    public static void main(String[] args) {
        
    }

    /**
     *  importData() imports data from a file into the program's memory for use.
     **/
    private void importData() {
        String articlesLoc = "articles.csv";
        String usersLoc = "users.csv";
        String communityLoc = "communities.csv";

        //  Read in article data.
        try {
            CSVReader articlesReader = new CSVReader(new FileReader(articlesLoc));
            List articles = articlesReader.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);
        }
        
        //  Read in user data.
        try {
            CSVReader usersReader = new CSVReader(new FileReader(usersLoc));
            List users = usersReader.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);   
        }

        //  Read in communities data.
        try {
            CSVReader communitiesReader = new CSVReader(new FileReader(communityLoc));
            List communities = communities.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);
        }


    }

    /**
     *  exportData() exports data from a file into the program's memory to be loaded 
     *  in for the next session.
     **/
    private void exportData() {

    }

}