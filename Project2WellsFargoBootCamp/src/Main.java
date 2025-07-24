package tradereconciliation;

//Importing data collection through .util and I/O through .io.
import java.util.*;
import java.io.*;

public class Main 
{
    public static void main(String[] args) 
    {
        try {
 
        	//Store the ClientOrders in an ArrayList called clientOrders
            List<ClientOrder> clientOrders = OrderReader.readClientOrders("client_order_error.csv");
            //Store the ChildOrders in an ArrayList called childOrders
            List<ChildOrder> childOrders = OrderReader.readChildOrders("child_order_error.csv");

            //Calling the static method, reconcile, from the OrderReconciler class
            //Takes two ArrayList as arguments
            OrderReconciler.reconcile(clientOrders, childOrders);

            //Calling the static method, generateReport, from the ReportGenerator class
            //Takes one ArrayList as arguments
            ReportGenerator.generateReport(clientOrders);
            
            //Create and start a new thread to export the client report
            //without blocking the main program
            Thread reportThread = new Thread(new ReportExport(clientOrders, "client_report.csv"));
            reportThread.start();
  
        } 
        catch (IOException e) 
        {
        	//Handles error that may occur when reading CSV file
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}


