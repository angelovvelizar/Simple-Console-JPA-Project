package bg.softuni.web.superMarket.commandLineRunner;

import bg.softuni.web.superMarket.services.CategoryService;
import bg.softuni.web.superMarket.services.TownService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final CategoryService categoryService;
    private final TownService townService;

    public CommandLineRunner(CategoryService categoryService, TownService townService) {
        this.categoryService = categoryService;
        this.townService = townService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hi");
        while (true) {
            System.out.println("Choose option from: ");
            System.out.println(printOptions());
            String input = bufferedReader.readLine();

            switch (input) {
                case "1":
                    addCategory();
                    break;
                case "2":
                    addTown();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "Exit":
                    return;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        }
    }

    private void addTown() throws IOException {
        System.out.println("Enter town name:");
        String town = bufferedReader.readLine();

        System.out.println(this.townService.addTown(town));
    }

    private void addCategory() throws IOException {
        System.out.println("Enter category name: ");
        String category = bufferedReader.readLine();

        System.out.println(this.categoryService.addCategory(category));

    }

    private String printOptions() {

        return "1 - for Add Category "
                + "\n2 - for Add Town "
                + "\n3 - for Add Shop"
                + "\n4 - for Add Seller "
                + "\n5 - for Add Product "
                + "\n6 - for Set seller new manager "
                + "\n7 - for Distributing product in shops "
                + "\n8 - for Showing all sellers in Shop "
                + "\n9 - for Showing all products in Shop "
                + "\nExit - to close the program";
    }
}
