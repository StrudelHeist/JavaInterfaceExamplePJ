package com.example;

public interface ICommand {
    // User Methods
    void Execute(Object... arguments);
    String GetDescription();
    void SetDescription(String text);
}
