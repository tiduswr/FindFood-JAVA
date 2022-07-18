package ui.models;

import controller.Controller;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

public class CarrinhoTableModel extends AbstractTableModel{
    
    private ArrayList<JSONObject> data;
    private final String[] header = {"Nome", "Preco"};
    private Controller con;
    
    public CarrinhoTableModel(Controller con) throws IllegalArgumentException{
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
        arr = new JSONArray(con.getProdutosCarrinho());
        
        arr.forEach(e -> {
            JSONObject o = new JSONObject(e.toString());
            JSONObject oNew = new JSONObject();
            
            oNew.put("id", o.getJSONObject("produto").getLong("id"));
            oNew.put("nome", o.getJSONObject("produto").getString("nome"));
            oNew.put("price", o.getJSONObject("produto").getDouble("price"));
            
            for(int i = 0; i < o.getInt("qtd"); i++){
                data.add(oNew);
            }
            
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
