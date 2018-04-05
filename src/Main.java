
import br.com.generictest.facade.FuncoesFacade;

public class Main {

	private static FuncoesFacade funcoesFacade = new FuncoesFacade();
	
	public static void main(String[] args) {
		
		try {
			funcoesFacade.dataAnalysis();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
