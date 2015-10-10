package com.mtjwy.spring.soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mtjwy.spring.config.CDPlayerConfig;


@RunWith(SpringJUnit4ClassRunner.class)//use SpringJUnit4ClassRunner to have a Spring application context automatically created when the test starts.
@ContextConfiguration(classes=CDPlayerConfig.class) //tells spring to load its configuration from the CDPlayerConfig class.
public class CDPlayerTest {
	
	/*
	 * Testing code that uses System.out.println()is a tricky business.
	 * Therefore, here we use StandardOutputStreamLog, a JUnit rule from
	 * the System Rules library
	 * (http://stefanbirkner.github.io/system-rules/index.html) that lets us
	 * make assertions against whatever is written to the console.
	 */
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
			
	@Autowired //to inject the CompactDisc bean into the test
	private CompactDisc cd;
	
	@Autowired
	private MediaPlayer player;
	
	@Before
	public void setUp() {
		SgtPeppers sgtPeppersCD = (SgtPeppers) cd;
		sgtPeppersCD.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
		sgtPeppersCD.setArtist("The Beatles");
		
	}
	/*
	 * To test that component scanning works.
	 * 
	 * Because that configuration class includes @ComponentScan, the resulting
	 * application context should include the CompactDisc bean.
	 */
	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
	}
	
	
	@Test
	  public void play() {
	    player.play();
		/*
		 * Here it¡¯s asserting that the message from the SgtPeppers.play() method
		 * was sent to the console.
		 */
	    assertEquals(
	        "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n", //StandardOutputStreamLog window \r\n  //linux \n
	        log.getLog());
		/*
		 * If you verify logs that contain line separators than the separators
		 * are different (e.g. Linux: \n , Windows: \r\n ).
		 */
	  }

}
