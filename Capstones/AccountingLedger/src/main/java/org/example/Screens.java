package org.example;

import java.util.Scanner;


public class Screens {
    private static final Scanner scanner = new Scanner(System.in);

    public static void HomeScreen() {
        System.out.println("""
                                    
                ┍━━━━»•»🌸«•«━┑HELLO AND WELCOME TO YOUR ACCOUNTING LEDGER┕━»•»🌸«•«━━━━┙
                                    
                ┍━━━━»•»🌸«•«━┑What would you like to do first?┕━»•»🌸«•«━━━━┙
                🌸A)Add a deposit
                🌸D)Make a payment
                🌸L)View your ledger
                🌸X)exit the application""");
        String choice1 = scanner.nextLine();
        switch (choice1.toLowerCase()) {
            case "a":
                FileManager.addDeposit();
                break;
            case "d":
                FileManager.makePayment();
                break;
            case "l":
                ledgerScreen();
                break;
            case "x":
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
                System.out.println("⚠ SORRY THAT IS NOT AN OPTION, PLEASE TRY AGAIN! ⚠\n");
                Screens.HomeScreen();
                break;
        }
    }

    public static void moreOptions() {
        System.out.println("""
                GREAT! Your deposit has been added!
                                
                ┍━━━━»•»🌸«•«━┑What would you like to do now?┕━»•»🌸«•«━━━━┙
                                
                🌸A)Make more deposits please!
                🌸D)Make a payment!
                🌸L)View Ledger...
                🌸X)Exit application""");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "a":
                FileManager.addDeposit();
                break;
            case "d":
                FileManager.makePayment();
                break;
            case "l":
                ledgerScreen();
                break;
            case "x":
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
                break;
            default:
                System.out.println("⚠ SORRY THAT IS NOT AN OPTION, PLEASE TRY AGAIN! ⚠\n");
                moreOptions();
                break;
        }
    }

    public static void moreOptions2() {
        System.out.println("""
                GREAT! Your payment has been processed!
                                
                ┍━━━━»•»🌸«•«━┑What would you like to do now?┕━»•»🌸«•«━━━━┙
                                
                🌸D)Make more payments please!
                🌸A)Make a deposit!
                🌸L)View Ledger...
                🌸X)Exit application""");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "d":
                FileManager.makePayment();
                break;
            case "a":
                FileManager.addDeposit();
                break;
            case "l":
                ledgerScreen();
                break;
            case "x":
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
                break;
            default:
                System.out.println("⚠ SORRY THAT IS NOT AN OPTION, PLEASE TRY AGAIN! ⚠\n");
                moreOptions2();
                break;
        }
    }

    public static void ledgerScreen() {
        System.out.println("""
                                
                ┍━━━━»•»🌸«•«━┑Please select one of the following options┕━»•»🌸«•«━━━━┙
                🌸A) Display all entries
                🌸D) Display all deposits
                🌸P) Display all payments
                🌸R) Reports screen
                🌸H) Home""");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "a":
                System.out.println("🌸--------DISPLAYING ALL ENTRIES--------🌸");
                FileManager.displayAllEntries();
                ledgerScreen();
                break;
            case "d":
                System.out.println("🌸--------DISPLAYING DEPOSITS--------🌸");
                FileManager.displayAllDeposits();
                ledgerScreen();
                break;
            case "p":
                System.out.println("🌸--------DISPLAYING PAYMENTS--------🌸");
                FileManager.displayAllPayments();
                ledgerScreen();
                break;
            case "r":
                System.out.println("🌸--------REPORTS SCREEN--------🌸");
                Screens.reportsScreen();
                break;
            case "h":
                System.out.println("🌸--------REDIRECTING TO HOME SCREEN--------🌸");
                HomeScreen();
                break;
            default:
                System.out.println("⚠ SORRY THAT IS NOT AN OPTION, PLEASE TRY AGAIN! ⚠");
                ledgerScreen();
                break;
        }
    }

    public static void reportsScreen() {
        System.out.println("""
                
                ┍━━━━»•»🌸«•«━┑How would you like to sort the data?┕━»•»🌸«•«━━━━┙
                🌸M) Month To Date
                🌸P) Previous Month
                🌸Y) Year to Date
                🌸T) Previous Year
                🌸V) Search By Vendor
                🌸R) Go back""");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "m":
                System.out.println("🌸--------MONTH TO DATE--------🌸");
                Reports.filterByMonthToDate();
                reportsScreen();
                break;
            case "p":
                System.out.println("🌸--------PREVIOUS MONTH--------🌸");
                Reports.filterByPreviousMonth();
                reportsScreen();
                break;
            case "y":
                System.out.println("🌸--------YEAR-TO-DATE--------🌸");
                Reports.filterByYearToDate();
                reportsScreen();
                break;
            case "t":
                System.out.println("🌸--------PREVIOUS YEAR--------🌸");
                Reports.filterByPreviousYear();
                reportsScreen();
                break;
            case "v":
                System.out.println("🌸--------DISPLAY BY VENDOR--------🌸");
                Reports.searchByVendor();
                reportsScreen();
                break;
            case "r":
                ledgerScreen();
                break;
            default:
                System.out.println("⚠ SORRY THAT IS NOT AN OPTION, PLEASE TRY AGAIN! ⚠");
                reportsScreen();
                break;
        }
    }
}
