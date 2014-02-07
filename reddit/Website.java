package reddit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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