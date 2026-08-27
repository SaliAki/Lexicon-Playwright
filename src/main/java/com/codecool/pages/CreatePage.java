package com.codecool.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CreatePage {
    private final Page page;

    private final Locator title;
    private final Locator description;

    private final Locator editorBtnBold;
    private final Locator editorBtnItalic;
    private final Locator editorBtnStrikethrough;
    private final Locator editorBtnInsertHorizontalLine;
    private final Locator editorBtnInsertTitle;

    private final Locator editorBtnInsertLink;
    private final Locator editorBtnInsertQuote;
    private final Locator editorBtnInsertCode;
    private final Locator editorBtnInsertCodeBlock;
    private final Locator editorBtnInsertComment;
    private final Locator editorBtnInsertImage;
    private final Locator editorBtnInsertTable;

    private final Locator editorBtnAddUnorderedList;
    private final Locator editorBtnAddOrderedList;
    private final Locator editorBtnAddCheckedList;
    private final Locator editorBtnHelp;

    private final Locator createButton;

    public CreatePage(Page page) {
        this.page = page;

        this.title = page.getByLabel("title");
        this.description = page.locator("textarea.w-md-editor-text-input");

        this.editorBtnBold = page.locator("button[data-name='bold']");
        this.editorBtnItalic = page.locator("button[data-name='italic']");
        this.editorBtnStrikethrough = page.locator("button[data-name='strikethrough']");
        this.editorBtnInsertHorizontalLine = page.locator("button[data-name='hr']");
        this.editorBtnInsertTitle = page.locator("button[data-name='title']");

        this.editorBtnInsertLink = page.locator("button[data-name='link']");
        this.editorBtnInsertQuote = page.locator("button[data-name='quote']");
        this.editorBtnInsertCode = page.locator("button[data-name='code']");
        this.editorBtnInsertCodeBlock = page.locator("button[data-name='codeBlock']");
        this.editorBtnInsertComment = page.locator("button[data-name='comment']");
        this.editorBtnInsertImage = page.locator("button[data-name='image']");
        this.editorBtnInsertTable = page.locator("button[data-name='table']");

        this.editorBtnAddUnorderedList = page.locator("button[data-name='unordered-list']");
        this.editorBtnAddOrderedList = page.locator("button[data-name='ordered-list']");
        this.editorBtnAddCheckedList = page.locator("button[data-name='checked-list']");
        this.editorBtnHelp = page.locator("button[data-name='help']");


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

    public void create(String title, String description, String editorBtnName) {
        this.title.fill(title);
        this.description.fill(description);
        switch (editorBtnName) {
            case "Bold":
                this.editorBtnBold.click();
                break;
            case "Italic":
                this.editorBtnItalic.click();
                break;
            case "Strikethrough":
                this.editorBtnStrikethrough.click();
                break;
            case "Horizontal Line":
                this.editorBtnInsertHorizontalLine.click();
                break;
            case "Title":
                this.editorBtnInsertTitle.click();
                break;
            case "Link":
                this.editorBtnInsertLink.click();
                break;
            case "Quote":
                this.editorBtnInsertQuote.click();
                break;
            case "Code":
                this.editorBtnInsertCode.click();
                break;
            case "Code Block":
                this.editorBtnInsertCodeBlock.click();
                break;
            case "Comment":
                this.editorBtnInsertComment.click();
                break;
            case "Image":
                this.editorBtnInsertImage.click();
                break;
            case "Table":
                this.editorBtnInsertTable.click();
                break;
            case "Unordered List":
                this.editorBtnAddUnorderedList.click();
                break;
            case "Ordered List":
                this.editorBtnAddOrderedList.click();
                break;
            case "Checked List":
                this.editorBtnAddCheckedList.click();
                break;
            case "Help":
                this.editorBtnHelp.click();
                break;
            default:
                throw new IllegalArgumentException(
                        "Invalid editor button name: " + editorBtnName);
        }
    }
}
