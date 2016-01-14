DOT=dot -Tpdf 
SHOW=evince

AST:
	$(DOT) AST.dot -o AST.pdf
	$(SHOW) AST.pdf &
	$(DOT) IR.dot -o IR.pdf
	$(SHOW) IR.pdf &
	$(DOT) Env.dot -o Env.pdf
	$(SHOW) Env.pdf &

clean:
	rm *.dot
	rm 3_adress_code.txt	
	rm *.pdf
	rm *.*~	

	
