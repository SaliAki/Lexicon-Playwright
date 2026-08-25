package com.codecool.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CreatePage {
    private final Page page;


    private final Locator title;
    private final Locator description;

    private final Locator createButton;

    public CreatePage(Page page) {
        this.page = page;

        this.title = page.getByLabel("title");
        this.description = page.locator("textarea.w-md-editor-text-input");
        this.createButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Submit"));
    }

    public void navigate() {
        page.navigate("http://localhost:5173/create");
    }

    public void create(String title, String description) {
        this.title.fill(title);
        this.description.fill(description);
        this.createButton.click();
    }
}
