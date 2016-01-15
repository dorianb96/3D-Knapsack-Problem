package graphics;
public class GreedyAlgorithmPento {
	
	
	private final static boolean[][][] BOX = {{{true},{true},{true}},
										  {{false},{true},{false}},
										  {{false},{true},{false}}};
	private final static int SCORE = 5;
	private final static int EMPTY_NUM = 0;
	
	private double[][][] truck;
	private int score = 0;
	private boolean done = false;
	private boolean placed = false;
	private boolean canPlace = true;
	
	public int getGreedy(double[][][] truck) {
		this.truck = truck;
		fillEmpty();
		while (!done) {
			for (int x = 0; x < this.truck.length - BOX.length + 1; x++) {
				for (int y = 0; y < this.truck[0].length - BOX[0].length + 1; y++) {
					for (int z = 0; z < this.truck[0][0].length - BOX[0][0].length + 1; z++) {
						placed = false;
						canPlace = true;
						for (int i = 0; i < BOX.length; i++) {
							for (int j = 0; j < BOX[0].length; j++) {
								for (int k = 0; k < BOX[0][0].length; k++) {
									if(!placed && canPlace && this.truck[x+i][y+j][z+k] != EMPTY_NUM && BOX[i][j][k] == true) {
										canPlace = false;
									}
								}	
							}
						}
						if (canPlace) {
							placed = true;
							score += SCORE;
							for (int i = 0; i < BOX.length; i++) {
								for (int j = 0; j < BOX[0].length; j++) {
									for (int k = 0; k < BOX[0][0].length; k++) {
										if (BOX[i][j][k]) this.truck[x+i][y+j][z+k] = SCORE;
									}	
								}
							}
						} else {
							done = true;
						}
					}
				}
			}
		}
		return score;
	}
	
	public void fillEmpty() {
		for (int x = 0; x <this.truck.length; x++) {
			for (int y = 0; y < this.truck[0].length; y++) {
				for (int z = 0; z < this.truck[0][0].length; z++) {
					this.truck[x][y][z] = EMPTY_NUM;					
				}
			}
		}
	}
}

