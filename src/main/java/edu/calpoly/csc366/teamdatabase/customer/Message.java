package edu.calpoly.csc366.teamdatabase.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount sender;
    
    @NotNull
    @Size(min=1, max=100)
    private String title;

    @NotNull
    @Size(min=1, max=500)
    private String contents;

    

    public Message(int messageId, CustomerAccount sender, String title, String contents) {
        this.messageId = messageId;
        this.sender = sender;
        this.title = title;
        this.contents = contents;
    }

    public Message() {

    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public CustomerAccount getSender() {
        return sender;
    }

    public void setSender(CustomerAccount sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}