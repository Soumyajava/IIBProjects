package com.iib.gov;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Vchvs03ApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testPasswordEncryption() {
//	    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//	    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//	    config.setPassword("sanu"); // encryptor's private key
//	    config.setAlgorithm("PBEWithMD5AndDES");
//	    config.setKeyObtentionIterations("1000");
//	    config.setPoolSize("1");
//	    config.setProviderName("SunJCE");
//	    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//	    config.setStringOutputType("base64");
//	    encryptor.setConfig(config);
//	    String username = "shravani";
//	    String encryptedusername = encryptor.encrypt(username);
//	    System.out.println("encryptedUsername : " + encryptedusername);
//	    
//	    String pwd = "I!B@$hr@v@987";
//	    String encryptedPassword = encryptor.encrypt(pwd);
//	    System.out.println("encryptedPassword : " + encryptedPassword);
//	}
	
}
