
package Collections;

import java.util.LinkedList;
import java.util.Queue;

class Ticket {
    int ticketId;
    String customerName;
    String issueDescription;

    public Ticket(int ticketId, String customerName, String issueDescription) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
    }

    public void displayTicket() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Issue: " + issueDescription);
        System.out.println("---------------------------");
    }
}

public class CustomerServiceTicketManagement {

    public static void main(String[] args) {

        Queue<Ticket> tickets = new LinkedList<>();

        // 1. Add new tickets to the queue
        tickets.offer(new Ticket(101, "Neha", "Internet not working"));
        tickets.offer(new Ticket(102, "Rahul", "Unable to login"));
        tickets.offer(new Ticket(103, "Priya", "Payment failed"));

        // 2. Display the next ticket without removing it
        System.out.println("NEXT TICKET TO BE PROCESSED:");

        if (tickets.isEmpty()) {
            System.out.println("No tickets are pending");
        } else {
            tickets.peek().displayTicket();
        }

        // 3. Process the next ticket
        System.out.println("PROCESSING TICKET:");

        if (tickets.isEmpty()) {
            System.out.println("No tickets are pending");
        } else {
            Ticket processedTicket = tickets.poll();
            System.out.println("Processing the following ticket:");
            processedTicket.displayTicket();
        }

        // 4. Display all pending tickets
        System.out.println("PENDING TICKETS:");

        if (tickets.isEmpty()) {
            System.out.println("No tickets are pending");
        } else {
            for (Ticket ticket : tickets) {
                ticket.displayTicket();
            }
        }

        // 5. Display total pending tickets
        System.out.println("Total pending tickets: " + tickets.size());
    }
}
