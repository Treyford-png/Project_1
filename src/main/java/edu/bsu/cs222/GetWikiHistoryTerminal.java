package edu.bsu.cs222;

import java.util.Scanner;

/**
 * Second access point that allows user to switch to terminal version
 *
 * @author Holden Hankins
 */
public class GetWikiHistoryTerminal {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wikipedia Revision History\nPlease type the name of an article: ");
        String input = scanner.next();
        if (input.isEmpty()) {
            System.out.println("Error 400: bad request");
            return;
        }

        Controller controller = new Controller();
        System.out.println("\n" + controller.getOutput(input));
    }
}
