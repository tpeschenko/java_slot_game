import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Toy> toys = new ArrayList<Toy>();


        Toy toy1 = new Toy(1, "Персональный ПК", 10, 20);
        Toy toy2 = new Toy(2, "Кукла", 200, 40);
        Toy toy3 = new Toy(4, "Пряник", 200, 50);
        Toy toy4 = new Toy(5, "Фонарик", 50, 30);
        Toy toy5 = new Toy(6, "Пазл", 200, 15);
        Toy toy6 = new Toy(7, "Свеча", 10, 10);

        Toy.addToys(toys, toy1);
        Toy.addToys(toys, toy2);
        Toy.addToys(toys, toy3);
        Toy.addToys(toys, toy4);
        Toy.addToys(toys, toy5);
        Toy.addToys(toys, toy6);


        while (true){
            Scanner choose = new Scanner(System.in);
            int myChoise;
            System.out.println("\nМеню игрового автомата: \n");
            System.out.println("1) Показать все игрушки\n" +
                    "2) Показать корзину выпавших игрушек\n" +
                    "3) Играть в игру(выпадет новая игрушка и добавиться в корзину)\n" +
                    "4) Поменять частоту выпадений конкретной игрушки, поиск по id\n" +
                    "5) Разыграть игрушки из корзины.\n ");

            while (true) {
                System.out.print("Введите нужный вариант: ");
                try {
                    myChoise = Integer.parseInt(choose.next());
                    System.out.println("Ваше число : " + myChoise + "\n");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный ввод! Попробуйте снова");
                }
            }
            if (myChoise == 1){
                Toy.showAlltoys(toys);
            }
            else if (myChoise == 2){
                Toy.showBasket(Toy.basketToys);
            }
            else if (myChoise == 3){
                Toy.chooseToy(toys);
            }
            else if (myChoise == 4){
                System.out.print("Введите ID игрушки, которой хотите поменять частоту: ");
                int num1 = choose.nextInt();
                System.out.print("Введите новую частоту: ");
                int num2 = choose.nextInt();
                Toy.changeFrequency(num1, num2, toys);

            }
            else if (myChoise == 5){
                System.out.print("Участвуют в розыгрыше - ");
                Toy.showBasket(Toy.basketToys);
                System.out.println("");
                Toy.chooseToyBasket(Toy.basketToys, toys);

            }


            else if (myChoise > 5 || myChoise < 1){
                System.out.println("Число не подходит, попробуйте снова!");
            }
        }
    }
}