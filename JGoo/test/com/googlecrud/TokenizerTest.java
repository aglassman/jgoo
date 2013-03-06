package com.googlecrud;

import org.junit.Test;

public class TokenizerTest {

		@Test
		public void testSplit()
		{
			String token = "com.jgoo.shared.model.Tiny:agxnZXRzb21lbHVuY2hyCgsSBFRpbnkYLQw";
			String[] tokens = token.split(":");
			
			for(String s: tokens)
			{
				System.out.println("token:"+s);
			}
		}
}
