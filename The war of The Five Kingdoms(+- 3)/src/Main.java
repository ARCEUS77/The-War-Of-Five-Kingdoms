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
			System.out.print(G.kingdomName(0) + " " + PROMPT);
		
		
		String cmd = in.next().toLowerCase();
		
		
		System.out.println(cmd);
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
		
		int xmap = in.nextInt();
		int ymap = in.nextInt();
		int nKingdoms = in.nextInt();
		int nCastles =  in.nextInt();
		
		in.nextLine();
		
		if(!Game.validFirstLine(xmap,ymap,nKingdoms,nCastles).equals("")) {
			System.out.println(Game.validFirstLine(xmap,ymap,nKingdoms,nCastles));
			System.out.println(FATAL_ERROR_MSG);
		}
		else {
			
		G =  new Game(xmap,ymap,nKingdoms,nCastles);
		
		System.out.println(nCastles + " castelos:");
		
		int counter = 0;
		int castlesMade = 0;
		
		while(counter < nCastles) {
			
			int x = in.nextInt();
			int y = in.nextInt();
			int money =  in.nextInt();
			String name = in.nextLine().substring(1);
			
			if(G.validCastle(x,y,money,name,castlesMade).equals("")) {
				G.createCastle(x,y,money,name);
				castlesMade++;
				}
			else 
				System.out.println(G.validCastle(x,y,money,name,castlesMade));
			
			counter++;
			}
		
		if(castlesMade < nKingdoms) {
			G = null;
			System.out.println(Game.NOT_ENOUGH_CASTLES_MSG);
			System.out.println(FATAL_ERROR_MSG);
			
		}
		else {

			System.out.println(nKingdoms + " reinos:");
		
			counter = 0;
			
			int kingdomsMade = 0;
			
			while(counter < nKingdoms) {
				
				String kingdomName = in.next();
				String castleName = in.nextLine();
				castleName = castleName.substring(1);

				if(G.validKingdom(kingdomName,castleName,G,kingdomsMade).equals("")) {
					G.createKingdom(kingdomName);
					G.getKingdom(kingdomsMade).conquerCastle(G.getCastle(castleName));
					kingdomsMade++;
				}
				else
					System.out.println(G.validKingdom(kingdomName,castleName,G,kingdomsMade));
				
				counter++;
			}
			
			if(kingdomsMade < 2) {
				G = null;
				System.out.println(Game.NOT_ENOUGH_KINGDOMS_MSG);
				System.out.println(FATAL_ERROR_MSG);
			}
			else {	
				
				System.out.println(INITIAL_MSG + G.kingdomName(0) + ".");
				}
			}
		}
		
		return G;
	}
	
}
