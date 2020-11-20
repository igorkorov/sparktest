package util;

import fr.roland.DB.Executor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoaderJSON {
    private Executor executor;
    public LoaderJSON(Executor executor){
        this.executor = executor;
    }
    public ArrayList<Object> loaderJSON() throws SQLException {
      ResultSet res = executor.submit("select * from test;");
      ArrayList result = new ArrayList();
      while (res.next()){
          result .add(res.getObject(2));
      }
      return result;
    };

}
