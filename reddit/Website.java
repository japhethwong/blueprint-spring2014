package reddit;

// import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//  CSV Parse library: http://opencsv.sourceforge.net/
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

// Import data models.
import reddit.User;
import reddit.Article;
import reddit.Community;

public class Website {
	
	private HashMap<Community> communities;
	private HashMap<String, User> users;
	private ArrayList<Article> articles;

    private static final String articlesLoc = "articles.csv";
    private static final String usersLoc = "users.csv";
    private static final String communityLoc = "communities.csv";
	
    public Website () {

    }
	
	public String getArticles(){
		StringBuffer sb = new StringBuffer();
		for(int i = articles.size(); i > articles.size()-10; i--){
			sb.append(i + ". " + articles.get(i).toString()+ "\n");
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
			sb.append(i + ". " + userArticles.get(i).toString()+ "\n");
		}
		return sb.toString();
		
	}

	public String searchArticles(String community){
		Community currentCommunity;
		if(communities.contains(community)){
			currentCommunity = communities.get(community);
		}else{
			return "Community Not Found";
		}
		//User class should implement getArticles()
		Community[] communityArticles = currentCommunity.getArticles();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < communityArticles.length; i++){
			sb.append(i + ". " + communityArticles.get(i).toString()+ "\n");
		}
		return sb.toString();
		
	}

	public void postArticle(String user, String content){
		Date now = new Date();
		Article article = new Article(user, content)
		
	}

	public String getUsers(){
	}

    public static void main(String[] args) {
        
    }

    private ArrayList<User> populateUserData(List data) {
        if (data.size() % User.NUM_FIELDS != 0) {
            return null;
        }

        ArrayList<User> users = new ArrayList<User>();  // For now only going to create user by username.
        for (int i = 0; i < users.length; i += User.NUM_FIELDS) {
            User currUser = new User(users[i]);
            users.add(currUser);
        }
        return users;
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

    private ArrayList<Community> populateCommunityData(List data) {
        ArrayList<Community> communities = new ArrayList<Community>();
        for (int i = 0; i < data.length; i += Community.NUM_FIELDS) {
            int commId = Integer.parseInt(data[i]);
            String descr = data[i+1];
            Community commObj = new Community(commId, descr);
            communities.add(commObj);
        }

        return communities;
    } 

    /**
     *  importData() imports data from a file into the program's memory for use.
     **/
    private void importData() {

        //  Read in article data.
        try {
            CSVReader articlesReader = new CSVReader(new FileReader(Website.articlesLoc));
            List articleData = articlesReader.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);
        }
        
        //  Read in user data.
        try {
            CSVReader usersReader = new CSVReader(new FileReader(Website.usersLoc));
            List userData = usersReader.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);   
        }

        //  Read in communities data.
        try {
            CSVReader communitiesReader = new CSVReader(new FileReader(Website.communityLoc));
            List communityData = communities.readAll();
        } catch (IOException e) {
            System.out.println("***ERROR: Unable to locate articles data file.");
            System.exit(1);
        }

        //  Populate the data.
        ArrayList<User> usersList = populateUserData(userData);
        for (User user : usersList) {
            users.add(user.getUsername(), user);
        }

        // Populate communities.
        communitiesList = populateCommunityData(communityData);
        for (Community comm : communitiesList) {
            communities.add(comm.getId(), comm);
        }

        // Populate articles.
        articles = populateArticleData(articleData);

    }

    /**
     *  exportData() exports data from a file into the program's memory to be loaded 
     *  in for the next session.
     **/
    private void exportData() {
        FileWriter artWriter = new FileWriter(Website.articlesLoc);
        FileWriter commWriter = new FileWriter(Website.communityLoc);
        FileWriter userWriter = new FileWriter(Website.usersLoc);
    }

}