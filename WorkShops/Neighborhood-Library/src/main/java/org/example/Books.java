package org.example;

public class Books {

    int id;
    String isbn;
    String title;
    boolean isCheckedOut = false;
    String checkedOutTo = "";

    public Books(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;

    }
    public Books(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public void checkOut(String name) {
        checkedOutTo = name;
        isCheckedOut = true;
    }

    public void checkIn(){
        checkedOutTo = "";
        isCheckedOut = false;
    }

}
