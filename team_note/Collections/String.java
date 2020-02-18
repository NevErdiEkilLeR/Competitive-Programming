class StringTest {
	public StringTest(){
		String text = "My name is Junyoung";

		System.out.println(text.equals("My name is Junyoung"));
		System.out.println(text.indexOf("me"));  // O(n), else -1

		// replace
		text = text.replaceAll("Junyoung", "Charley");

		// substring
		text = text.substring(11) + ", " + text.substring(0, 11);
		System.out.println(text);
		// split
		String[] tokens = text.split(" ");
		for(String token : tokens){
			System.out.println(token);
		}

		// concat
		String sum = tokens[0]
				.concat(tokens[1])
				.concat(tokens[2]); // +
		sum += tokens[3];           // by StringBuilder
		System.out.println(sum);

		// StringBuilder
		StringBuilder builder = new StringBuilder();
		for(String token : tokens){
			builder.append(token);
		}
		System.out.println(builder.toString());

		// compareTo
		System.out.println("bbb".compareTo("bbb"));     // 0, equals
		System.out.println("bbb".compareTo("b"));       // 2, length
		System.out.println("bbb".compareTo("bbbbbb"));  // -3, length
		System.out.println("bbb".compareTo("bbbccc"));  // -3, length
		System.out.println("bbb".compareTo("cccccc"));  // -1, dictionary order
		System.out.println("bbb".compareTo("ccc"));     // -1, dictionary order
		System.out.println("bbb".compareTo("aaa"));     // 1, dictionary order
	}
}