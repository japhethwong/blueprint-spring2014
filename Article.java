import java.util.Date

public class Article {
  protected User[] authors;
  protected Community[] communities;
  protected String content;
  protected int favorites;
  protected Date dateCreated;
  
  public Article(){
  }

  public User[] getAuthors(){
  }

  public Communities[] getCommunities(){
  }

  public String getContent(){
  }

  public int getFavorites(){
    return this.favorites
  }

  public void favorite(){

  }
  
}