# Directories
SRC := src
OUT := out

# Find all java source files
SRC_FILES := $(wildcard $(SRC)/*.java)
# Convert source files to corresponding class files in OUT
CLASS_FILES := $(patsubst $(SRC)/%.java,$(OUT)/%.class,$(SRC_FILES))

# Default target
all: run

# Compile only if source changed
$(OUT)/%.class: $(SRC)/%.java
	@mkdir -p $(OUT)
	javac -d $(OUT) $<

# Compile all class files
compile: $(CLASS_FILES)

# Run the program
run: compile
	java -cp $(OUT) Main $(ARGS)

# Clean build
clean:
	rm -rf $(OUT)/*.class
