package machine;

import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        int[] coffeeCupIngredients = new int[5];

        boolean[] action = {true};

        firstInput(coffeeCupIngredients);

        while (action[0]) {
            choice(coffeeCupIngredients, action);
        }

    }

    public static void firstInput(int[] ingredients) {

        ingredients[0] = 400;
        ingredients[1] = 540;
        ingredients[2] = 120;
        ingredients[3] = 9;
        ingredients[4] = 550;


    }

    public static void choice(int[] ingredients, boolean[] action) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");

        String choice = scanner.next();

        switch (choice) {
            case "remaining" : checkRemaining(ingredients);
                        break;
            case "buy" : buyCoffee(ingredients);
                        break;
            case "fill" : fillMachine(ingredients);
                        break;
            case "take" : takeMoney(ingredients);
                        break;
            case "exit" : action[0] = false;
        }

    }

    public static void buyCoffee(int[] ingredients) {

        Scanner scanner = new Scanner(System.in);

        int[] usedIngredients = {0, 0, 0, 0, 0};

        String[] nameOfIngredient = {
                "water!", "milk!", "coffee beans!", "disposable cups!"
        };

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = scanner.next();

        int choice = 0;

        try {
            choice = Integer.parseInt(input);
        } catch (Exception e) {
            if (input.equals("back")) {
                return;
            }
        }

        switch (choice) {
            case 1 : usedIngredients[0] = 250;
                    usedIngredients[1] = 0;
                    usedIngredients[2] = 16;
                    usedIngredients[3] = 1;
                    usedIngredients[4] = -4;
                    break;
            case 2 : usedIngredients[0] = 350;
                    usedIngredients[1] = 75;
                    usedIngredients[2] = 20;
                    usedIngredients[3] = 1;
                    usedIngredients[4] = -7;
                    break;
            case 3 : usedIngredients[0] = 200;
                    usedIngredients[1] = 100;
                    usedIngredients[2] = 12;
                    usedIngredients[3] = 1;
                    usedIngredients[4] = -6;
                    break;
        }

        for (int i = 0; i < 4; i++) {
            if (usedIngredients[i] > ingredients[i]) {
                System.out.println("Sorry, not enough " + nameOfIngredient[i]);
                return;
            }
        }

        System.out.println("I have enough resources, making you a coffee!");

        for (int i = 0; i < 5; i++) {
            ingredients[i] -= usedIngredients[i];
        }

    }




    public static void fillMachine(int[] ingredients) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add: ");
        ingredients[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        ingredients[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        ingredients[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        ingredients[3] += scanner.nextInt();

    }

    public static void takeMoney(int[] ingredients) {

        System.out.println("I gave you $" + ingredients[4]);

        ingredients[4] = 0;

    }

    public static void checkRemaining(int[] ingredients) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(ingredients[0] + " ml of water");
        System.out.println(ingredients[1] + " ml of milk");
        System.out.println(ingredients[2] + " g of coffee beans");
        System.out.println(ingredients[3] + " disposable cups");
        System.out.println("$" + ingredients[4] + " of money");
    }

//    public static void checker(int[] cups) {
//
//        int numberOfCups = cups[1];
//        for (int i = 1; i < 3; i++) {
//            if (numberOfCups > cups[i+1]) {
//                numberOfCups = cups[i+1];
//            }
//        }
//
//        if (numberOfCups == cups[0]) {
//            System.out.println("Yes, I can make that amount of coffee ");
//        } else if (numberOfCups < cups[0]) {
//            System.out.printf("No, I can make only %d cup(s) of coffee", numberOfCups);
//        } else if (numberOfCups > cups[0]) {
//            System.out.print("Yes, I can make that amount of coffee");
//            System.out.printf("(and even %d more than that)", numberOfCups - cups[0]);
//        }
//    }


}
