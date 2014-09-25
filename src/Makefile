JAVAC     = javac
JAVAVM    = java

JFLAGS    = -g -classpath $(CLASSPATH_2.9.1) -d ../lib/opencraft
CLASSPATH_2.8.4 = \
	../lib/opencraft: \
	../lib/lwjgl/jinput.jar: \
	../lib/lwjgl/lwjgl.jar: \
	../lib/lwjgl/lwjgl_util.jar: \
	../lib/lwjgl/slick-util.jar

CLASSPATH_2.9.1 = ../lib/opencraft:../lib/lwjgl/AppleJavaExtensions.jar:../lib/lwjgl/asm-debug-all.jar:../lib/lwjgl/jinput.jar:../lib/lwjgl/lwjgl-debug.jar:../lib/lwjgl/lwjgl.jar:../lib/lwjgl/lwjgl_test.jar:../lib/lwjgl/lwjgl_util.jar:../lib/lwjgl/lwjgl_util_applet.jar:../lib/lwjgl/lzma.jar

.SUFFIXES: .java .class
.java.class:
	$(JAVAC) $(JFLAGS) $*.java

CLASSES = \
	util/Axis.java \
	util/Grid.java \
	util/FPS.java \
	util/Cube.java \
	util/TerrainGrid.java \
	util/Vertex.java \
	camera/FirstPerson.java \
	camera/SecondPerson.java \
	camera/ThirdPerson.java \
	Main.java

default: $(CLASSES:.java=.class)

test:
	@echo "Executing Unit Tests"

clean:
	$(RM) -r ../lib/opencraft/*

