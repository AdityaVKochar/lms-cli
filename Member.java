import java.util.*;

class Member {
    
    String member_name;
    long member_id;
    
    ArrayList<History> history; 
    
    Member(String name, long id) {
        member_name = name;
        member_id = id;
        history = new ArrayList();
    }
    
}