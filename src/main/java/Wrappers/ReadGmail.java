package Wrappers;

import java.time.Duration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*; // ✅ Imports Store, Session, Folder, and Message
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Test.Tims.Locators_Class.Email_fields_Locators;

public class ReadGmail {
	public String getButtonURL(String buttonName) throws Exception

	{
		// final String username = "testconcepta3@gmail.com";
		// final String password = "lsxu ezep ztoq dlap"; // Use App Password for Gmail

		final String username = "sagar1.customer+101@gmail.com";
		final String password = "wjfk bzho tjns bkcb"; // Use App Password for Gmail

		// Email_fields_Locators email_fields_locators = new
		// Email_fields_Locators(driver);

		String buttonURL = null;

		// ✅ IMAP Properties
		Properties props = new Properties();
		props.put("mail.store.protocol", "imaps");
		props.put("mail.imaps.host", "imap.gmail.com");
		props.put("mail.imaps.port", "993");
		props.put("mail.imaps.ssl.enable", "true");
		props.put("mail.imaps.auth", "true");
		props.put("mail.imaps.timeout", "10000");
		props.put("mail.imaps.connectiontimeout", "5000");
		props.put("mail.imaps.ssl.trust", "imap.gmail.com");
		System.setProperty("java.net.preferIPv4Stack", "true");

		// ✅ Create session
		Session session = Session.getInstance(props, null);
		session.setDebug(true); // Enable debugging logs

		// ✅ Connect to IMAP Store
		Store store = session.getStore("imaps");
		store.connect(username, password);
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		// ✅ Get latest email
		Message[] messages = inbox.getMessages();
		int boxSize = messages.length;
		if (boxSize == 0) {
			System.out.println("No emails found!");
			return null;
		}

		Message latestMessage = messages[boxSize - 1]; // Get the last received email
		String emailContent = getEmailContent(latestMessage); // ✅ Extract HTML content

		if (emailContent == null) {
			System.out.println("No valid email content found!");
			return null;
		}

		// ✅ Extract URL using regex
		if (buttonName == "URL") {
			String patternString = "href=['\"](https:\\/\\/hcp-portal-purushottam.dev\\.myhealthchecked\\.com\\/my-account\\/[^'\"]+)['\"]";

			Pattern pattern = Pattern.compile(patternString);
			Matcher matcher = pattern.matcher(emailContent);

			if (matcher.find()) {
				buttonURL = matcher.group(1);
				System.out.println("Extracted URL: " + buttonURL);
			} else {
				System.out.println("No matching URL found in email.");
			}

		} else if (buttonName == "Confirmation Email") {
			String patternString = "Thank you for completing your appointment";
			Pattern pattern = Pattern.compile(patternString);
			Matcher matcher = pattern.matcher(emailContent);

			if (matcher.find()) {

				System.out.println("Extracted Text: " + patternString);
			} else {
				System.out.println("No matching Text found in email.");
			}
		}

		else if (buttonName.equals("ExtractID")) {
			// Example: extract ID that looks like "Your ID is: ABC123"
			String patternString = "\\s*([A-Za-z]{2}\\d{5})";
			Pattern pattern = Pattern.compile(patternString);
			Matcher matcher = pattern.matcher(emailContent);

			if (matcher.find()) {
				String extractedID = matcher.group(1); // Gets the actual ID value
				System.out.println("\n Extracted ID: " + extractedID + "\n");
				return extractedID; // return as result
			} else {
				System.out.println("No matching ID found in email.");
			}
		}

		if (buttonName == "URL_Redirect_Profile") {

			String patternString = "href=\"(https:\\/\\/click-staging\\.myhealthchecked\\.com\\/CL0\\/[^\\s\"]+)\"";

			Pattern pattern = Pattern.compile(patternString);
			Matcher matcher = pattern.matcher(emailContent);

			if (matcher.find()) {
				buttonURL = matcher.group(1);
				System.out.println("Extracted URL: " + buttonURL);
			} else {
				System.out.println("No matching URL found in email.");
			}

		}

		// ✅ Close connections
		inbox.close(false);
		store.close();

		return buttonURL;
	}

	// ✅ Method to Extract HTML content from Email
	private static String getEmailContent(Message message) throws Exception {
		if (message.isMimeType("text/plain")) {
			return (String) message.getContent();
		} else if (message.isMimeType("text/html")) {
			return (String) message.getContent();
		} else if (message.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) message.getContent();
			for (int i = 0; i < multipart.getCount(); i++) {
				BodyPart bodyPart = multipart.getBodyPart(i);
				if (bodyPart.isMimeType("text/html")) {
					return (String) bodyPart.getContent(); // ✅ Return HTML content
				}
			}
		}
		return null; // No valid content found
	}
}
