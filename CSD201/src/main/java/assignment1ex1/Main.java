package assignment1ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import assignment1ex1.LinkedList;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final String err_msg_wronginp = "\t[ERROR] Wrong input, try again!";

    private static LinkedList<Book> lstBooks = null;
    private static LinkedList<Reader> lstReaders = null;
    private static LinkedList<Lending> lstLending = new LinkedList<>();

    public static void main(String[] args) {
        String main_select;
        boolean isContinue;
        do {
            System.out.println("======= Library Manager System (LMS) =======");
            System.out.println("1. Books manager");
            System.out.println("2. Readers manager");
            System.out.println("3. Lending manager");
            System.out.println("4. Exit");
            System.out.println(">> Enter your choice (1-4): ");
            do {
                System.out.print("Your choice: ");
                main_select = in.nextLine();
                isContinue = false;
                try {
                    switch (Integer.parseInt(main_select)) {
                    case 1:
                        funcBook();
                        break;
                    case 2:
                        funcReader();
                        break;
                    case 3:
                        funcLending();
                        break;
                    case 4:
                        in.close();
                        System.out.println("Exit program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println(err_msg_wronginp);
                        isContinue = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(err_msg_wronginp);
                    isContinue = true;
                }
            } while (isContinue);

            System.out.print("Press Enter key to continue...");
            in.nextLine();
            System.out.println();
        } while (true);
    }

    // #region Function book manager
    private static void funcBook() {
        String main_select;
        boolean isContinue;
        do {
            System.out.println("======= Books Manager Function =======");
            System.out.println("1.1.  Load data from file");
            System.out.println("1.2.  Input & add to the end");
            System.out.println("1.3.  Display data");
            System.out.println("1.4.  Save book list to file");
            System.out.println("1.5.  Search by bcode");
            System.out.println("1.6.  Delete by bcode");
            System.out.println("1.7.  Sort by bcode");
            System.out.println("1.8.  Input & add to beginning");
            System.out.println("1.9.  Add after position  k");
            System.out.println("1.10. Delete position k");
            System.out.println("1.11. [EXIT FUNCTION]");
            System.out.println(">> Enter your choice (1-11): ");
            do {
                System.out.print("Your choice: ");
                main_select = in.nextLine();
                isContinue = false;
                try {
                    switch (Integer.parseInt(main_select)) {
                    case 1:
                        funcBook_LoadData();
                        break;
                    case 2:
                        funcBook_InputData_toEnd();
                        break;
                    case 3:
                        funcBook_DisplayData();
                        break;
                    case 4:
                        funcBook_SaveData();
                        break;
                    case 5:
                        funcBook_SearchByBCode();
                        break;
                    case 6:
                        funcBook_DeleteByBCode();
                        break;
                    case 7:
                        funcBook_SortByBCode();
                        break;
                    case 8:
                        funcBook_InputData_toBeginning();
                        break;
                    case 9:
                        funcBook_AddAfterPosition();
                        break;
                    case 10:
                        funcBook_DeleteAtPosition();
                        break;
                    case 11:
                        System.out.println(">> Saving your data...");
                        System.out.println(">> Exit function Book()...");
                        return;
                    default:
                        System.out.println(err_msg_wronginp);
                        isContinue = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(err_msg_wronginp);
                    isContinue = true;
                }
            } while (isContinue);

            System.out.print("Press Enter key to continue...");
            in.nextLine();
            System.out.println();
        } while (true);
    }

    private static void funcBook_LoadData() {
        File fBooks = new File("lms-books.txt");
        lstBooks = new LinkedList<>();

        try {
            System.out.print(">> Please enter file name: ");
            String fname = in.nextLine();

            fBooks = new File(fname);
            BufferedReader br = new BufferedReader(new FileReader(fBooks));
            String str;
            while ((str = br.readLine()) != null) {
                String[] data = str.split("\\|");
                lstBooks.add(new Book(data[0].trim(), data[1].trim(), Integer.parseInt(data[2].trim()), 0,
                        Double.parseDouble(data[3].trim())));
            }

            for (Book e : lstBooks) {
                System.out.println(e.toString());
            }

            System.out.println(">> Load data completed!");

            br.close();
        } catch (IOException e) {
            System.out.println(">> [ERORR 404] File not found.");
        }
    }

    private static void funcBook_InputData_toEnd() {
        String bcode, name;
        int quantity;
        double price;

        System.out.print("Enter Book code: ");
        bcode = in.nextLine();
        System.out.print("Enter Book name: ");
        name = in.nextLine();
        quantity = (int) Enter_num("Enter Book quantity: ", err_msg_wronginp);
        price = Enter_num("Enter Book price: ", err_msg_wronginp);

        lstBooks.add(new Book(bcode, name, quantity, 0, price));
    }

    private static void funcBook_DisplayData() {
        System.out.println("code\t| Title\t\t| Quantity\t| Lended\t| Price | Value");
        System.out.println("---------------------------------------------------------------------------------");
        for (Book e : lstBooks) {
            System.out.println(e.getInfo());
        }
    }

    private static void funcBook_SaveData() {
        File fBooks = new File("lms-books.txt");

        try {
            System.out.print(">> Please enter file name: ");
            String fname = in.nextLine();

            fBooks = new File(fname);
            BufferedWriter br = new BufferedWriter(new FileWriter(fBooks));

            for (Book e : lstBooks) {
                br.write(e.toString());
                br.newLine();
            }

            br.close();

            System.out.println(">> Save data completed!");

        } catch (IOException e) {
            System.out.println(">> [ERORR 404] File not found.");
            e.printStackTrace();
        }
    }

    private static Book funcBook_SearchByBCode() {
        System.out.print(">> Please enter bcode to search: ");
        String bcode = in.nextLine();

        System.out.println("code\t| Title\t\t| Quantity\t| Lended\t| Price | Value");
        System.out.println("---------------------------------------------------------------------------------");
        for (Book e : lstBooks) {
            if (e.getBcode().equals(bcode)) {
                System.out.println(e.getInfo());
                return e;
            }
        }
        System.out.println("[MSG] Book not found!");
        return null;
    }

    private static void funcBook_DeleteByBCode() {
        System.out.print(">> Please enter bcode to delete: ");
        String bcode = in.nextLine();

        for (Book e : lstBooks) {
            if (e.getBcode().equals(bcode)) {
                lstBooks.remove(e);
                System.out.println(">> [Deleted] " + e.getInfo());
                return;
            }
        }
        System.out.println("Khong co bcode :)");
    }

    // Chua lam ham nay
    private static void funcBook_SortByBCode() {
        lstBooks.sort();
        System.out.println(">> Done!");
    }

    private static void funcBook_InputData_toBeginning() {
        String bcode, name;
        int quantity;
        double price;

        System.out.print("Enter Book code: ");
        bcode = in.nextLine();
        System.out.print("Enter Book name: ");
        name = in.nextLine();
        quantity = (int) Enter_num("Enter Book quantity: ", err_msg_wronginp);
        price = Enter_num("Enter Book price: ", err_msg_wronginp);

        lstBooks.addToHead(new Book(bcode, name, quantity, 0, price));
    }

    private static void funcBook_AddAfterPosition() {
        String bcode, name;
        int quantity;
        double price;

        System.out.print("Enter Book code: ");
        bcode = in.nextLine();
        System.out.print("Enter Book name: ");
        name = in.nextLine();
        quantity = (int) Enter_num("Enter Book quantity: ", err_msg_wronginp);
        price = Enter_num("Enter Book price: ", err_msg_wronginp);

        Book bk = funcBook_SearchByBCode();
        for (Book e : lstBooks) {
            if (e == bk) {
                lstBooks.addAfterElement(e, new Book(bcode, name, quantity, 0, price));
            }
        }
        System.out.println(">> Add success!");
    }

    private static void funcBook_DeleteAtPosition() {
        int iPos;
        iPos = (int) Enter_num("Enter position to remove: ", err_msg_wronginp);
        lstBooks.removeAt(iPos);
    }
    // #endregion

    // #region Function reader manager
    private static void funcReader() {
        String main_select;
        boolean isContinue;
        do {
            System.out.println("======= Readers Manager Function =======");
            System.out.println("1.1.  Load data from file");
            System.out.println("2.2.  Input & add to the end");
            System.out.println("2.3.  Display data");
            System.out.println("2.4.  Save reader list to file");
            System.out.println("2.5.  Search by rcode");
            System.out.println("2.6.  Delete by rcode");
            System.out.println("2.7.  [EXIT FUNCTION]");
            System.out.println(">> Enter your choice (1-7): ");
            do {
                System.out.print("Your choice: ");
                main_select = in.nextLine();
                isContinue = false;
                try {
                    switch (Integer.parseInt(main_select)) {
                    case 1:
                        funcReader_LoadData();
                        break;
                    case 2:
                        funcReader_InputData_toEnd();
                        break;
                    case 3:
                        funcReader_DisplayData();
                        break;
                    case 4:
                        funcReader_SaveBookList();
                        break;
                    case 5:
                        funcReader_SearchByRCode();
                        break;
                    case 6:
                        funcReader_DeleteByBCode();
                        break;
                    case 7:
                        System.out.println(">> Saving your data...");
                        System.out.println(">> Exit function Reader()...");
                        return;
                    default:
                        System.out.println(err_msg_wronginp);
                        isContinue = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(err_msg_wronginp);
                    isContinue = true;
                }
            } while (isContinue);

            System.out.print("Press Enter key to continue...");
            in.nextLine();
            System.out.println();
        } while (true);
    }

    private static void funcReader_LoadData() {
        File fReaders = new File("lms-readers.txt");
        lstReaders = new LinkedList<>();

        try {
            System.out.print(">> Please enter file name: ");
            String fname = in.nextLine();

            fReaders = new File(fname);
            BufferedReader br = new BufferedReader(new FileReader(fReaders));
            String str;
            while ((str = br.readLine()) != null) {
                String[] data = str.split("\\|");
                lstReaders.add(new Reader(data[0].trim(), data[1].trim(), Integer.parseInt(data[2].trim())));
            }

            for (Reader e : lstReaders) {
                System.out.println(e.toString());
            }

            System.out.println(">> Load data complete!");

            br.close();
        } catch (IOException e) {
            System.out.println(">> Not found dada, create empty data.");
        }
    }

    private static void funcReader_InputData_toEnd() {
        String rcode, name;
        int byear;

        System.out.print("Enter Reader code: ");
        rcode = in.nextLine();
        System.out.print("Enter Reader name: ");
        name = in.nextLine();
        byear = (int) Enter_num("Enter this year: ", err_msg_wronginp);

        lstReaders.add(new Reader(rcode, name, byear));
    }

    private static void funcReader_DisplayData() {
        System.out.println("code\t| Name\t\t| Year");
        System.out.println("----------------------------------------");
        for (Reader e : lstReaders) {
            System.out.println(e.toString());
        }
    }

    private static void funcReader_SaveBookList() {
        File fBooks = new File("lms-readers.txt");

        try {
            System.out.print(">> Please enter file name: ");
            String fname = in.nextLine();

            fBooks = new File(fname);
            BufferedWriter br = new BufferedWriter(new FileWriter(fBooks));

            for (Reader e : lstReaders) {
                br.write(e.toString());
                br.newLine();
            }

            br.close();

            System.out.println(">> Save data completed!");

        } catch (IOException e) {
            System.out.println(">> [ERORR 404] File not found.");
            e.printStackTrace();
        }
    }

    private static Reader funcReader_SearchByRCode() {
        System.out.print(">> Please enter rcode to search: ");
        String rcode = in.nextLine();

        System.out.println("code\t| Name\t\t| Year");
        System.out.println("----------------------------------------");
        for (Reader e : lstReaders) {
            if (e.getRcode().equals(rcode)) {
                System.out.println(e.toString());
                return e;
            }
        }
        System.out.println("[MSG] Reader not found!");
        return null;
    }

    private static void funcReader_DeleteByBCode() {
        System.out.print(">> Please enter rcode to delete: ");
        String rcode = in.nextLine();

        for (Reader e : lstReaders) {
            if (e.getRcode().equals(rcode)) {
                lstReaders.remove(e);
                System.out.println(">> [Deleted] " + e.toString());
                return;
            }
        }
        System.out.println("Khong co rcode :)");
    }
    // #endregion

    // #region Function lending manager
    private static void funcLending() {
        System.out.print("Enter book code: ");
        String bcode = in.nextLine();
        System.out.print("Enter reader code: ");
        String rcode = in.nextLine();
        System.out.print("Enter state: ");
        int state = Integer.parseInt(in.nextLine());

        if (funcLending_VerifyData(bcode, rcode)) {
            if (!lstLending.isEmpty()) {
                for (Lending e : lstLending) {
                    if (e.getBcode().equals(bcode) && e.getRcode().equals(rcode) && state == 1) {
                        System.out.println(">> Entered data is not accepted!");
                        return;
                    }
                }
            }

            Book bk = getBookByBcode(bcode);
            if (bk.getQuantity() == bk.getLended()) {
                lstLending.add(new Lending(bcode, rcode, 0));
            } else if (bk.getQuantity() < bk.getLended()) {
                bk.lended++;
                lstLending.add(new Lending(bcode, rcode, 1));
            }
        } else {
            System.out.println(">> Entered data is not accepted!");
        }

        System.out.println("=== Lended list ===");
        if (!lstLending.isEmpty()) {
            for (Lending e : lstLending) {
                System.out.println(e.toString());
            }
        }
    }

    private static boolean funcLending_VerifyData(String bcode, String rcode) {
        return listBookContainBCode(bcode) && listReaderContainRCode(rcode);
    }
    // #endregion

    // #region other function
    // Kiểm tra trong listbook có bcode không
    private static boolean listBookContainBCode(String bcode) {
        for (Book e : lstBooks) {
            if (bcode.equals(e.getBcode()))
                return true;
        }
        return false;
    }

    // Kiểm tra trong listreader có rcode không
    private static boolean listReaderContainRCode(String rcode) {
        for (Reader e : lstReaders) {
            if (rcode.equals(e.getRcode())) {
                return true;
            }
        }
        return false;
    }

    // Hàm tìm một quyển sách bằng bcode
    private static Book getBookByBcode(String bcode) {
        for (Book e : lstBooks) {
            if (bcode.equals(e.getBcode()))
                return e;
        }
        return null;
    }

    private static double Enter_num(String str_show, String err_msg) // this is checkin function
    {
        String entered;
        do {
            System.out.print(str_show);
            entered = in.nextLine();
            try {
                return Integer.parseInt(entered);
            } catch (NumberFormatException e) {
                System.out.println(err_msg);
            }
        } while (true);
    }
    // #endregion
}