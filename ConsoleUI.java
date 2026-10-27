import java.util.Scanner;

public class ConsoleUI {
    private Scanner input;
    private AppController controller;

    public ConsoleUI(AppController controller) {
        this.input = new Scanner(System.in);
        this.controller = controller;
    }

    public void start(){
        boolean exit = false;

        while(!exit){
            System.out.println("Wellcome to ChatterBox");
            System.out.println("1 - Show all messages as Guest");
            System.out.println("2 - Sign in as User");
            System.out.println("3 - exit");
            System.out.println("Choose one option");

            int option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    showGuestMenu();
                    break;
                case 2:
                    loginMenu();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public void showGuestMenu(){
        System.out.println("Menu of Guest");
        controller.showAllMEssages();
    }

    public void loginMenu(){
        System.out.println("Please Enter your credentials");
        System.out.println("Email: ");
        String email = input.nextLine();
        
        System.out.println("Password: ");
        String pass = input.nextLine();

        boolean isLogged = controller.login(email, pass);

        if(isLogged){
            showUserMenu();
        }else{
            System.out.println("Incorrect password");
        }
    }

    public void showUserMenu(){
        boolean exit = false;

        while (!exit) {
            System.out.println("User Menu");
            System.out.println("1 - See all messages");
            System.out.println("2 - See my messages");
            System.out.println("3 - Post a message");
            System.out.println("4 - Delete one of my messages");
            System.out.println("5 - logout");
            System.out.println("Choose an option");

            int option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    controller.showAllMEssages();
                    break;
                case 2:
                    controller.showOwnMessages();
                    break;
                case 3:
                    System.out.println("Write a message you want to post");
                    String m = input.nextLine();
                    controller.postMessages(m);
                    break;   
                case 4:
                    System.out.println("Write the message you want to delete");
                    String eliminate = input.nextLine();
                    controller.deleteMessage(eliminate);
                    break;
                case 5:
                    controller.logout();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
