package it.polito.tdp.sudoku.model;

public class SudokuModel {
	
	public static void main(String[] args) {
		SudokuGenerator  s = new SudokuGenerator();
		int[][] griglia = s.nextBoard(45);
		SudokuModel sm = new SudokuModel();
		System.out.println("stampo griglia" + sm.funzioneRicorsiva(0, griglia));

	}
	
	
	
	
	public int[][] funzioneRicorsiva( int passo,int[][] griglia ){
		int esistenteRegione = 0;
		int esistenteRiga = 0;
		int esistenteColonna = 0;
		int riga = passo / 9;
		int colonna = passo % 9;
		if(griglia[passo / 9][passo % 9] == 0){ 
			
			for(int i = 1; i < 10; i ++){
				if(passo == 81 )
					return griglia;
				for(int c = 0; c < 9; c ++){
					if(griglia[riga][c] == i)
						esistenteRiga ++;
				}
				for(int r = 0; r < 9; r ++){
					if(griglia[r][colonna] == i)
						esistenteColonna ++;
				}
				// controllo se il numero esiste nella  regione
				int cornerX = 0;
				int cornerY = 0;
				if (riga > 2)
					if (colonna > 5)
						cornerX = 6;
					else
						cornerX = 3;
				if (colonna > 2)
					if (colonna > 5)
						cornerY = 6;
					else
						cornerY = 3;
				for (int k = cornerX; k < 10 && k < cornerX + 3; i++)
					for (int j = cornerY; j < 10 && j < cornerY + 3; j++)
						if (i == griglia[i][j])
							esistenteRegione ++;
				
				if(esistenteRiga == 0 && esistenteColonna == 0 && esistenteRegione == 0){
					griglia[passo / 9][passo % 9] = i;
				
				funzioneRicorsiva( passo + 1, griglia);
				griglia[passo / 9][passo % 9] = 0;
				}
			}	
		}
		return griglia;
	

	}
}