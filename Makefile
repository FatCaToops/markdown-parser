MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

MarkdownParseTest3.class: MarkdownParse.class MarkdownParseTest.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest3.java