package com.tutrit.telegram.demo.command;

public enum GlobalCommands {
    START("/start"),
    HELP("/help"),
    SETTINGS("/settings");

    private final String command;

    GlobalCommands(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
