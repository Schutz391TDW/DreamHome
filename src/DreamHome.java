//Andrew Schutzbach 001
import java.util.Scanner;

public class DreamHome {
    public static void main(String[] args) {
        final double TAX = 0.05;
        String welcomeText = "Hello! We are here to help you find your perfect home!\n";
        String homeType = "What style of house?\n   1. Traditional\n   2. Modern\n" +
                "   3. European\n   4. Southwest\n   5. Mountain\n   6. Victorian\n   7. Country \n";
        String userHouseInput;
        Object obj = null;
        boolean check;
        int numberInput;
        int userBedrooms = 0;
        double userBathrooms = 0;
        char charInput = 'F';
        House clone = new House();

        Scanner input = new Scanner(System.in);
        //Welcomes user
        System.out.print(welcomeText);

        do {
            do {
                //Asks user what type of house they are interested in
                System.out.print(homeType);
                userHouseInput = input.next();

                //Checks to see if input is a number or not
                try {
                    numberInput = Integer.parseInt(userHouseInput);
                } catch (NumberFormatException e) {
                    numberInput = -1;
                }

                //Finds out what kind of house the user choose
                switch (numberInput) {
                    case 1:
                        obj = new Traditional();
                        check = true;
                        break;
                    case 2:
                        obj = new Modern();
                        check = true;
                        break;
                    case 3:
                        obj = new European();
                        check = true;
                        break;
                    case 4:
                        obj = new Southwest();
                        check = true;
                        break;
                    case 5:
                        obj = new Mountain();
                        check = true;
                        break;
                    case 6:
                        obj = new Victorian();
                        check = true;
                        break;
                    case 7:
                        obj = new Country();
                        check = true;
                        break;
                    default:
                        System.out.println("Please enter a valid number");
                        check = false;
                }
            } while (!check);

            //If user choose a Traditional house
            if (obj instanceof Traditional) {
                Traditional myHouse = (Traditional) obj;
                //Tells user the default layout for Traditional house
                System.out.printf("The default layout for a Traditional House is %d bedrooms and %.1f bathrooms." +
                        " The total price is %.2f\n", myHouse.getBedrooms(), myHouse.getBathrooms(), myHouse.getCost(userBedrooms, userBedrooms));
                //Ask user if they want to add any bedrooms to the layout
                System.out.print("Would you like to add any bedrooms to this layout? \n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Asks how many bedrooms user wants to add
                        System.out.print("How many bedrooms would you like to add?\n");
                        userHouseInput = input.next();

                        //Makes sure user entered a number
                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        //Displays error message if not a number. If number sets new amount of bedrooms.
                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBedrooms(userBedrooms);
                        }
                    } while (numberInput == -1);
                }

                //Asks user if they want to add more bathrooms to the layout
                System.out.printf("Would you like to add any bathrooms to this layout? \n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Ask how many bathrooms user wants to add
                        System.out.print("How many bathrooms would you like to add?\n");
                        userHouseInput = input.next();

                        //Makes sure user entered a number
                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        //Displays error message if not a number. If number sets new amount of bedrooms.
                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBathrooms(userBathrooms);
                        }
                    } while (numberInput == -1);
                }

                //compares houses
                if (clone.getBedrooms() > 0) {
                    System.out.print("Compared to your " + clone.getType() + " house. " +
                            "This one has " + myHouse.getBedrooms() + " bedrooms and " + myHouse.getBathrooms() +
                            " bathrooms. \nYour " + clone.getType() +
                            " house had " + clone.getBedrooms() + " bedrooms and " + clone.getBathrooms() +
                            " bathrooms. The cost of the newer house is " + myHouse.getCost(userBedrooms, userBathrooms) +
                            " the old house cost " + clone.getCost(0, 0) +" \n");
                }

                //Ask user if they are done or wants to compare to another house
                System.out.print("Would you like to finish(F) or compare(C) with another house? \n(F/C)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                //If they want to compare clone current house. If not displays final house.
                if (charInput == 'C') {
                    clone.setBedrooms(myHouse.getBedrooms());
                    clone.setBathrooms(myHouse.getBathrooms());
                    clone.setType(1);
                    clone.setCost(myHouse.getCost(userBedrooms, userBathrooms));
                } else if (charInput == 'F') {
                    System.out.printf("Your new home will be a Traditional House it will have" +
                            " %d bedrooms and %.1f bathrooms.\n"
                            + " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());
                    break;
                }


            } else if (obj instanceof Modern) {
                Modern myHouse = (Modern) obj;
                System.out.printf("The default layout for a Modern House is %d bedrooms and %.1f bathrooms." +
                        " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());
                System.out.print("Would you like add a bedroom to this layout?\n(Y/N");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Asks how many bedrooms user wants to add
                        System.out.print("How many bedrooms would you like to add?\n");
                        userHouseInput = input.next();

                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBedrooms(userBedrooms);
                        }
                    } while (numberInput == -1);
                }

                //Ask user if they want to add any bedrooms to the layout
                System.out.printf("Would you like to add any bathrooms to this layout? \n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Ask how many bathrooms user wants to add
                        System.out.print("How many bathrooms would you like to add?\n");
                        userHouseInput = input.next();

                        //Makes sure user entered a number
                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        //Displays error message if not a number. If number sets new amount of bedrooms.
                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBathrooms(userBathrooms);
                        }
                    } while (numberInput == -1);
                }

                //compares houses
                if (clone.getBedrooms() > 0) {
                    System.out.print("Compared to your " + clone.getType() + " house. " +
                            "This one has " + myHouse.getBedrooms() + " bedrooms and " + myHouse.getBathrooms() +
                            " bathrooms. \nYour " + clone.getType() +
                            " house had " + clone.getBedrooms() + " bedrooms and " + clone.getBathrooms() +
                            " bathrooms. The cost of the newer house is " + myHouse.getCost(userBedrooms, userBathrooms) +
                            " the old house cost " + clone.getCost(0, 0) +" \n");
                }

                //Ask user if they are done or wants to compare to another house
                System.out.print("Would you like to finish(F) or compare(C) with another house? \n(F/C)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                //If they want to compare clone current house. If not displays final house.
                if (charInput == 'C') {
                    clone.setBedrooms(myHouse.getBedrooms());
                    clone.setBathrooms(myHouse.getBathrooms());
                    clone.setType(1);
                    clone.setCost(myHouse.getCost(userBedrooms, userBathrooms));
                } else if (charInput == 'F') {
                    System.out.printf("Your new home will be a Traditional House it will have" +
                            " %d bedrooms and %.1f bathrooms.\n"
                            + " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());
                    break;
                }

            } else if (obj instanceof European) {
                European myHouse = (European) obj;
                System.out.printf("The default layout for a European House is %d bedrooms and %.1f bathrooms." +
                        " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());

                //Ask user if they want to add any bedrooms to the layout
                System.out.print("Would you like add a bedroom to this layout?\n(Y/N");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Asks how many bedrooms user wants to add
                        System.out.print("How many bedrooms would you like to add?\n");
                        userHouseInput = input.next();

                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBedrooms(userBedrooms);
                        }
                    } while (numberInput == -1);
                }

                System.out.printf("Would you like to add any bathrooms to this layout? \n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Ask how many bathrooms user wants to add
                        System.out.print("How many bathrooms would you like to add?\n");
                        userHouseInput = input.next();

                        //Makes sure user entered a number
                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        //Displays error message if not a number. If number sets new amount of bedrooms.
                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBathrooms(userBathrooms);
                        }
                    } while (numberInput == -1);
                }

                //compares houses
                if (clone.getBedrooms() > 0) {
                    System.out.print("Compared to your " + clone.getType() + " house. " +
                            "This one has " + myHouse.getBedrooms() + " bedrooms and " + myHouse.getBathrooms() +
                            " bathrooms. \nYour " + clone.getType() +
                            " house had " + clone.getBedrooms() + " bedrooms and " + clone.getBathrooms() +
                            " bathrooms. The cost of the newer house is " + myHouse.getCost(userBedrooms, userBathrooms) +
                            " the old house cost " + clone.getCost(0, 0) +" \n");
                }

                //Ask user if they are done or wants to compare to another house
                System.out.print("Would you like to finish(F) or compare(C) with another house? \n(F/C)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                //If they want to compare clone current house. If not displays final house.
                if (charInput == 'C') {
                    clone.setBedrooms(myHouse.getBedrooms());
                    clone.setBathrooms(myHouse.getBathrooms());
                    clone.setType(1);
                    clone.setCost(myHouse.getCost(userBedrooms, userBathrooms));
                } else if (charInput == 'F') {
                    System.out.printf("Your new home will be a Traditional House it will have" +
                            " %d bedrooms and %.1f bathrooms.\n"
                            + " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());
                    break;
                }

            } else if (obj instanceof Southwest) {
                Southwest myHouse = (Southwest) obj;
                System.out.printf("The default layout for a Southwest House is %d bedrooms and %.1f bathrooms." +
                        " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());

                //Ask user if they want to add any bedrooms to the layout
                System.out.print("Would you like add a bedroom to this layout?\n(Y/N");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Asks how many bedrooms user wants to add
                        System.out.print("How many bedrooms would you like to add?\n");
                        userHouseInput = input.next();

                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBedrooms(userBedrooms);
                        }
                    } while (numberInput == -1);
                }

                System.out.printf("Would you like to add any bathrooms to this layout? \n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Ask how many bathrooms user wants to add
                        System.out.print("How many bathrooms would you like to add?\n");
                        userHouseInput = input.next();

                        //Makes sure user entered a number
                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        //Displays error message if not a number. If number sets new amount of bedrooms.
                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBathrooms(userBathrooms);
                        }
                    } while (numberInput == -1);
                }

                //compares houses
                if (clone.getBedrooms() > 0) {
                    System.out.print("Compared to your " + clone.getType() + " house. " +
                            "This one has " + myHouse.getBedrooms() + " bedrooms and " + myHouse.getBathrooms() +
                            " bathrooms. \nYour " + clone.getType() +
                            " house had " + clone.getBedrooms() + " bedrooms and " + clone.getBathrooms() +
                            " bathrooms. The cost of the newer house is " + myHouse.getCost(userBedrooms, userBathrooms) +
                            " the old house cost " + clone.getCost(0, 0) +" \n");
                }

                //Ask user if they are done or wants to compare to another house
                System.out.print("Would you like to finish(F) or compare(C) with another house? \n(F/C)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                //If they want to compare clone current house. If not displays final house.
                if (charInput == 'C') {
                    clone.setBedrooms(myHouse.getBedrooms());
                    clone.setBathrooms(myHouse.getBathrooms());
                    clone.setType(1);
                    clone.setCost(myHouse.getCost(userBedrooms, userBathrooms));
                } else if (charInput == 'F') {
                    System.out.printf("Your new home will be a Traditional House it will have" +
                            " %d bedrooms and %.1f bathrooms.\n"
                            + " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());
                    break;
                }

            } else if (obj instanceof Mountain) {
                Mountain myHouse = (Mountain) obj;
                System.out.printf("The default layout for a Mountain House is %d bedrooms and %.1f bathrooms." +
                        " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());

                //Ask user if they want to add any bedrooms to the layout
                System.out.print("Would you like add a bedroom to this layout?\n(Y/N");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Asks how many bedrooms user wants to add
                        System.out.print("How many bedrooms would you like to add?\n");
                        userHouseInput = input.next();

                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBedrooms(userBedrooms);
                        }
                    } while (numberInput == -1);
                }

                //Ask user if they want to add any bathrooms to the layout
                System.out.printf("Would you like to add any bathrooms to this layout? \n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Ask how many bathrooms user wants to add
                        System.out.print("How many bathrooms would you like to add?\n");
                        userHouseInput = input.next();

                        //Makes sure user entered a number
                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        //Displays error message if not a number. If number sets new amount of bedrooms.
                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBathrooms(userBathrooms);
                        }
                    } while (numberInput == -1);
                }

                //compares houses
                if (clone.getBedrooms() > 0) {
                    System.out.print("Compared to your " + clone.getType() + " house. " +
                            "This one has " + myHouse.getBedrooms() + " bedrooms and " + myHouse.getBathrooms() +
                            " bathrooms. \nYour " + clone.getType() +
                            " house had " + clone.getBedrooms() + " bedrooms and " + clone.getBathrooms() +
                            " bathrooms. The cost of the newer house is " + myHouse.getCost(userBedrooms, userBathrooms) +
                            " the old house cost " + clone.getCost(0, 0) +" \n");
                }

                //Ask user if they are done or wants to compare to another house
                System.out.print("Would you like to finish(F) or compare(C) with another house? \n(F/C)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                //If they want to compare clone current house. If not displays final house.
                if (charInput == 'C') {
                    clone.setBedrooms(myHouse.getBedrooms());
                    clone.setBathrooms(myHouse.getBathrooms());
                    clone.setType(1);
                    clone.setCost(myHouse.getCost(userBedrooms, userBathrooms));
                } else if (charInput == 'F') {
                    System.out.printf("Your new home will be a Traditional House it will have" +
                            " %d bedrooms and %.1f bathrooms.\n"
                            + " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());
                    break;
                }

            } else if (obj instanceof Victorian) {
                Victorian myHouse = (Victorian) obj;
                System.out.printf("The default layout for a Victorian House is %d bedrooms and %.1f bathrooms." +
                        " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());

                //Ask user if they want to add any bedrooms to the layout
                System.out.print("Would you like add a bedroom to this layout?\n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Asks how many bedrooms user wants to add
                        System.out.print("How many bedrooms would you like to add?\n");
                        userHouseInput = input.next();

                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBedrooms(userBedrooms);
                        }
                    } while (numberInput == -1);
                }

                //Ask user if they want to add any bathrooms to the layout
                System.out.printf("Would you like to add any bathrooms to this layout? \n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Ask how many bathrooms user wants to add
                        System.out.print("How many bathrooms would you like to add?\n");
                        userHouseInput = input.next();

                        //Makes sure user entered a number
                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        //Displays error message if not a number. If number sets new amount of bedrooms.
                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBathrooms(userBathrooms);
                        }
                    } while (numberInput == -1);
                }

                //compares houses
                if (clone.getBedrooms() > 0) {
                    System.out.print("Compared to your " + clone.getType() + " house. " +
                            "This one has " + myHouse.getBedrooms() + " bedrooms and " + myHouse.getBathrooms() +
                            " bathrooms. \nYour " + clone.getType() +
                            " house had " + clone.getBedrooms() + " bedrooms and " + clone.getBathrooms() +
                            " bathrooms. The cost of the newer house is " + myHouse.getCost(userBedrooms, userBathrooms) +
                            " the old house cost " + clone.getCost(0, 0) +" \n");
                }

                //Ask user if they are done or wants to compare to another house
                System.out.print("Would you like to finish(F) or compare(C) with another house? \n(F/C)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                //If they want to compare clone current house. If not displays final house.
                if (charInput == 'C') {
                    clone.setBedrooms(myHouse.getBedrooms());
                    clone.setBathrooms(myHouse.getBathrooms());
                    clone.setType(1);
                    clone.setCost(myHouse.getCost(userBedrooms, userBathrooms));
                } else if (charInput == 'F') {
                    System.out.printf("Your new home will be a Traditional House it will have" +
                            " %d bedrooms and %.1f bathrooms.\n"
                            + " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());
                    break;
                }

            } else if (obj instanceof Country) {
                Country myHouse = (Country) obj;
                System.out.printf("The default layout for a Country House is %d bedrooms and %.1f bathrooms." +
                        " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());

                //Ask user if they want to add any bedrooms to the layout
                System.out.print("Would you like add a bedroom to this layout?\n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Asks how many bedrooms user wants to add
                        System.out.print("How many bedrooms would you like to add?\n");
                        userHouseInput = input.next();

                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBedrooms(userBedrooms);
                        }
                    } while (numberInput == -1);
                }

                //Ask user if they want to add any bathrooms to the layout
                System.out.printf("Would you like to add any bathrooms to this layout? \n(Y/N)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                if (charInput == 'Y') {
                    do {
                        //Ask how many bathrooms user wants to add
                        System.out.print("How many bathrooms would you like to add?\n");
                        userHouseInput = input.next();

                        //Makes sure user entered a number
                        try {
                            numberInput = Integer.parseInt(userHouseInput);
                        } catch (NumberFormatException e) {
                            numberInput = -1;
                        }

                        //Displays error message if not a number. If number sets new amount of bedrooms.
                        if (numberInput == -1) {
                            System.out.print("Please enter a valid number!\n");
                        } else {
                            userBedrooms = numberInput;
                            myHouse.setBathrooms(userBathrooms);
                        }
                    } while (numberInput == -1);
                }

                //compares houses
                if (clone.getBedrooms() > 0) {
                    System.out.print("Compared to your " + clone.getType() + " house. " +
                            "This one has " + myHouse.getBedrooms() + " bedrooms and " + myHouse.getBathrooms() +
                            " bathrooms. \nYour " + clone.getType() +
                            " house had " + clone.getBedrooms() + " bedrooms and " + clone.getBathrooms() +
                            " bathrooms. The cost of the newer house is " + myHouse.getCost(userBedrooms, userBathrooms) +
                            " the old house cost " + clone.getCost(0, 0) +" \n");
                }

                //Ask user if they are done or wants to compare to another house
                System.out.print("Would you like to finish(F) or compare(C) with another house? \n(F/C)");

                charInput = input.next().charAt(0);
                charInput = Character.toUpperCase(charInput);

                //If they want to compare clone current house. If not displays final house.
                if (charInput == 'C') {
                    clone.setBedrooms(myHouse.getBedrooms());
                    clone.setBathrooms(myHouse.getBathrooms());
                    clone.setType(1);
                    clone.setCost(myHouse.getCost(userBedrooms, userBathrooms));
                } else if (charInput == 'F') {
                    System.out.printf("Your new home will be a Traditional House it will have" +
                            " %d bedrooms and %.1f bathrooms.\n"
                            + " The total price is \n", myHouse.getBedrooms(), myHouse.getBathrooms());
                    break;
                }
            }
        } while (charInput != 'F');
    }

}
