public class listbookVariable {
    private String ID;
    private String title;
    private String genre;
    private String author;
    private String publishDate;
    private String importDate;
    private String QTY;
    public listbookVariable(String ID, String title, String genre, String author, String publishDate,
            String importDate, String qTY) {
        this.ID = ID;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publishDate = publishDate;
        this.importDate = importDate;
        QTY = qTY;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public String getImportDate() {
        return importDate;
    }
    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }
    public String getQTY() {
        return QTY;
    }
    public void setQTY(String qTY) {
        QTY = qTY;
    }   
}
