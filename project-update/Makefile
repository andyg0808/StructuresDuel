.PHONY: all clean

all: update.pdf

clean:
	rm update.pdf

%.pdf: %.mkd header.tex template.tex
	pandoc -H header.tex --template template.tex -Vgeometry:margin=1in -o $@ $<
