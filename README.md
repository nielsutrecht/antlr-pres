Antlr 4 Presentation Code
=========================

This repo contains a small simple grammar and some java code used to demonstrate Antlr 4.


Notes
-----
* Order of rules matter! A higher matching rule has precedence over lower matching rules.
* Lexing / parsing are two totally different stages. A lexer turns a character stream into a stream of tokens. The parser then builds an Abstract Syntax Tree from this token stream.
* Antlr 4 is not backward compatible! 


Interesting links
-----------------
* [Antlr 4 homepage](http://www.antlr.org/)
* [Antlr 4 example grammars](https://github.com/antlr/grammars-v4)
* [Antlr 4 editor plugin (Eclipse)](https://github.com/jknack/antlr4ide)

Maven integration
-----------------
Pom.xml:

    <build>
        <plugins>
            <plugin>
                <groupId>org.antlr</groupId>
                <artifactId>antlr4-maven-plugin</artifactId>
                <version>4.2.2</version>
                <configuration>
                    <listener>false</listener>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>antlr4</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <dependencies>
        <dependency>
            <groupId>org.antlr</groupId>
            <artifactId>antlr4-runtime</artifactId>
            <version>4.2.2</version>
        </dependency>
    <dependencies>

