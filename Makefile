
JAVAC = javac 
CLASS = *.java

JAVA = java -cp . 
MAIN = Sistema


compilar:
	$(JAVAC) $(CLASS)

run:
	$(JAVA) $(MAIN)

.PHONY:clear

clear:
	rm *.class  
