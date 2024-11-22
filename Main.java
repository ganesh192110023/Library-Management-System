import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book genre: ");
                    String genre = scanner.nextLine();
                    bookService.addBook(title, author, genre);
                    break;

                case 2:
                    bookService.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member email: ");
                    String email = scanner.nextLine();
                    memberService.addMember(name, email);
                    break;

                case 4:
                    memberService.viewMembers();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
