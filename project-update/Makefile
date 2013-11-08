.PHONY: all clean

all: update.pdf

clean:
	rm update.pdf

%.pdf: %.mkd
	pandoc -Vgeometry:margin=1in -o $@ $<
