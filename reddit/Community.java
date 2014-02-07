package reddit;
import java.util.*;

public class Community {
  protected ArrayList<Article> articles;
  protected String description;
  protected ArrayList<User> users;
  protected String id;


  public Community(String description){
    this.articles = new ArrayList<Article>();
    this.users = new ArrayList<User>();
    this.description = description;
    this.id = (new Date()).toString() + String.valueOf((new Date()).getTime());
  }

  public String getId(){
    return this.id;
  }

  public ArrayList<Article> getArticles(){
    return this.articles;
  }

  public void addArticle(Article article){
    this.articles.add(article);
    this.users.add(article.getAuthor());
  }

  public boolean removeArticle(Article article){
    this.users.remove(article.getAuthor());
    return this.articles.remove(article);
  }

}
