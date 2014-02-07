package reddit;

public class Community {
  protected ArrayList<Article> articles;
  protected String description;
  protected ArrayList<User> users;
  protected int id;
  protected static int currentId = 0;

  public static final int NUM_FIELDS = 2; // ID and description for now.


  public Community(){
    this.id = currentId;
    currentId++;
  }

  public int getId(){
    return this.id;
  }

  public ArrayList<Article> getArticles(){
    return this.articles;
  }

  public void addArticle(Article article){
    this.articles.add(article);
  }

  public void removeArticle(Article article){
    this.articles.remove(article);
  }

}
