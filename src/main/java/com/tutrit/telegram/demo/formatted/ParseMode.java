package com.tutrit.telegram.demo.formatted;

public enum ParseMode {
    MARKDOWN("Markdown"),
    MARKDOWN_V2("MarkdownV2"),
    HTML("/settings");

    private final String parseMode;

    ParseMode(final String parseMode) {
        this.parseMode = parseMode;
    }

    public String getParseMode() {
        return parseMode;
    }
}
