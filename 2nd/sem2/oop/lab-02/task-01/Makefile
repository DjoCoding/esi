SRC := src
SRC_FILES := $(wildcard $(SRC)/*.java)
OUT := out

compile: $(SRC_FILES)
	rm -rf $(OUT)
	mkdir -p $(OUT)
	javac -d $(OUT) $(SRC_FILES)

run: compile
	java -cp $(OUT) Main $(ARGS)
