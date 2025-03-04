import java.util.*;

class Book {
    
    String book_name, book_author;
    long book_id;
    
    boolean is_available; Member latest;
    ArrayList<History> history;
    
    Book(String name, String author, long id) {
        book_name = name;
        book_author = author;
        book_id = id;
        is_available = true;
        history = new ArrayList();
        latest = null;
    }
    
    
    void borrow(Member member) {
        is_available = false;
        latest = member;
        History hist = new History(member.member_id, book_id); 
        history.add(hist);
        member.history.add(hist);
    }
    
    void Return() {
        is_available = true;
        latest = null;
        history.get(history.size()-1).outtime = new Date();
    }
    
    
    
}