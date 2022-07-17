package ui.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import controller.Controller;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProdutosTableModel extends AbstractTableModel{
    
    private ArrayList<JSONObject> data;
    private final String[] header = {"Nome", "Preco", "Tipo", "Estoque", "Descricao"};
    private Controller con;
    
    public ProdutosTableModel(Controller con) throws IllegalArgumentException{
        if(con == null) throw new IllegalArgumentException("O controlador não pode ser NULL!");
        this.con = con;
        reloadData();
    }
    
    public void reload(){
        reloadData();
        this.fireTableDataChanged();
    }
    
    private boolean reloadData(){
        data = new ArrayList<>();
        JSONArray arr;
        try {
            arr = new JSONArray(con.getProdutos());
        } catch (JsonProcessingException ex) {
            return false;
        }
        
        arr.forEach(e -> {
            JSONObject o = new JSONObject(e.toString());
            JSONObject oNew = new JSONObject();
            
            oNew.put("id", o.getLong("id"));
            oNew.put("nome", o.getString("nome"));
            oNew.put("price", o.getDouble("price"));
            oNew.put("tipo", o.getString("tipo"));
            oNew.put("estoque", o.getInt("estoque"));
            oNew.put("descricao", o.getString("descricao"));

            data.add(oNew);
        });
        return true;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int c) {
        return header[c];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JSONObject o = data.get(rowIndex);
        
        if(o != null){
            switch(columnIndex){
                case 0:
                    return o.getString("nome");
                case 1:
                    return o.getDouble("price");
                case 2:
                    return o.getString("tipo");
                case 3:
                    return o.getInt("estoque");
                case 4:
                    return o.getString("descricao");
            }
        }
        return null;
    }
    
    public void removeRow(int r){
        if(r != -1){
            this.data.remove(r);
            this.fireTableRowsDeleted(r, r);
        }
    }
    
    public JSONObject getJsonAt(int r){
        return data.get(r);
    }
    
}
