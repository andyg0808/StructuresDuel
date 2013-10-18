.PHONY: all clean

all: proposal.pdf

clean:
	rm proposal.pdf

%.pdf: %.mkd
	pandoc -o $@ $<
