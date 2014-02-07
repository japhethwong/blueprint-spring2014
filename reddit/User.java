package reddit;
import java.util.Date;

public class User {
  protected Article[] articles;
  protected String username;
  protected Date dateCreated;

  public static final int NUM_FIELDS = 1;


  public User(String username){
    this.username = username;
    this.dateCreated = new Date()
  }

  public Article[] getArticles(){
  }

  public void postArticle(){
  }

  public void removeArticle(){
  }

  public void setUsername(){
  }

  public String getUsername(){

  }
  

}
