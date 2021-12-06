package bl;

import dataAccess.DataAccess;
import dataAccess.DataAccessInterface;
import dataAccess.HibernateDataAccess;

public class FacadeBean {
	private static FacadeBean singleton = new FacadeBean();
	private static BLFacade facadeInterface;
	private static DataAccessInterface da;
	private FacadeBean() {
		try {
			da = new HibernateDataAccess();
			facadeInterface = new BLFacadeImplementation(da);
		} catch (Exception e) {
			System.out.println("FacadeBean: negozioaren logika sortzean errorea: " + e.getMessage());
		}
	}

	public static BLFacade getBusinessLogic() {
		return facadeInterface;
	}
}
