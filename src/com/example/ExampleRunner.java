package com.example;

import java.util.ArrayList;
import java.util.List;

public class ExampleRunner {
    // Variables
    private CommandHandler _handler;

    // Constructor
    public ExampleRunner(){
        // Initialize
        _handler = new CommandHandler();

        // Register commands
        PrintDemo pDemo = new PrintDemo();
        MockDemo mDemo = new MockDemo();
        _handler.RegisterCommand("pdemo", pDemo);
        _handler.RegisterCommand("mdemo", mDemo);
    }

    // User Methods
    public void Start(){
        // Start command handler
        _handler.Start();
    }

    // Command Definitions
    private class PrintDemo implements ICommand{
        // Variables
        private String _description;

        // Constructor
        public PrintDemo(){
            // Initialize
            _description = "Demonstrates different types of objects that implement the IPrinter interface";
        }

        // User Methods
        public String GetDescription(){
            return _description;
        }
        public void SetDescription(String text){
            _description = text;
        }
        public void Execute(Object... params){
            // Demonstrate printer interface
            List<IPrinter> printerList = new ArrayList<>();
            printerList.add(new JacobPrinter());
            printerList.add(new GabePrinter());
            for(IPrinter printer : printerList){
                // Print the printer
                System.out.print("Current printer is: ");
                printer.Print();
            }
        }
    }
    private class MockDemo implements ICommand{
        // Variables
        private String _description;

        // Constructor
        public MockDemo(){
            // Initialize
            _description = "Shows how interfaces allow easy code switching between production and test objects";
        }

        // User Methods
        public void Execute(Object... arguments) {
            // You can easily set "imageView" to be the production
            // or the mock depending on what you're doing
            ICanShowImages imageView = new ProductionImageView();
            imageView.ShowImage();
        }
        public String GetDescription() {
            return _description;
        }
        public void SetDescription(String text) {
            _description = text;
        }
    }
}
