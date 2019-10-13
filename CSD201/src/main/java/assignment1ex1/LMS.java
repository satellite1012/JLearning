package assignment1ex1;

// 0: the book is not given to the reader 
// 1: the book is still at the reader, not given back.
// 2: the book is given back to the library.

class Book {
    protected String bcode; // the code of the book (this should be unique for the book).
    protected String title; // the title of the book.
    protected int quantity; // the number of books with the same code the library has.
    protected int lended; // the number of books with the same code, which are still lended. Condition:
                        // lended ≤ quantity.
    protected double price; // The price of the book.

    public Book() {
        this(null, null, 0, 0, 0);
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return bcode + "\t| " + title + (title.length() < 7 ? "\t\t| " : "\t| ") + quantity + "\t| " + price;
    }

    public String getInfo() {
        return bcode + "\t| " + title + (title.length() < 7 ? "\t\t| " : "\t| ") + quantity + "\t\t| " + lended
                + "\t\t| " + price + "\t| " + String.format("%.2f", (price * quantity));
    }
}

class Reader {
    protected String rcode; // the code of the reader (this should be unique for the reader).
    protected String name; // the name of the reader.
    protected int byear; // The birth year of the reader (must between 1900 and 2010).

    public Reader() {
        this(null, null, 0);
    }

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getByear() {
        return byear;
    }

    public void setByear(int byear) {
        this.byear = byear;
    }

    public String toString() {
        return rcode + "\t| " + name + (name.length() < 7 ? "\t\t| " : "\t| ") + byear;
    }
}

class Lending {
    protected String bcode; // the code of the book to be lended.
    protected String rcode; // the code of the borrower.
    protected int state; // takes values 0, 1, or 2 only.

    public Lending() {
        this(null, null, 0);
    }

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String toString() {
        return bcode + "\t| " + rcode + state;
    }
}