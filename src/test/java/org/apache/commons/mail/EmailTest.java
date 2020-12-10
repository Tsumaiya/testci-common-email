package org.apache.commons.mail;
import org.junit.Before;
import org.junit.Test;

//import java.sql.SQLException;
import java.util.Date;

//import javax.mail.Address;
import javax.mail.internet.MimeMessage;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;


public class EmailTest {
	public static final String[] TEST_EMAILS = {"ab@bc.com", "a.b@c.org", "abgfrtbv@srvvb.com.bd" };
	public static final String TEST_EM = "ab@bc.com";
	public static final String TEST_EM1 = null;
	public static final String TEST_VNAME = "Sumaiya";
	public static final String TEST_VNAME1 = null;

	
	
	
	/* Concrete Email Class for testing */
	private EmailConcrete email;
	//private EmailConcrete em;
	@Before
	public void setUpEmailTest() throws Exception{
		
		email = new EmailConcrete();
		
	}
	
	@After
	public void tearDownEmailTest() throws Exception{
		
	}
	
	/* 
	 * Test addBcc(String email) function
	 */
	@Test
	public void testAddBcc() throws Exception {
		
		email.addBcc(TEST_EMAILS);
		assertEquals(3, email.getBccAddresses().size());
	}
	
	/* 
	 * Test addCc(String email) function
	 */
	@Test
	public void testAddCc() throws Exception {
		
		email.addCc(TEST_EMAILS);
		assertEquals(3, email.getCcAddresses().size());
	}
	
	/*
	 * Test addReplyTo(String email, String name(value)) function
	 */
	@Test
	public void testaddReplyTo() throws Exception {
		
		email.addReplyTo(TEST_EM, TEST_VNAME );
		assertEquals(1, email.getReplyToAddresses().size());
	}
	
	/*
	 * addHeader(String name, String value)
	 */

	 @Test
	 public void testaddHeader() throws Exception{
			
		 	email.addHeader(TEST_EM, TEST_VNAME );
		 	//email.addHeader(TEST_EM1, TEST_VNAME);
		
	 }
	 @Test(expected=IllegalArgumentException.class)
	 public void testaddHeaderEmpty() throws Exception{
			
		 	//email.addHeader(TEST_EM, TEST_VNAME );
		 	email.addHeader(TEST_EM1, TEST_VNAME);
		
	 }
	 /*
		 * setFrom(String email)
		 */
	 @Test
	 public void testSetFrom() throws Exception {
			email.setFrom(TEST_EM);		 
		}
	 /*
		 * String  getHostName()
		 */
		@Test
		public void testGetHostName() {
			email.getHostName();	
			email.setHostName("Sumaiya");
			email.getHostName();		
		}
		/*
		 * getSentDate()
		 */
		@Test
		public void testGetSentDateNull(){
			Date test = email.getSentDate();
			assertTrue(test instanceof Date);
			
		}
		
		@Test
		public void testGetSentDate() {
			Date test = new Date();
			email.setSentDate(test);
			Date actdate = email.getSentDate();
			assertEquals(test, actdate);
			
		}
	 
		/*
		 * buildMimeMessage()
		 */
		@Test
		public  void testbuildMimeMessage()throws Exception
		{
			email.setHostName("localhost");
			email.setSmtpPort(8080);
			email.setFrom("a@b.com");
			email.addTo("c@d.com");
			email.setSubject("test mail");
			//email.setText("test");
			//email.getContentType();

			final String headerValue = "1234567890 1234567890 123456789 01234567890 123456789 0123456789 01234567890 01234567890";
			email.addHeader("X-LongHeader", headerValue);

			email.buildMimeMessage();

			MimeMessage msg = email.getMimeMessage();
			msg.saveChanges();

			 //String from= msg.getFromAddress();

			//assertEquals(from,"a@b.com");
			//assertEquals(from,"a@b.com");
			
		}
		/*
		 *  getMailSession()
		 */
		@Test
		public  void testgetMailSession() throws Exception{
			 email.setHostName("localhost");
			 email.getMailSession();		
		}
		
		/*
		 *  getSocketConnectionTimeout()
		 */
		@Test
		public void testgetSocketConnectionTimeout() throws Exception{
			email.setSocketConnectionTimeout(4);
			email.getSocketConnectionTimeout();
			
		}
}
