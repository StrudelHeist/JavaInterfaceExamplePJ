package com.example;

import java.util.*;

public class CommandHandler {
    // Variables
    private Dictionary<String, ICommand> _commands;

    // Constructor
    public CommandHandler(){
        // Initialize
        _commands = new Hashtable<>();
    }

    // User Methods
    public void Start(){
        // Begin command loop
        while(true){
            // Write prompt
            System.out.print("$: ");

            // Get user input
            Scanner inScanner = new Scanner(System.in);
            String input = inScanner.nextLine();
            String[] args = input.split(" ");
            input = args[0];
            input = input.toUpperCase();
            if (args.length > 1)
                args = Arrays.copyOfRange(args, 1, args.length);

            // Check for base commands
            if (input.equals("EXIT")){
                System.out.println("Stopping command loop");
                inScanner.close();
                break;
            }
            else if (input.equals("HELP")){
                // Print list of available commands
                System.out.println("----- TEST PROGRAM V1.00 -----");
                System.out.println("Available commands:");
                System.out.println("\tEXIT: Closes the program");
                System.out.println("\tHELP: Shows this help text");
                Enumeration entries = _commands.keys();
                while(entries.hasMoreElements()){
                    String cmdName = (String)entries.nextElement();
                    System.out.print("\t");
                    System.out.print(cmdName);
                    System.out.print(": ");
                    System.out.println(_commands.get(cmdName).GetDescription());
                }
                System.out.println();
            }

            // Check for registered commands
            else{
                ICommand cmd = _commands.get(input);
                if (cmd == null){
                    System.out.println(
                            "Command \"" +
                                    input +
                                    "\" was unrecognized! Use \"HELP\"" +
                                    " for a list of available commands."
                    );
                    continue;
                }
                else{
                    // Execute registered command
                    cmd.Execute(args);
                }
            }
        }
    }
    public void RegisterCommand(String name, ICommand cmd){
        // Add command to the dictionary
        _commands.put(name.toUpperCase(), cmd);
    }
}
