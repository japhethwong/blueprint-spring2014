package reddit;
import java.util.*;

public class Article {
  protected User author;
  protected Community community;
  protected String content;
  protected int favorites;
  protected Date dateCreated;
  protected String id;

  public static final int NUM_FIELDS = 6;
  
  public Article(User author, Community community, String content){
    this.author = author;
    this.community = community;
    this.content = content;
    this.favorites = 0;
    this.dateCreated = new Date();
    this.id = (new Date()).toString() + String.valueOf((new Date()).getTime());
  }

  public Article(User author, Community community, String content, int favorites, Date date, String id){
    this.author = author;
    this.community = community;
    this.content = content;
    this.favorites = favorites;
    this.dateCreated = date;
    this.id = id;
  }

  public String getId(){
    return this.id;
  }

  public User getAuthor(){
    return this.author;
  }

  public Community getCommunity(){
    return this.community;
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
