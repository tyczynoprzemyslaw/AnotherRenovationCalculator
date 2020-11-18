package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public interface Mapper<T> {



    void create (T t);
    T read (int id);
    void update (T t);
    void delete (int id);
    Set<T> findAll();

    public Map<Integer, T> loadDataToMapFromDatabase();

    T getDataFromDatabase(ResultSet result) throws SQLException;

    public void showSingleResult(Integer k, Map<Integer, T> mapMain);

    public default void ShowAllData(Map<Integer, T> mapMain) {
        System.out.println("Control - 1");
        Set<Integer> keys = mapMain.keySet();
        for (Integer k : keys) {
            System.out.println("Control " + k);
            showSingleResult(k,  mapMain);
        }
    }
}
