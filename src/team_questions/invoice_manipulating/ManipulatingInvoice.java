package team_questions.invoice_manipulating;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by FreakingM on 11/22/2016.
 */
public class ManipulatingInvoice {
    public static void main(String[] args) {
        //create Invoice objects
        Invoice electicSander = new Invoice(83, "Electric sander", 7, 57.98);
        Invoice powerSaw = new Invoice(24, "Power saw", 18, 99.99);
        Invoice sledgeHammer = new Invoice(7, "Sledge hammer", 11, 21.50);
        Invoice hammer = new Invoice(77, "Hammer", 76, 11.99);
        Invoice lawnMower = new Invoice(39, "Lawn mower", 3, 79.50);
        Invoice screwDriver = new Invoice(68, "Screwdriver", 106, 6.99);
        Invoice jigSaw = new Invoice(56, "Jig saw", 21, 11.00);
        Invoice wrench = new Invoice(3, "Wrench", 34, 7.50);
        Invoice[] invoices = {electicSander, powerSaw, sledgeHammer, hammer, lawnMower, screwDriver, jigSaw, wrench};

        //create functions for later use
        Function<Invoice, String> getDescription = Invoice::getPartDescription;
        Function<Invoice, Double> getPrice = Invoice::getPrice;
        Function<Invoice, Integer> getQuantity = Invoice::getQuantity;

        //question(a)
        title("(a)");
        System.out.println("invoices sorted by part description: ");
        title();
        Arrays.stream(invoices).sorted(Comparator.comparing(getDescription)).forEach(System.out::println);

        //question(b)
        title("(b)");
        System.out.println("invoices sorted by price: ");
        title();
        Arrays.stream(invoices).sorted(Comparator.comparing(getPrice)).forEach(System.out::println);

        //question(c)
        title("(c)");
        System.out.printf("%-15s%13s%n", "Description", "Quantity");
        Map<String, Integer> map = Arrays.stream(invoices).collect(Collectors.toMap(getDescription, getQuantity));
        map.entrySet().stream().sorted(Comparator.comparing(maps -> maps.getValue())).forEach(Map -> System.out.printf("%-15s%10d%n", Map.getKey(), Map.getValue()));

        //question(d)
        title("(d)");
        System.out.printf("%-15s%10s%n", "Description", "Value");
        Map<String, Double> map1 = Arrays.stream(invoices).collect(Collectors.toMap(getDescription, invoice -> invoice.getPrice() * invoice.getQuantity()));
        map1.entrySet().stream().sorted(Comparator.comparing(maps -> maps.getValue())).forEach(newMap -> System.out.printf("%-15s%10.2f%n", newMap.getKey(), newMap.getValue()));

        //question(e)
        title("(e)");
        System.out.printf("select Invoice values in range $200 to $500%n%-15s%10s%n", "Description", "Value");
        map1.entrySet().stream().filter(invoice -> invoice.getValue() >= 200 && invoice.getValue() <= 500)
                .sorted(Comparator.comparing(maps -> maps.getValue())).forEach(newMap -> System.out.printf("%-15s%10.2f%n", newMap.getKey(), newMap.getValue()));
    }

    //print title
    public static void title()
    {
        System.out.printf("%-15s%-20s%-10s%5s%n","Part number","Part description","Quantity","Price");
    }
    public static void title(String str){
        System.out.println();
        System.out.println(str);
    }
}
