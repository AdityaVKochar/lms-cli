import java.util.*;

class Main {
    
    ArrayList<Book> booklist = new ArrayList();
    ArrayList<Member> memberlist = new ArrayList();
    
    Scanner sc = new Scanner(System.in);
    
    void addBook() {
        System.out.print("Book Name:");
        sc.nextLine();
        System.out.println();
        String name = sc.nextLine();
        System.out.print("Author:");
        String author = sc.nextLine();
        System.out.println();
        
        Book book = new Book(name, author, (long)booklist.size());
        booklist.add(book);
    }
    
    
    void addMember() {
        System.out.print("Member Name:");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println();
        
        Member member = new Member(name, (long)memberlist.size());
        memberlist.add(member);
    }
    
    void borrowBook() {
        System.out.print("Book ID:");
        long book_id = sc.nextLong();
        System.out.println();
        
        System.out.print("Member ID:");
        long member_id = sc.nextLong();
        System.out.println();
        
        Book book = searchBookbyID(book_id);
        Member member = searchMemberbyID(member_id);
        
        if(book==null || member==null) {
            System.out.println("Wrong Information Received");
            return;
        }
        
        if(book.is_available==false) {
            System.out.println("Book already borrowed");
            return;
        }
        
        book.borrow(member);
        
    }
    
    void returnBook() {
        System.out.print("Book ID:");
        long book_id = sc.nextLong();
        System.out.println();
        
        Book book = searchBookbyID(book_id);
        
        if(book==null) {
            System.out.println("Wrong Information Received");
            return;
        }
        
        if(book.is_available) {
            System.out.println("Book not borrowed");
            return;
        }
        
        book.Return();
    }
    
    Book searchBookbyID(long id) {
        if(id<booklist.size()) {
            return booklist.get((int)id);
        }
        
        return null;
    }
    
    Member searchMemberbyID(long id) {
        if(id<memberlist.size()) {
            return memberlist.get((int)id);
        }
        
        return null;
    }
    
    Book searchBookbyName(String name) {
        for(int i=0; i<booklist.size(); i++) {
            if(booklist.get(i).book_name.compareTo(name)==0) {
                return booklist.get(i);
            }
        }
        
        return null;
    }
    
    Member searchMemberbyName(String name) {
        for(int i=0; i<memberlist.size(); i++) {
            if(memberlist.get(i).member_name.compareTo(name)==0) {
                return memberlist.get(i);
            }
        }
        
        return null;
    }
    
    void giveBookDetails(Book book) {
        
        System.out.println("Name: " + book.book_name);
        System.out.println("Author: " + book.book_author);
        System.out.println("ID: " + book.book_id);
        
        if(book.is_available) {
            System.out.println("Available");
        }
        else {
            System.out.println("Not Available");
            System.out.println("Borrowed by Member: " +  book.latest.member_name);
        }
        
        if(book.history.size()==0) {
            System.out.println("No history");
            return;
        }

        
        System.out.println("History:");
        System.out.println("Member ID\tIn Time\t\tOut Time");
        for(int i=book.history.size()-1; i>=0; i--) {
            History hist = book.history.get(i);
            if(hist.outtime!=null)
            System.out.println(hist.book_id + "\t" + hist.intime.toString() + "\t" + hist.outtime.toString());
            else
            System.out.println(hist.book_id + "\t" + hist.intime.toString());
        }
    }
    
    void giveBookDetailsbyName() {
        System.out.print("Enter Book Name:");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println();
        
        Book book = searchBookbyName(name);
        
        if(book==null) {
            System.out.println("Could not find book");
            return;
        }
        
        giveBookDetails(book);
    }
    
    void giveBookDetailsbyID() {
        System.out.print("Enter Book ID:");
        long id = sc.nextLong();
        System.out.println();
        
        Book book = searchBookbyID(id);
        
        if(book==null) {
            System.out.println("Could not find book");
            return;
        }
        
        giveBookDetails(book);
    }
    
    void giveMemberDetails(Member member) {
        System.out.println("Name: " + member.member_name);
        System.out.println("ID: " + member.member_id);
        
        if(member.history.size()==0) {
            System.out.println("No history");
            return;
        }
        
        System.out.println("History:");
        System.out.println("Book ID\tIn Time\t\tOut Time");
        for(int i=member.history.size()-1; i>=0; i--) {
            History hist = member.history.get(i);
            if(hist.outtime!=null)
            System.out.println(hist.book_id + "\t" + hist.intime.toString() + "\t" + hist.outtime.toString());
            else
            System.out.println(hist.book_id + "\t" + hist.intime.toString());
        }
    }
    
    void giveMemberDetailsbyName() {
        System.out.println("Enter Member Name:");
        sc.nextLine();
        String name = sc.nextLine();
        
        Member member = searchMemberbyName(name);
        
        if(member==null) {
            System.out.println("Could not find member");
            return;
        }
        
        giveMemberDetails(member);
    }
    
    void giveMemberDetailsbyID() {
        System.out.print("Enter Member ID:");
        long id = sc.nextLong();
        System.out.println();
        
        Member member = searchMemberbyID(id);
        
        if(member==null) {
            System.out.println("Could not find member");
            return;
        }
        
        giveMemberDetails(member);
    }
    
    
    
    void startcli() {
        int input;
        boolean to_cont = true;
        
        while(to_cont) {
            
            System.out.print("\n>>");
            input = sc.nextInt();
            System.out.println();
            
            switch(input) {
                case 0:
                addBook();
                break;
                case 1:
                addMember();
                break;
                case 2:
                borrowBook();
                break;
                case 3:
                returnBook();
                break;
                case 4:
                giveBookDetailsbyName();
                break;
                case 5:
                giveBookDetailsbyID();
                break;
                case 6:
                giveMemberDetailsbyName();
                break;
                case 7:
                giveMemberDetailsbyID();
                break;
                case 999:
                System.out.println("Choices:");
                System.out.println("0: Add Book\n1: Add Member\n2: Borrow Book\n3: Return Book\n4: Search Book by Name\n5: Search Book by ID");
                System.out.println("6: Search Member by Name\n7:Search Member by ID\n999: Help\n1000: Exit");
                break;
                case 1000:
                to_cont = false;
            }
            
        }
        
        
        
    }
    
    public static void main() {
        
        Main obj = new Main();
        
        System.out.println("Library Management System");
        System.out.println("Made by Aditya Vardhan Kochar\n\n");
        
        System.out.println("Choices:");
        System.out.println("0: Add Book\n1: Add Member\n2: Borrow Book\n3: Return Book\n4: Search Book by Name");
        System.out.println("5: Search Book by ID\n6: Search Member by Name\n7:Search Member by ID\n999: Help\n1000: Exit");
        
        obj.startcli();
            
    }
}