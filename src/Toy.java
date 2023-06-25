import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int frequency;
       public static ArrayList<Toy> basketToys = new ArrayList<>();

    public Toy(int id, String name, int count, int frequency) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.frequency = frequency;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }




    public static void showAlltoys(ArrayList<Toy> toys){
        for (Toy s : toys) {
            System.out.println( "ID: " + s.getId() + ", Имя приза: " + s.getName() + ", Колличесво: "
                    + s.getCount() + ", Частота выпадений: " + s.getFrequency());
        }
    }

    public static void showBasket(ArrayList<Toy> basketToys2)
    {

        if (basketToys2.isEmpty())
        {
            System.out.println("\nКорзина пуста!");
        }
        else
        {
            System.out.println("Содержание корзины:");
            for (Toy s : basketToys2){
                System.out.println("ID: " + s.getId() + ", Имя приза: " + s.getName() + ", Колличесво: "
                        + s.getCount() + ", Частота выпадений: " + s.getFrequency());
            }
        }
    }


    public static void addToys(ArrayList<Toy> toys, Toy toy){
        toys.add(toy);
    }

    public void changeCont(ArrayList<Toy> toy, int id){

    }

    public static void changeFrequency(int id, int newFrequency, ArrayList<Toy> toys){
        for (Toy i : toys){
            if (id == i.getId()) {
                i.setFrequency(newFrequency);
            }
                      }
        }
    public static String chooseToy(ArrayList<Toy> toys){

        Random randNumber = new Random();
        int index = randNumber.nextInt(toys.size());
        Toy variable;
        variable = toys.get(index);
        System.out.println("Выпала игрушка: " + variable.getName());
        basketToys.add(variable);
        return variable.getName();
    }

        public static void chooseToyBasket(ArrayList<Toy> basketToys2, ArrayList<Toy> toys){
        Random randNumber = new Random();
        int index = randNumber.nextInt(basketToys2.size());
        Toy variable;
        variable = basketToys2.get(index);
        System.out.println("Выпала игрушка: " + variable.getName() + ", с частотой: "
                + variable.getFrequency());
        double number = Math.random()*101;
        int myNumber = (int)number;
        System.out.print("Ваша частота: " + myNumber + "\n");
        if(myNumber > variable.getFrequency())
        {
            System.out.println("Выиграли: " + variable.getName());
            basketToys2.remove(variable);

            for (Toy s : toys){
                if(s.getName() == variable.getName()){
                    s.setCount(s.getCount() - 1);
                }
            }
            try(FileWriter writer = new FileWriter("file.txt", true))
            {
                writer.write(variable.getName() + "\n");
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }





        }
        else{
            System.out.println("Вы проиграли");
        }




    }



}
