package com.googlecrud;

import org.junit.Test;

public class TokenizerTest {

		@Test
		public void testSplit()
		{
			String token = "tiny:agxnZXRzb21lbHVuY2hyCgsSBFRpbnkYLQw";
			String[] tokens = token.split(":");
			
			for(String s: tokens)
			{
				System.out.println("token:"+s);
			}
		}
}
