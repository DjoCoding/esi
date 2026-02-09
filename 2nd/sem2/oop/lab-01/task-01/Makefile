SRC := src
SRC_FILES := $(wildcard $(SRC)/*.java)
OUT := out

main: $(SRC_FILES)
	rm -rf $(OUT)
	mkdir -p $(OUT)
	javac -d $(OUT) $(SRC_FILES)
	java -cp $(OUT) Main $(ARGS)
