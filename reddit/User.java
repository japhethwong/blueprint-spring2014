package reddit;
import java.util.*;

public class User {
  protected ArrayList<Article> articles;
  protected String username;
  protected Date dateCreated;

  public static final int NUM_FIELDS = 1;


  public User(String username){
    this.articles = new ArrayList<Article>();
    this.username = username;
    this.dateCreated = new Date();
  }

  public ArrayList<Article> getArticles(){
    return this.articles;
  }

  public String getUsername(){
    return this.username;
  }
  

}
