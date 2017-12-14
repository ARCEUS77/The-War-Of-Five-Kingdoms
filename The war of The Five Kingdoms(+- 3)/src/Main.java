import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		startProgram();
		System.out.println(END_MSG);

	}

	private static final String PROMPT = "> ";
	private static final String NEW_GAME_CMD = "novo";
	private static final String SOLDIER_MOVE_CMD = "soldado";
	private static final String RECRUIT_CMD = "recruta";
	private static final String MAP_CMD = "mapa";
	private static final String CASTLES_CMD = "castelos";
	private static final String ARMY_CMD = "exercito";
	private static final String KINGDOM_CMD = "reinos";
	private static final String HELP_CMD = "ajuda";
	private static final String LEAVE_CMD = "sai";
	private static final String INACTIVE_MSG = "Comando inactivo.";
	private static final String UNKNOWN_CMD = "Opcao inexistente.";
	private static final String INITIAL_MSG = "Jogo iniciado, comeca o reino ";
	private static final String FATAL_ERROR_MSG = "Erro fatal, jogo nao inicializado.";
	private static final String MAP_TOO_SMALL_MSG = "Mapa pequeno demais para o jogo.";
	private static final String INVALID_N_KINGDOMS_MSG = "Numero de reinos invalido.";
	private static final String INVALID_N_CASTLES_MSG = "Numero de castelos invalido.";
	private static final String INVALID_POS_CASTLE_MSG = "Castelo em posicao invalida.";
	private static final String INVALID_WEALTH_MSG = "Castelo com riqueza invalida.";
	private static final String DUPLICATE_CASTLE_NAME_MSG = "Os castelos nao podem ter nomes duplicados.";
	private static final String NOT_ENOUGH_CASTLES_MSG = "Numero insuficiente de castelos criados.";
	private static final String DUPLICATE_KINGDOM_NAME_MSG = "Os reinos nao podem ter nomes duplicados.";
	private static final String OCCUPIED_CASTLE_MSG = "Castelo ja ocupado.";
	private static final String CASTLE_NON_EXISTANT_MSG = "Castelo nao existe.";
	private static final String NOT_ENOUGH_KINGDOMS_MSG = "Numero insuficiente de reinos criados.";
	private static final String NO_CASTLES_MSG = "Sem castelos.";
	private static final String NO_ARMY_MSG = "Sem exercito.";
	private static final String UNKNOWN_SOLDIER_TYPE_MSG = "Tipo de soldado inexistente.";
	private static final String ILLEGAL_CASTLE_INVASION_MSG = "Castelo invadido ilegalmente.";
	private static final String NO_MONEY_FOR_RECRUIT_MSG = "Riqueza insuficiente para recrutamento.";
	private static final String CASTLE_OCCUPIED_BY_SOLDIER_MSG = "Castelo nao livre.";
	private static final String END_MSG = "Obrigado por jogar. Ate a proxima.";
	
	
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
			System.out.print(G.getKingdomName(G.currentTurn()) + " " + PROMPT);
		
		String cmd = in.next().toLowerCase();
		
		return cmd;
	}
	
	private static Game executeCommand(Scanner in, String cmd, Game G) { 
			
		switch (cmd) {
		
		case NEW_GAME_CMD: G = processNewGame(in,G);break;
		
		case SOLDIER_MOVE_CMD:;
		
		case RECRUIT_CMD:processFakeRecruit(in,G);
		
		case MAP_CMD:;
		
		case CASTLES_CMD:;
		
		case ARMY_CMD:;
		
		case KINGDOM_CMD: System.out.println(INACTIVE_MSG);break;
		
		case HELP_CMD: System.out.println(Help(G));break;
			
		case LEAVE_CMD:break;
		
		default:
			System.out.println(UNKNOWN_CMD);
		}
		
		return G;
	}
	
	private static Game executeCommandGame(Scanner in,String cmd,Game G) {
		
		switch(cmd) {
		
		case NEW_GAME_CMD: G = processNewGame(in,G);break;
		
		case SOLDIER_MOVE_CMD:break;
		
		case RECRUIT_CMD:G = processRecruit(in,G);break;
		
		case MAP_CMD: System.out.println(showMap(G));break;
		
		case CASTLES_CMD:System.out.println(showCastles(G));break;
		
		case ARMY_CMD:System.out.println(showArmy(G));break;
		
		case KINGDOM_CMD:System.out.println(showKingdoms(G));break;
		
		case HELP_CMD:System.out.println(Help(G));break;
			
		case LEAVE_CMD:break;
		
		default:
			System.out.println(UNKNOWN_CMD);
		}
		
		return G;
	}
	
	private static void printErrorMsg(int error) {
		String msg = "";
		switch(error) {
		
		case Game.CASTLE_NON_EXISTANT_ERROR_N:
			msg = CASTLE_NON_EXISTANT_MSG;break;
			
		case Game.DUPLICATE_CASTLE_NAME_ERROR_N:
			msg = DUPLICATE_CASTLE_NAME_MSG;break;
			
		case Game.DUPLICATE_KINGDOM_NAME_ERROR_N:
			msg = DUPLICATE_KINGDOM_NAME_MSG;break;
			
		case Game.INVALID_N_CASTLES_ERROR_N:
			msg = INVALID_N_CASTLES_MSG;break;
			
		case Game.INVALID_N_KINGDOMS_ERROR_N:
			msg = INVALID_N_KINGDOMS_MSG;break;
			
		case Game.INVALID_POS_CASTLE_ERROR_N:
			msg = INVALID_POS_CASTLE_MSG;break;
			
		case Game.INVALID_WEALTH_ERROR_N:
			msg = INVALID_WEALTH_MSG;break;
			
		case Game.MAP_TOO_SMALL_ERROR_N:
			msg = MAP_TOO_SMALL_MSG;break;
			
		case Game.NOT_ENOUGH_CASTLES_ERROR_N:
			msg = NOT_ENOUGH_CASTLES_MSG;break;
			
		case Game.NOT_ENOUGH_KINGDOMS_ERROR_N:
			msg = NOT_ENOUGH_KINGDOMS_MSG;break;
			
		case Game.OCCUPIED_CASTLE_ERROR_N:
			msg = OCCUPIED_CASTLE_MSG;break;
			
		case Game.ILLEGAL_CASTLE_INVASION_ERROR_N:
			msg = ILLEGAL_CASTLE_INVASION_MSG;break;
			
		case Game.CASTLE_OCCUPIED_BY_SOLDIER_ERROR_N:
			msg = CASTLE_OCCUPIED_BY_SOLDIER_MSG;break;
			
		case Game.NO_MONEY_FOR_RECRUIT_ERROR_N:
			msg = NO_MONEY_FOR_RECRUIT_MSG;break;
			
		case Game.UNKNOWN_SOLDIER_TYPE_ERROR_N:
			msg = UNKNOWN_SOLDIER_TYPE_MSG;
			
		}
		System.out.println(msg);
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
		
		if(Game.validFirstLine(xmap,ymap,nKingdoms,nCastles) != Game.NO_ERRORS) {
			printErrorMsg(Game.validFirstLine(xmap,ymap,nKingdoms,nCastles));
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
			String name = in.nextLine().trim();
			
			if(G.validCastle(x,y,money,name,castlesMade) == Game.NO_ERRORS) {
				G.createCastle(x,y,money,name);
				castlesMade++;
				}
			else 
				printErrorMsg(G.validCastle(x,y,money,name,castlesMade));
			
			counter++;
			}
		
		if(castlesMade < nKingdoms) {
			G = null;
			System.out.println(NOT_ENOUGH_CASTLES_MSG);
			System.out.println(FATAL_ERROR_MSG);
			
		}
		else {

			System.out.println(nKingdoms + " reinos:");
		
			counter = 0;
			
			int kingdomsMade = 0;
			
			while(counter < nKingdoms) {
				
				String kingdomName = in.next();
				String castleName = in.nextLine().trim();

				if(G.validKingdom(kingdomName,castleName,G,kingdomsMade) == Game.NO_ERRORS) {
					G.createKingdom(kingdomName);
					G.addCastleToKingdom(kingdomName,castleName);
					kingdomsMade++;
				}
				
				else
					printErrorMsg(G.validKingdom(kingdomName,castleName,G,kingdomsMade));
				
				counter++;
			}
			
			if(kingdomsMade < 2) {
				G = null;
				System.out.println(NOT_ENOUGH_KINGDOMS_MSG);
				System.out.println(FATAL_ERROR_MSG);
			}
			else {
				G.updateNCastlesNKingdoms(castlesMade, kingdomsMade);
				System.out.println(INITIAL_MSG + G.getKingdomName(0) + ".");
				}
			}
		}
		
		return G;
	}
	
	private static String showMap(Game G) {
		String map;
		
		int xmap = G.getMaximumMapPoint().getX();
		int ymap = G.getMaximumMapPoint().getY();
		int nCastles = G.getNCastles();
		int nKingdoms =  G.getNKingdoms();

		map = xmap + " " + ymap + "\n" + 
			nCastles + " castelos:" + "\n";
		
		G.initializeIterator(Game.CASTLES_IT);
		
		while(G.hasNext(Game.CASTLES_IT)) {
			Castle c = G.nextCastle();
			map += c.getCastleName() + " (" + c.getCastleKingdomName() + ")" + "\n";
		}
		
		map += nKingdoms +" reinos:" + "\n";
		
		G.initializeIterator(Game.KINGDOMS_IT);
		
		while(G.hasNext(Game.KINGDOMS_IT)) {
			Kingdom k =  G.nextKingdom();
			if(G.hasNext(Game.KINGDOMS_IT))
				map += k.getKingdomName() + "; "; 
			else
				map += k.getKingdomName();
		}
	
		return map;
	}
	
	private static String showCastles(Game G) {
		Kingdom K = G.getKingdom(G.getKingdomName(G.currentTurn()));
		int nCastlesOwned = K.getNOwnedCastles();
		String msg = "";
		
		msg += nCastlesOwned + " castelos:" + "\n";
		
		K.initializeCastleIterator();
		
		if(nCastlesOwned > 0)
			while(K.hasNextCastle()) {
				Castle c = K.nextCastle();
				if(K.hasNextCastle())
					msg += c.getCastleName() + " com riqueza " + c.getMoney() + 
						" na posicao (" + c.getCastlePoint().getX() + "," + c.getCastlePoint().getY() + ")" + "\n";
				else
					msg += c.getCastleName() + " com riqueza " + c.getMoney() + 
					" na posicao (" + c.getCastlePoint().getX() + "," + c.getCastlePoint().getY() + ")";
					
			}
		else
			msg = NO_CASTLES_MSG;
					
		return msg;
	}
	
	private static String showArmy(Game G) {
		Kingdom K = G.getKingdom(G.currentTurn());
		int nSoldiers = K.getNSoldiers();
		String msg = "";
		
		msg += nSoldiers + " soldados:" + "\n";
		
		K.initializeArmyIterator();
		
		if(nSoldiers > 0)
			while(K.hasNextSoldier()) {
				Soldier u = K.nextSoldier();
				if(K.hasNextSoldier())
					msg += u.getSoldierType() + " na posicao (" +
							u.getSoldierPoint().getX() + "," + u.getSoldierPoint().getY() + ")" + "\n";
				else
					msg += u.getSoldierType() + " na posicao (" +
							u.getSoldierPoint().getX() + "," + u.getSoldierPoint().getY() + ")";
			}
		else
			msg = NO_ARMY_MSG;
		
		return msg;
			
	}
	
	private static String showKingdoms(Game G) {
		String msg = "";
		int nKingdoms = G.nActiveKingdoms();
		
		msg += nKingdoms + " reinos:" + "\n";
		
		
		G.initializeOrdIterator();
		
		while(G.hasNextOrd()) {
			Kingdom K = G.nextOrd();
			if(G.hasNextOrd())
				msg += K.getKingdomName() + ", " + K.getNOwnedCastles() + " castelos, " + K.getNSoldiers() + " soldados, " +
					K.totalMoney() + " de riqueza" + "\n";
			else
				msg += K.getKingdomName() + ", " + K.getNOwnedCastles() + " castelos," + " " + K.getNSoldiers() + " soldados, " +
						K.totalMoney() + " de riqueza";
		}
		
		return msg;
	}
	
	private static Game processRecruit(Scanner in, Game G) {
		String type = in.next();
		String castleName = in.nextLine().substring(1);
		Kingdom K = G.getKingdom(G.currentTurn());
		
		if(G.validRecruit(type, castleName, K) == Game.NO_ERRORS) {
			K.recruit(type, castleName);
			System.out.println(type + " recrutado no " + castleName +
					" do reino " + K.getKingdomName() + " por " + K.getCastle(castleName).recruitCost(type) + " moedas.");
		}
		else
			printErrorMsg(G.validRecruit(type, castleName, K));

		G.swapTurn();
		
		return G;
	}
	
	private static void processFakeRecruit(Scanner in, Game G) {
		in.next();
		in.nextLine();
	}
}
