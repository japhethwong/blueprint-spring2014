package reddit;
import java.util.Date;

public class Article {
  protected User author;
  protected ArrayList<Community> communities;
  protected String content;
  protected int favorites;
  protected Date dateCreated;

  public static final int NUM_FIELDS = 6;
  
  public Article(User author, ArrayList<Community> communities, String content){
    this.author = author;
    this.communities = communities;
    this.content = content;
    this.favorites = 0;
    this.dateCreated = new Date();
    this.id = currentId;
    currentId++;
  }

  public Article(User author, ArrayList<Community> communities, String content, int favorites, Date date, int id){
    this.author = author;
    this.communities = communities;
    this.content = content;
    this.favorites = favorites;
    this.dateCreated = date;
    this.id = id;
  }

  public int getId(){
    return this.id;
  }

  public User getAuthors(){
    return this.author;
  }

  public ArrayList<Communities> getCommunities(){
    return this.communities;
  }

  public String getContent(){
    return this.content;
  }

  public int getFavorites(){
    return this.favorites;
  }

  public void favorite(){
    this.favorites++;
  }
  
}
