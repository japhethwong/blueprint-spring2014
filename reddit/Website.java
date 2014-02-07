package reddit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Website {
	
	private HashMap<Community> communities;
	private HashMap<String, User> users;
	private ArrayList<Article> articles;
	
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

    /**
     *  importData() imports data from a file into the program's memory for use.
     **/
    private void importData() {

    }

    /**
     *  exportData() exports data from a file into the program's memory to be loaded 
     *  in for the next session.
     **/
    private void exportData() {

    }

}