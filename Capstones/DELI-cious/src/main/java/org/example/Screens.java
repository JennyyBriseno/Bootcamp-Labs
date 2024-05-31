package org.example;

import java.util.Scanner;

import static org.example.Chips.chipFlavor;
import static org.example.Drinks.drinkFlavor;
import static org.example.Toppings.*;


public class Screens {
    private static final Scanner scanner = new Scanner(System.in);
    private static Orders orders = new Orders();
    public static void HomeScreen() {
        System.out.println("🌸~~HELLO AND WELCOME TO YOUR JENNY'S DELI-CIOUS SANDWICH SHOP~~🌸");
        while (true) {
            try {
                System.out.println("""
                        1)✿❀New Order❀✿
                        2)⚠~EXIT THE APPLICATION~⚠
                        """);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        orderScreen();
                        break;
                    case 2:
                        System.out.println("""
                                ----------⚠ EXITING APPLICATION ⚠----------
                                                        
                                ┍━━━━»•»🌸«•«━┑Have a nice day!┕━»•»🌸«•«━━━━┙
                                                           _()/^)
                                        (^\\()_               _)\\<
                                         >/(_     _.-.-.       \\\\)_
                                        (/\\\\     (_\\_|_/_)      \\  `
                                          /|    (__>(@)<__)     `
                                          ``     (_/^|^\\_)
                                                   '-'-'#,  _/\\
                                                        `# / _/
                                                    |\\_ ,#|/_/
                                                    \\ \\|#'
                                                     `-#' /|
                                                    /\\_# | /_
                                                    \\_.|#,__/
                                """);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("----------⚠ Sorry that is not an option! Try again! ⚠----------");
                        break;
                }
            }
            catch (NumberFormatException exception){
                System.out.println("----------⚠ Please enter your option in number format! ⚠----------");
            }
        }
    }

    public static void orderScreen() {
        while (true) {
            try {
                System.out.println("""
                        🌸~Select one~🌸
                        1)✿❀Add Sandwich❀✿
                        2)✿❀Add drink❀✿
                        3)✿❀Add Chips❀✿
                        4)✿❀Checkout!❀✿
                        0)I would like to cancel my order!
                        """);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addSandwich();
                        break;
                    case 2:
                        selectDrink();
                        break;
                    case 3:
                        selectChip();
                        break;
                    case 4:
                        checkout();
                        break;
                    case 0:
                        System.out.println("----------⚠ Order is being canceled. REDIRECTING TO MAIN SCREEN ⚠----------");
                        HomeScreen();
                        break;
                    default:
                        System.out.println("----------⚠ Sorry that is not an option! Try again! ⚠----------");
                        break;
                }
            }
            catch (NumberFormatException exception){
                System.out.println("----------⚠ Please enter your option in number format! ⚠----------");
            }
        }
    }

    public static void addSandwich(){
        while(true) {
            try {
                //prompting the user for breadType
                System.out.println("🌸~Please select a bread option for your sammich~🌸");
                //Displaying breadTypes
                int counter = 0;
                for (String bread : breadType) {
                    System.out.println(counter + " ~ " + bread);
                    counter++;
                }
                //Obtaining the breadTypeChosen
                int breadTypeChosen = Integer.parseInt(scanner.nextLine());
                System.out.println("Bread chosen ~ " + breadType.get(breadTypeChosen));
                //Adding it to list
                String bread = (breadType.get(breadTypeChosen));

                System.out.println("🌸~Please select a sandwich size~🌸");
                //Display sandwich size enum, and prompt the user for index
                int counter2 = 0;
                for (SandwichSize size : SandwichSize.values()) {
                    System.out.println(counter2 + " ~ " + size);
                    counter2++;
                }
                int breadSize = Integer.parseInt(scanner.nextLine());
                SandwichSize sizeOfBread = SandwichSize.values()[breadSize];
                boolean isToasted = false;
                System.out.println("Would you like this bread toasted? ");
                String toastedAnswer = scanner.nextLine();
                if (toastedAnswer.equalsIgnoreCase("yes")) {
                    isToasted = true;
                }
                Sandwich sandwich = new Sandwich(bread, sizeOfBread, isToasted);
                selectToppings(sandwich);
            }
            catch (NumberFormatException exception){
                System.out.println("----------⚠ Please enter the right format! ⚠----------");
            }
            catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("That's not an option, please try again! ");
            }
        }
    }

    public static void selectToppings(Sandwich sandwich) {
        while (true) {
            try {
                System.out.println("""
                        🌸~Please select one of the options below for toppings~🌸
                        1)✿❀ADD MEAT❀✿
                        2)✿❀ADD CHEESE❀✿
                        3)✿❀ADD VEGETABLES❀✿
                        4)✿❀SELECT SAUCES❀✿
                        5)✿❀GO BACK TO ORDER SCREEN❀✿
                        """);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addMeat(sandwich);
                        break;
                    case 2:
                        addCheese(sandwich);
                        break;
                    case 3:
                        addVegetables(sandwich);
                        break;
                    case 4:
                        addSauce(sandwich);
                        break;
                    case 5:
                        orders.items.add(sandwich);
                        orderScreen();
                        break;
                    default:
                        System.out.println("Sorry that is not an option :( Please try again!");
                        break;
                }
            }
            catch (NumberFormatException exception){
                System.out.println("----------⚠ Please enter the right format! ⚠----------");
            }
        }
    }

    public static void addMeat(Sandwich sandwich) {
        System.out.println("🌸~LIST OF MEATS~🌸");
        //~MAKE THIS PRETTY~
        for (String meatlist : meatsList) {
            System.out.println("~" + meatlist + "~");
        }
        while (true) {
                System.out.println("🌸~Please select the meat you would like in your sammich~🌸\n~NOTE:THERE IS AN EXTRA CHARGE FOR ANY EXTRA MEAT~\n~NOTE:Once done press 'x'~ ");
                String meatChosen = scanner.nextLine();
                if (meatsList.contains(meatChosen)) {
                    sandwich.meats.add(meatChosen);
                    System.out.println("ADDED!");
                }
                else if (meatChosen.equalsIgnoreCase("x")) {
                    break;
                }
                else {
                    System.out.println("Sorry, we do not have that meat :/. Please try again!");
                }
            }
        }

    public static void addCheese(Sandwich sandwich){
        System.out.println("🌸~LIST OF CHEESES~🌸");
        //~MAKE THIS PRETTY~
        for (String cheesesList: cheeseList){
            System.out.println("~" + cheesesList + "~");
        }
        while(true){
            System.out.println("🌸~Please select the cheese you would like in your sammich~🌸\n~Note:THERE IS AN EXTRA CHARGE FOR ANY EXTRA CHEESE~\n~NOTE:Once done press 'x'~");
            String cheeseChosen = scanner.nextLine();
            if(cheeseList.contains(cheeseChosen)){
                sandwich.cheese.add(cheeseChosen);
                System.out.println("ADDED!");
            }
            else if(cheeseChosen.equalsIgnoreCase("x")){
                break;
            }
            else{
                System.out.println("Sorry, we do not have that cheese :/. Please try again!");
            }
        }
    }

    public static void addVegetables(Sandwich sandwich){
        System.out.println("🌸~LIST OF VEGGIES~🌸");
//        ~MAKE THIS PRETTY~
        for(String veggieList : vegetablesList){
            System.out.println("~" + veggieList + "~");
        }
        while(true){
            System.out.println("🌸~Please select the veggies you would like in your sammich~🌸\n~NOTE:Once done press 'x'~");
            String veggiesChosen = scanner.nextLine();
            if(vegetablesList.contains(veggiesChosen)){
                sandwich.regularToppings.add(veggiesChosen);
                System.out.println("ADDED!");
            }
            else if(veggiesChosen.equalsIgnoreCase("x")){
                break;
            }
            else{
                System.out.println("Sorry, we do not have that veggie :/. Please try again!");
            }
        }
    }

    public static void addSauce(Sandwich sandwich){
        System.out.println("🌸~LIST OF SAUCES~🌸");
        for(String sauces : sauceList){
            System.out.println("~" + sauces + "~");
        }
        System.out.println("🌸~SIDES~🌸");
        for(String sides : sides){
            System.out.println("~" + sides + "~");
        }
        //~MAKE THIS PRETTY~
        while(true){
            System.out.println("🌸~Please select any sauces or side you would like to have in your sammich~🌸\n~NOTE:Once done press 'x'~\n~NOTE:They are free, go crazy~");
            String saucesChosen = scanner.nextLine();
            if(sauceList.contains(saucesChosen)){
                sandwich.regularToppings.add(saucesChosen);
                System.out.println("ADDED!");
            }
            else if(sides.contains(saucesChosen)){
                sandwich.regularToppings.add(saucesChosen);
                System.out.println("ADDED!");
            }
            else if(saucesChosen.equalsIgnoreCase("x")){
                break;
            }
            else{
                System.out.println("Sorry, we do not have that sauce :/. Please try again!");
            }
        }
    }

    public static void selectDrink(){
        //Prompting user for drink size
        System.out.println("~🌸Please select a drink size~🌸");
        //displaying all drink sizes
        int counter = 0;
        for(DrinkSize drinkSize : DrinkSize.values()){
            System.out.println(counter + " ~ " + drinkSize);
            counter++;
        }
        //obtaining the drink size chosen
        int drinkSize = Integer.parseInt(scanner.nextLine());
        System.out.println("~🌸Please select a drink flavor~🌸");
        int counter2 = 0;
        for(String drinkFlavor : drinkFlavor){
            System.out.println(counter2 + " ~ " + drinkFlavor);
            counter2++;
        }
        //adding it to the order
        int drinkFlavorChosen = Integer.parseInt(scanner.nextLine());
        System.out.println("Drink chosen ~ " + drinkFlavor.get(drinkFlavorChosen));
        Drinks drinks = new Drinks(DrinkSize.values()[drinkSize], drinkFlavor.get(drinkFlavorChosen));
        orders.items.add(drinks);
    }

    public static void selectChip(){
        //prompting user for chip type
        System.out.println("🌸~Please select a chip type~🌸");
        //displaying chip type
        int counter = 0;
        for(String chipFlavor : chipFlavor){
            System.out.println(counter + " ~ " + chipFlavor);
            counter++;
        }
        //obtaining their choice and adding to order
        int chipType = Integer.parseInt(scanner.nextLine());
        System.out.println("Chip chosen ~ " + chipFlavor.get(chipType));
        Chips chips = new Chips(chipFlavor.get(chipType));
        orders.items.add(chips);
    }

    public static String receiptGenerator(){
        String receipt = "";
        Double totalPrice = 0.0;
        for(ForSale item: orders.items){
            totalPrice += item.getPrice();
        }
        for(ForSale item : orders.items){
            if(item instanceof Sandwich){
                receipt += "\n------------------~🌸SANDWICH COMPONENTS🌸~------------------";
                receipt += "\nBread type ~ ";
                receipt += ((Sandwich) item).getBread();
                receipt += "\nSandwich size ~ ";
                receipt += ((Sandwich) item).getSandwichSize();
                receipt += "\nToasted Option ~ ";
                receipt += ((Sandwich) item).isToastedOption();
                receipt += "\nRegular toppings ~ ";
                receipt += ((Sandwich) item).getRegularToppings();
                receipt += "\nMeats added ~ ";
                receipt += ((Sandwich) item).getMeats();
                receipt += "\nCheese added ~ ";
                receipt += ((Sandwich) item).getCheese();
                receipt += "\nSandwich price ~ $";
                receipt += item.getPrice();
            }
            else if(item instanceof Drinks){
                receipt += "\n------------------~🌸DRINK🌸~------------------";
                receipt += "\nFlavor ~ ";
                receipt += ((Drinks) item).getFlavor();
                receipt += "\nDrink size ~ ";
                receipt += ((Drinks) item).getSize();
                receipt += "\nDrink price ~ $";
                receipt += item.getPrice();
            }
            else if(item instanceof Chips){
                receipt += "\n------------------~🌸CHIP🌸~------------------";
                receipt += "\nChip flavor ~ ";
                receipt += ((Chips) item).getChipType();
                receipt += "\nChip total price ~ $";
                receipt += item.getPrice();
            }
            else{
                receipt += "---------------...--------------";
            }
        }
        return "✿❀----------RECEIPT----------❀✿ " + receipt + "\n﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌" + "\nTOTAL PRICE ~ $" + totalPrice;
    }
    public static void checkout(){
        while(true){
            try{
                System.out.println(receiptGenerator());
                System.out.println("""
                                    Please choose one of the following options:
                                    1)CONFIRM ORDER:
                                    2)CANCEL ORDER:
                                    """);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        FileManager.writeToFile(receiptGenerator());
                        HomeScreen();
                        break;
                    case 2:
                        orders = new Orders();
                        HomeScreen();
                        break;
                    default:
                        System.out.println("Sorry that is not an option :( , please try again!");
                }
            }
            catch (NumberFormatException exception){
                System.out.println("----------⚠ Please enter the right format! ⚠----------");
            }
        }
    }
}
