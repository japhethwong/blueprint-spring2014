package reddit;

// import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//  CSV Parse library: http://opencsv.sourceforge.net/
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class Website {
	
	private HashMap<Community> communities;
	private HashMap<String, User> users;
	private ArrayList<Article> articles;
	
	private final String ERROR = "INVALID COMMAND";
	
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
		ArrayList<Article> userArticles = currentUser.getArticles();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < userArticles.size(); i++){
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
		ArrayList<Community> communityArticles = currentCommunity.getArticles();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < communityArticles.size(); i++){
			sb.append(i + ". " + communityArticles.get(i).toString()+ "\n");
		}
		return sb.toString();
		
	}

	public void postArticle(String user, ArrayList<Community> tags, String content){		
		Article article = new Article(user, tags, content);
	}

	public String getUsers(){
		StringBuffer sb = new StringBuffer();
		ArrayList<User> allUsers = users.values();
		for(int i = 0; i < allUsers.size(); i++){
			sb.append(i + ". " + allUsers.get(i).getUserame()+ "\n");
		}
		return sb.toString();
	}

    public static void main(String[] args) {
    	if(args.length > 0){
    		String command = args[0];
    		switch (command){
    		case "listusers":
    			System.out.println(getUsers());
    			break;
    		case "listarticles":
    			System.out.println(getArticles());
    			break;
    		case "listuserarticles":
    			if(args.length >= 2){
    				//args[1] contains the username
    				System.out.println(getUserArticles(args[1]));
    			}else{
    				System.out.println(ERROR);
    			}
    			break;
    		case "searcharticles":
    			if(args.length >= 2){
    				//args[1] contains the community name
    				System.out.println(searchArticles(args[1]));
    			}else{
    				System.out.println(ERROR);
    			}
    			break;
    		case "post":
    			if(args.length >= 3){
    				//args[1] contains the username
    				ArrayList<Community> tags = new ArrayList<Community>();
    				System.out.print("Enter a tag (enter empty tag to exit): ");
    				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    				String tag = null;
    			    try {
    			         tag = br.readLine();
    			         while(tag != null){
    			        	 if(tag.length() == 0){
    			        		 break;
    			        	 }
	    			         if(communities.contains(tag)){
	    			        	 tags.add(communities.get(tag));
	    			         }else{
	    			        	 System.out.println("Community does not exists.");
	    			        	 System.out.print("Enter a tag: ");
	    			         }
	    			         tag = br.readLine();
    			         }
    			    } catch (IOException ioe) {
    			         System.out.println("IO error trying to read your name!");
    			    }
    			    
    				if(communities.contains())
    			}else{
    				System.out.println(ERROR);
    			}
    			break;
			default:
				System.out.println(ERROR);
				break;
    		}
    	}
        
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