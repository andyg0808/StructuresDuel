.PHONY: all

all: update_notes.pdf

%.pdf: %.md
	pandoc -o $@ $<
