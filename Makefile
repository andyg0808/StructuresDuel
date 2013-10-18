.PHONY: all

all: proposal.pdf

%.pdf: %.mkd
	pandoc -o $@ $<
