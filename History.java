import java.util.*;

class History {
    
    long member_id, book_id;
    Date intime, outtime;
    
    History(long member_id, long book_id) {
        this.member_id = member_id;
        this.book_id = book_id;
        
        intime = new Date();
        outtime = null;
    }
    
}