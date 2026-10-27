public class ISGB36 {
    
    public static void main(String[] args){
        
        AppController controller = new AppController();
        ConsoleUI ui = new ConsoleUI(controller);

        controller.setView(ui);
        ui.start();

    }
}

       