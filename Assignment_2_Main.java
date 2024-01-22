import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static ArrayList<Symbol> symbols = new ArrayList<>();
    static int serial = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("################################");
            System.out.println("1. Insert\n2. Drop\n3. Update\n4. Lookup\n5. Exit");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.print("Declare variable: ");
                    String variable = input.nextLine();
                    insert(variable);
                    break;

                case 2:
                    input.nextLine();
                    System.out.print("Enter the variable name for remove: ");
                    String x = input.nextLine();
                    delete(x);
                    break;

                case 3:
                    input.nextLine();
                    System.out.print("Enter the variable name for update: ");
                    String nameForUpdateValue = input.nextLine();
                    System.out.println("New value for '" + nameForUpdateValue + "' variable:");
                    String updatedValue = input.nextLine();
                    update(nameForUpdateValue, updatedValue);
                    break;

                case 4:
                    input.nextLine();
                    System.out.print("Enter the variable name for lookup: ");
                    String nameForLookup = input.nextLine();
                    lookup(nameForLookup);
                    break;

                case 5:
                    input.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Choose a valid option.");
            }
        }
    }

    private static void insert(String x) {
        String[] tokens = x.split("[,; ]");

        String type = null;
        String name = null;
        String value = null;
        int zero = 0;

        for (int i = 0; i < tokens.length; i++) {
            value = null;

            if (i == 0) {
                type = tokens[zero];
            }

            else {
                String[] subtoken = tokens[i].split("=");
                if (subtoken.length == 2) {
                    name = subtoken[zero];
                    value = subtoken[1];
                    Symbol s1 = new Symbol(serial, name, type, value);
                    symbols.add(s1);
                    serial++;
                }
                else {
                    name = subtoken[zero];
                    value = null;
                    Symbol s1 = new Symbol(serial, name, type, value);
                    symbols.add(s1);
                    serial++;
                }
            }
        }

        System.out.println("Variable inserted successfully.");
    }

    private static void lookup(String x) {
        int flag = 0;

        for (Symbol symbol : symbols) {
            if (symbol.getName().equals(x)) {
                System.out.println("SL\tNAME\tTYPE\tVALUE");
                flag = 1;
                System.out.println(symbol);
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Not found");
        }
    }

    private static void delete(String name) {
        Iterator<Symbol> iterator = symbols.iterator();
        while (iterator.hasNext()) {
            Symbol symbol = iterator.next();
            if (symbol.getName().equals(name)) {
                iterator.remove();
                System.out.println("Variable removed successfully.");
                return;
            }
        }
        System.out.println("Variable not found for remove.");
    }

    private static void update(String name, String newValue) {
        for (Symbol symbol : symbols) {
            if (symbol.getName().equals(name)) {
                symbol.setValue(newValue);
                System.out.println("Variable '"+name+"' updated successfully.");
                return;
            }
        }
        System.out.println("Variable not found for update");
    }
}
