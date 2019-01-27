package com.artos.tests.utils_email;

import java.io.File;

import com.artos.annotation.TestCase;
import com.artos.annotation.Unit;
import com.artos.framework.FWStaticStore;
import com.artos.framework.email.EmailClient;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestCase(skip = false, sequence = 0)
public class Test_Email_Attachment implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		String to = FWStaticStore.frameworkConfig.getEmailReceiversEmail();
		String from = FWStaticStore.frameworkConfig.getEmailSendersEmail();
		File emailAuthSettingsFilePath = new File(FWStaticStore.frameworkConfig.getEmailAuthSettingsFilePath());
		String authID = "JohnMurray";
		String host = FWStaticStore.frameworkConfig.getEmailSMTPServer();
		String port = FWStaticStore.frameworkConfig.getEmailSMTPSSLPort();
		String enable_auth = FWStaticStore.frameworkConfig.getEmailSMTPAuthRequired();
		String enable_ttl = "true";
		String emailSubject = "Artos test report";
		String emailBody = "Test Email from Artos";
		EmailClient emailClient = new EmailClient(to, from, emailAuthSettingsFilePath, authID, host, port, enable_auth, enable_ttl, emailSubject,
				emailBody);
		emailClient.sendEmailWithAnAttachment();
		// --------------------------------------------------------------------------------------------

	}
}
