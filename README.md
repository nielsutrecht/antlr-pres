antlr-pres
==========

Antlr 4 Presentation Code

Interesting links:
* [Antlr 4 homepage](http://www.antlr.org/)
* [Antlr 4 example grammars](https://github.com/antlr/grammars-v4)

Integrating Antlr 4 in maven;
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

