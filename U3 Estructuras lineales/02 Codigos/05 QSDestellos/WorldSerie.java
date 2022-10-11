public class WorldSerie
{
	private int año;
	private String winner;
	private String loser;
	
	public WorldSerie(int a, String w, String l) {
		año    = a;
		winner = w;
		loser  = l;
	}
	
	public String getWinner() { return winner; }
	
	public String getLoser() { return loser; }
	
	public String toString() {
		return String.format("%4d %-40s %-40s",año,winner,loser);
	}
}
