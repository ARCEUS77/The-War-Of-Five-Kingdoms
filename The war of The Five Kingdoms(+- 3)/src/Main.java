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
	public static final String NOT_ENOUGH_KINGDOM_MSG = "Numero insuficiente de reinos criados";
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
		
		int xmap = in.nextInt();
		int ymap = in.nextInt();
		int nKingdoms = in.nextInt();
		int nCastles =  in.nextInt();
		
		in.nextLine();
		
		Game temp =  new Game(xmap,ymap,nKingdoms,nCastles);
		
		if(!validFirstLine(temp))
			System.out.println(FATAL_ERROR_MSG);
		else {
		
		System.out.println(nCastles + " castelos:");
		
		int counter = 0;
		
		while(counter < nCastles) {
			temp.createCastle(in.nextInt(),in.nextInt(),in.nextInt(), in.nextLine());
//			if(!validCastleCoord(in,temp.getCastle(counter),temp,counter));
			counter++;
			}
			
		
		
		System.out.println(nKingdoms + " reinos:");
		
		counter = 0;
		while(counter < nKingdoms) {
			temp.createKingdom(in.next(), in.nextLine());
			counter++;
		}
		G = temp;
		System.out.println(INITIAL_MSG + G.teamName(0) + ".");
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
	
	private static boolean validCastleCoord(Castle temp, Game G, int index) {
		boolean res = true;
		if(index > 0) {
			
			
				res = !(temp.getXCastle() < 1 || temp.getXCastle() > G.getXMap() ||
						temp.getYCastle() < 1 || temp.getYCastle() > G.getYMap());
			
			for(int i = index; i > 0 || res; i--)
			if(temp.getXCastle() == G.getCastle(i).getXCastle() ||
				temp.getYCastle() == G.getCastle(i).getYCastle()) {
					res = false;
					System.out.println(INVALID_POS_CASTLE_MSG);
			}
			
			else if(temp.getMoney() < 0) {
				res = false;
				System.out.println(INVALID_WEALTH_MSG);
			}
			
			else if(temp.getCastleName().equals(G.getCastle(index).getCastleName())) {
					res = false;
					System.out.println(DUPLICATE_CASTLE_NAME_MSG);
			}
		}
		
	
		return res;
			
	}
	
	private static boolean validKingdom(Kingdom temp, Game G, int index) {
		boolean res = true;
		if(index>0) {
			index--;
			for(int i = index; i>0; i--) {
			if(temp.getTeamName().equals(G.getKingdom(i).getTeamName()))
				res = false;
			}
//			if()
			
			
			}
		return res;
	}
	
}
