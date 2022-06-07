package bg.softuni.web.superMarket.commandLineRunner;

import bg.softuni.web.superMarket.models.dtos.SellerAddDto;
import bg.softuni.web.superMarket.models.dtos.ShopAddDto;
import bg.softuni.web.superMarket.models.dtos.TownAddDto;
import bg.softuni.web.superMarket.services.CategoryService;
import bg.softuni.web.superMarket.services.SellerService;
import bg.softuni.web.superMarket.services.ShopService;
import bg.softuni.web.superMarket.services.TownService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final CategoryService categoryService;
    private final TownService townService;
    private final ShopService shopService;
    private final SellerService sellerService;

    public CommandLineRunner(CategoryService categoryService, TownService townService, ShopService shopService, SellerService sellerService) {
        this.categoryService = categoryService;
        this.townService = townService;
        this.shopService = shopService;
        this.sellerService = sellerService;
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
                    addShop();
                    break;
                case "4":
                    addSeller();
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

    private void addSeller() throws IOException {
        System.out.println("Enter seller details in format: firstName lastName age salary shopName");
        String[] sellerInfo = bufferedReader.readLine().split("\\s+");
        String output = this.sellerService.addSeller(new SellerAddDto(sellerInfo[0],
                                                    sellerInfo[1],
                                                    Integer.parseInt(sellerInfo[2]),
                                                    new BigDecimal(sellerInfo[3]),
                                                    sellerInfo[4]));
        System.out.println(output);


    }

    private void addShop() throws IOException {
        System.out.println("Enter shop details in format: name address town");
        String[] shopInfo = bufferedReader.readLine().split("\\s+");
        String output = this.shopService.addShop(new ShopAddDto(shopInfo[0], shopInfo[1], new TownAddDto(shopInfo[2])));
        System.out.println(output);

    }

    private void addTown() throws IOException {
        System.out.println("Enter town name:");
        String town = bufferedReader.readLine();

        System.out.println(this.townService.addTown(new TownAddDto(town)));
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
