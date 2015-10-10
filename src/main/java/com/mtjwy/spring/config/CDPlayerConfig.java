package com.mtjwy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mtjwy.spring.soundsystem.CDPlayer;
import com.mtjwy.spring.soundsystem.CompactDisc;
import com.mtjwy.spring.soundsystem.SgtPeppers;

@Configuration
public class CDPlayerConfig {
	/*
	 * The @Beanannotation tells Spring that this method will return an object
	 * that should be registered as a bean in the Spring application context.
	 */
	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}

	/*
	 * Here, the cdPlayer()method asks for a CompactDiscas a parameter. When
	 * Spring calls cdPlayer()to create the CDPlayerbean, it autowires a
	 * CompactDiscinto the configuration method. Then the body of the method can
	 * use it however it sees fit. With this technique, the cdPlayer()method can
	 * still inject the CompactDiscinto the CDPlayer¡¯s constructor without
	 * explicitly referring to the CompactDisc¡¯s @Bean method.
	 * 
	 * This approach to referring to other beans is usually the best choice
	 * because it doesn¡¯t depend on the CompactDiscbean being declared in the
	 * same configuration class.
	 */
	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {
		return new CDPlayer(compactDisc);
	}
}
