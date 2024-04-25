class Book {
    private String title;
    private String author;
    private String text;

    public Book(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getText() {
        return this.text;
    }
}

class BookPrinter {
    public void printTextToConsole(String text) {
        System.out.println(text);
    }

    public void printBookToConsole(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Text: " + book.getText());
    }
}

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("SOLID", "Somebody", "Some text...");
        BookPrinter printer = new BookPrinter();

        printer.printBookToConsole(book);
    }
}