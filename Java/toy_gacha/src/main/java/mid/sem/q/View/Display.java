package mid.sem.q.View;


import java.util.Scanner;

public class Display {
    public void greet() {
        System.out.println("Приветствуем вас на розыгрыше игрушек!");
    }

    public void sayBB() {
        System.out.println("Всего хорошего");
    }

    public void show(String message) {
        System.out.println(message);
    }

    public void menu() {
        String[] commands = new String[]{
                "Крутить барабан",
                "Показать остатки",
                "Выйти"
        };
        for (int index = 0; index < commands.length; index++)
            System.out.println(String.format("%d. %s", index + 1, commands[index]));
    }

    public String input(String message){
        show(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
