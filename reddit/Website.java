package reddit;

// import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//  CSV Parse library: http://opencsv.sourceforge.net/
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class Website {
	
	ArrayList<Community> communities;
	HashMap<String, User> users;
	ArrayList<Article> articles;
	
    public Website () {

    }
	
	public String getArticles(){
		StringBuffer sb = new StringBuffer();
		for(int i = articles.size(); i > articles.size()-10; i--){
			sb.append(articles.get(i).toString()+ "\n");
		}
		return sb.toString();
	}

	public String getUserArticles(String user){
		User currentUser;
		if(users.contains(user)){
			currentUser = users.get(user);
		}else{
			return "User Not Found";
		}
		//User class should implement getArticles()
		Article[] userArticles = currentUser.getArticles();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < userArticles.length; i++){
			sb.append(i + ". " + aricles.get(i).toString()+ "\n");
		}
		return sb.toString();
		
	}

	public String searchArticles(){
	}

	public void postArticle(String content){
	}

	public String getUsers(){
	}

    public static void main(String[] args) {
        
    }

    /**
     *  populateArticleData() reads in the CSV data and recreates all Article objects.
     *  @param data is a List of Strings which are expected to correspond to the fields 
     *   for an article
     *  @return list of Article objects
     **/
    private ArrayList<Article> populateArticleData(List data) {
        if (data.size() % Article.NUM_FIELDS != 0) {
            return null;
        }

        ArrayList<Article> articles = new ArrayList<Article>();
        for (int i = 0; i < data.length; i += Article.NUM_FIELDS) {
            String articleId = data[i];
            User user = users.get(data[i+1]);
            String communityId = data[i+2];
            String content = data[i+3];
            int favorites = Integer.parseInt(data[i+4]);
            Date date = DateFormat.parse(data[i+5]);

            Article articleObj = new Article(articleId, user, communityId, content, favorites, date);
            articles.add(articleObj);
        }

        return articles;
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
            List articleData = articlesReader.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);
        }
        
        //  Read in user data.
        try {
            CSVReader usersReader = new CSVReader(new FileReader(usersLoc));
            List userData = usersReader.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);   
        }

        //  Read in communities data.
        try {
            CSVReader communitiesReader = new CSVReader(new FileReader(communityLoc));
            List communityData = communities.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);
        }

        //  Populate the data.
        articles = populateArticleData(articleData);


    }

    /**
     *  exportData() exports data from a file into the program's memory to be loaded 
     *  in for the next session.
     **/
    private void exportData() {

    }

}