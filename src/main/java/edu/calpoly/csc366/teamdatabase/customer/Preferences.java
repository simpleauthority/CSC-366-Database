package edu.calpoly.csc366.teamdatabase.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int preferenceId;

    // Privacy Preferences
    private boolean personalizedAds;
    private boolean recieveEmails;
    private boolean trackActivityAcrossApps;
    private boolean sendLocationInformation;

    // Security Preferences
    private boolean twoFA;
    private boolean faceID;

    // Notification Preferences
    private boolean inboxMessages;
    private boolean tippingReceiptsOrders;

    public Preferences(int preferenceId, boolean personalizedAds, boolean recieveEmails, boolean trackActivityAcrossApps, boolean sendLocationInformation, boolean twoFA, boolean faceID, boolean inboxMessages, boolean tippingReceiptsOrders) {
        this.preferenceId = preferenceId;
        this.personalizedAds = personalizedAds;
        this.recieveEmails = recieveEmails;
        this.trackActivityAcrossApps = trackActivityAcrossApps;
        this.sendLocationInformation = sendLocationInformation;
        this.twoFA = twoFA;
        this.faceID = faceID;
        this.inboxMessages = inboxMessages;
        this.tippingReceiptsOrders = tippingReceiptsOrders;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public boolean isPersonalizedAds() {
        return personalizedAds;
    }

    public void setPersonalizedAds(boolean personalizedAds) {
        this.personalizedAds = personalizedAds;
    }

    public boolean isRecieveEmails() {
        return recieveEmails;
    }

    public void setRecieveEmails(boolean recieveEmails) {
        this.recieveEmails = recieveEmails;
    }

    public boolean isTrackActivityAcrossApps() {
        return trackActivityAcrossApps;
    }

    public void setTrackActivityAcrossApps(boolean trackActivityAcrossApps) {
        this.trackActivityAcrossApps = trackActivityAcrossApps;
    }

    public boolean isSendLocationInformation() {
        return sendLocationInformation;
    }

    public void setSendLocationInformation(boolean sendLocationInformation) {
        this.sendLocationInformation = sendLocationInformation;
    }

    public boolean isTwoFA() {
        return twoFA;
    }

    public void setTwoFA(boolean twoFA) {
        this.twoFA = twoFA;
    }

    public boolean isFaceID() {
        return faceID;
    }

    public void setFaceID(boolean faceID) {
        this.faceID = faceID;
    }

    public boolean isInboxMessages() {
        return inboxMessages;
    }

    public void setInboxMessages(boolean inboxMessages) {
        this.inboxMessages = inboxMessages;
    }

    public boolean isTippingReceiptsOrders() {
        return tippingReceiptsOrders;
    }

    public void setTippingReceiptsOrders(boolean tippingReceiptsOrders) {
        this.tippingReceiptsOrders = tippingReceiptsOrders;
    }
}
