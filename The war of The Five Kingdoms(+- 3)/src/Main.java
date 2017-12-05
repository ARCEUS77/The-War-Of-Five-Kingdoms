import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		startProgram();
		System.out.println(END_MSG);

	}

	public static final String PROMPT = "> ";
	public static final String NEW_GAME_CMD = "novo";
	public static final String SOLDIER_MOVE_CMD = "soldado";
	public static final String RECRUIT_CMD = "recruta";
	public static final String MAP_CMD = "mapa";
	public static final String CASTLES_CMD = "castelos";
	public static final String ARMY_CMD = "exercito";
	public static final String KINGDOM_CMD = "reinos";
	public static final String HELP_CMD = "ajuda";
	public static final String LEAVE_CMD = "sai";
	public static final String INACTIVE_MSG = "Comando inactivo.";
	public static final String UNKNOWN_CMD = "Opcao inexistente."; 
	public static final String MAP_TOO_SMALL_MSG = "Mapa pequeno demais para o jogo.";
	public static final String INVALID_N_KINGDOMS_MSG = "Numero de reinos invalido.";
	public static final String INVALID_N_CASTLES_MSG = "Numero de castelos invalido.";
	public static final String INVALID_POS_CASTLE_MSG = "Castelo em posicao invalida.";
	public static final String INVALID_WEALTH_MSG = "Castelo com riqueza invalida.";
	public static final String DUPLICATE_CASTLE_NAME_MSG = "Os castelos nao podem ter nomes duplicados.";
	public static final String NOT_ENOUGH_CASTLES_MSG = "Numero insuficiente de castelos criados.";
	public static final String DUPLICATE_KINGDOM_NAME_MSG = "Os reinos nao podem ter nomes duplicados";
	public static final String OCCUPIED_CASTLE_MSG = "Castelo ja ocupado.";
	public static final String CASTLE_NON_EXISTANT_MSG = "Castelo nao existe.";
	public static final String NOT_ENOUGH_KINGDOMS_MSG = "Numero insuficiente de reinos criados";
	public static final String INITIAL_MSG = "Jogo iniciado, comeca o reino ";
	public static final String FATAL_ERROR_MSG = "Erro fatal, jogo nao inicializado.";
	public static final String NOT_OWNED_CASTLE_MSG = "(sem dono)";
	public static final String NO_CASTLES_MSG = "Sem castelos.";
	public static final String NO_ARMY_MSG = "Sem exercito.";
	public static final String UNKNOWN_SOLDIER_TYPE_MSG = "Tipo de soldado inexistente.";
	public static final String ILLEGAL_CASTLE_INVASION_MSG = "Castelo invadido ilegalmente.";
	public static final String NO_MONEY_MSG = "Riqueza insuficiente para recrutamento.";
	public static final String CASTLE_OCCUPIED_BY_SOLDIER_MSG = "Castelo nao livre.";
	public static final String END_MSG = "Obrigado por jogar. Ate a proxima.";
	
	
	private static void  startProgram() {
		Scanner input = new Scanner(System.in);
		Game G = null;
		String cmd = "";
		System.out.println(Help(G));
		while(!cmd.equals(LEAVE_CMD)) {
			if(G == null) {
				cmd = readCommand(input,G); 
				G = executeCommand(input,cmd,G);
			}
			else {
				cmd = readCommand(input,G); 
				G = executeCommandGame(input,cmd,G);
			}
		}
		
		
	}
	
	private static String readCommand(Scanner in, Game G) {
		if(G == null)
			System.out.print(PROMPT);
		else
			System.out.print(G.teamName(0) + " " + PROMPT);
		
		String cmd = in.next().toLowerCase();
		
		return cmd;
	}
	
	private static Game executeCommand(Scanner in, String cmd, Game G) { 
			
		switch (cmd) {
		
		case NEW_GAME_CMD:G = processNewGame(in,G);break;
		
		case SOLDIER_MOVE_CMD:;
		
		case RECRUIT_CMD:;
		
		case MAP_CMD:;
		
		case CASTLES_CMD:;
		
		case ARMY_CMD:;
		
		case KINGDOM_CMD:System.out.println(INACTIVE_MSG);break;
		
		case HELP_CMD:System.out.println(Help(G));break;
			
		case LEAVE_CMD:break;
		
		default:
			System.out.println(UNKNOWN_CMD);
		}
		
		return G;
	}
	
	private static Game executeCommandGame(Scanner in,String cmd,Game G) {
		
		switch(cmd) {
		
		case NEW_GAME_CMD:G = processNewGame(in,G);break;
		
		case SOLDIER_MOVE_CMD:break;
		
		case RECRUIT_CMD:break;
		
		case MAP_CMD:break;
		
		case CASTLES_CMD:break;
		
		case ARMY_CMD:break;
		
		case KINGDOM_CMD:break;
		
		case HELP_CMD:System.out.println(Help(G));break;
			
		case LEAVE_CMD:break;
		
		default:
			System.out.println(UNKNOWN_CMD);
		}
		return G;
	}
	
	private static String Help(Game G) {
		String helpmsg;
		if(G == null)
			helpmsg = NEW_GAME_CMD + " - Novo jogo" + "\n" + 
					  HELP_CMD + " - Mostra a ajuda" + "\n" + 
					  LEAVE_CMD + " - Termina a execucao do programa";
		else
			helpmsg = NEW_GAME_CMD + " - Novo jogo" + "\n" + 
					  SOLDIER_MOVE_CMD + " - Move o soldado" + "\n" + 
					  RECRUIT_CMD + " - Recruta um soldado num castelo" + "\n" + 
					  MAP_CMD + " - Lista todos os castelos do mapa, incluindo os abandonados, pela ordem de criacao no jogo e todos os reinos ainda em jogo, pela ordem de jogada" + "\n" +
					  CASTLES_CMD + " - Lista os castelos do jogador activo, pela ordem pela qual foram conquistados" + "\n" + 
					  ARMY_CMD + " - Lista os soldados vivos do jogador activo, pela ordem de recrutamento" + "\n" + 
					  KINGDOM_CMD + " - Lista os varios reinos ainda em jogo, ordenados por nome do reino" + "\n" + 
					  HELP_CMD + " - Mostra a ajuda" + "\n" + 
					  LEAVE_CMD + " - Termina a execucao do programa";
		
		return helpmsg;
	}
	
	private static Game processNewGame(Scanner in, Game G) {
		if(G != null)
			G = null;
		
		Game temp = null;
		
		int xmap = in.nextInt();
		int ymap = in.nextInt();
		int nKingdoms = in.nextInt();
		int nCastles =  in.nextInt();
		
		in.nextLine();
		
		temp =  new Game(xmap,ymap,nKingdoms,nCastles);
		
		if(!validFirstLine(temp))
			System.out.println(FATAL_ERROR_MSG);
		else {
		
		System.out.println(nCastles + " castelos:");
		
		int counter = 0;
		int castlesMade = 0;
		
		while(counter < nCastles) {
			
			int x = in.nextInt();
			int y = in.nextInt();
			int money =  in.nextInt();
			String name = in.nextLine();
			
			if(validCastle(x,y,money,name,temp,castlesMade)) {
				temp.createCastle(x,y,money,name);
				castlesMade++;
				}
			counter++;
			}
		
		if(castlesMade < nKingdoms) {
			System.out.println(NOT_ENOUGH_CASTLES_MSG);
			System.out.println(FATAL_ERROR_MSG);
		}
		else {

			System.out.println(nKingdoms + " reinos:");
		
			counter = 0;
			
			int kingdomsMade = 0;
			
			while(counter < nKingdoms) {
				String teamName = in.next();
				String castleName = in.nextLine();
				
				if(validKingdom(teamName,castleName,temp,kingdomsMade)) {
				temp.createKingdom(teamName,castleName);
				temp.getKingdom(nKingdoms).conquerCastle(castleName);
				kingdomsMade++;
				}
				counter++;
			}
			
			if(kingdomsMade < 2) {
				System.out.println(Main.NOT_ENOUGH_KINGDOMS_MSG);
				System.out.println(FATAL_ERROR_MSG);
			}
			else {	
				G = temp;
				System.out.println(INITIAL_MSG + G.teamName(0) + ".");
				}
			}
		}
		
		return G;
	}
	
	private static boolean validFirstLine(Game temp) {
		boolean res = true;
		int maxCastles = temp.getXMap()*temp.getYMap();
		
		if(temp.getXMap() < Game.MINIMUM_MAP_X_Y || temp.getYMap() < Game.MINIMUM_MAP_X_Y) {
			res = false;
			System.out.println(MAP_TOO_SMALL_MSG);
		}
		
		else if(temp.getNKingdoms() < Game.MINIMUM_KINGDOMS || temp.getNKingdoms() > Game.MAXIMUM_KINGDOMS) {
				res = false;
				System.out.println(INVALID_N_KINGDOMS_MSG);
		}
			else if(temp.getNCastles() > maxCastles || temp.getNCastles() < temp.getNKingdoms()) {
					res = false;
					System.out.println(INVALID_N_CASTLES_MSG);
			}
		
		return res;
		
	}
	
	private static boolean validCastle(int x, int y, int money, String name,Game G, int index) {
		boolean res = true;
			
				if(x < 1 || x > G.getXMap() ||
						y < 1 || y > G.getYMap()) { 
					res = false;
					System.out.println(INVALID_POS_CASTLE_MSG);
				}
				
				if(index > 0) {
					
					for(int i = index-1; i >= 0 && res; i--) 
						if(x == G.getCastle(i).getXCastle() &&
							y == G.getCastle(i).getYCastle() && res) {
							res = false;
							System.out.println(INVALID_POS_CASTLE_MSG);
						}
				}
				
						if(money < 0 && res) {
							res = false;
							System.out.println(INVALID_WEALTH_MSG);
				 	}
						
						for(int i = index-1; i >= 0 && res; i--) 
							if(name.equals(G.getCastle(index-1).getCastleName()) && res) {
								res = false;
								System.out.println(DUPLICATE_CASTLE_NAME_MSG);
						}
					
		
		
		return res;
					
			
	}
	
	private static boolean validKingdom(String kingdomName, String castleName, Game G, int index) {
		boolean res = true;
		
		if(index > 0) {
			
			for(int i = index-1; i >= 0 && res; i--) {
				if(kingdomName.equals(G.getKingdom(i).getTeamName()))
					res = false;
			}
			
				for(int i = index-1; i >= 0 && res; i--)
					if(castleName.equals(G.getKingdom(i).getConqueredCastleName(0))) {
						res = false;
						System.out.println(OCCUPIED_CASTLE_MSG);
					}
			}
		
		return res;
	}
	
}
